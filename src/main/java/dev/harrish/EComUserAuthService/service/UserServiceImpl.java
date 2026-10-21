package dev.harrish.EComUserAuthService.service;

import dev.harrish.EComUserAuthService.dto.LoginRequestDTO;
import dev.harrish.EComUserAuthService.dto.SignupRequestDTO;
import dev.harrish.EComUserAuthService.dto.UserResponseDTO;
import dev.harrish.EComUserAuthService.entity.Role;
import dev.harrish.EComUserAuthService.entity.User;
import dev.harrish.EComUserAuthService.exception.InvalidCredentialException;
import dev.harrish.EComUserAuthService.exception.RoleNotFoundException;
import dev.harrish.EComUserAuthService.exception.UserNotFoundException;
import dev.harrish.EComUserAuthService.repository.RoleRepository;
import dev.harrish.EComUserAuthService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserResponseDTO signup(SignupRequestDTO signupRequestDTO)
    {
        Role role = roleRepository.findById(signupRequestDTO.getRoleId()).orElseThrow(
                () -> new RoleNotFoundException("Role not found")
        );
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user = new User();
        user.setName(signupRequestDTO.getName());
        user.setEmail(signupRequestDTO.getEmail());
        user.setPassword(encoder.encode(signupRequestDTO.getPassword()));
        user.setRoles(List.of(role));
        return UserResponseDTO.from(userRepository.save(user));
    }

    @Override
    public UserResponseDTO login(LoginRequestDTO loginRequestDTO)
    {
        User savedUser = userRepository.findByEmail(loginRequestDTO.getEmail()).orElseThrow(
                () -> new UserNotFoundException("User not found")
        );
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(encoder.matches(loginRequestDTO.getPassword(), savedUser.getPassword()))
        {
            String userData = savedUser.getEmail() + savedUser.getPassword() + LocalDateTime.now();
            String token = encoder.encode(userData);
            savedUser.setToken(token);
        }
        else
        {
            throw new InvalidCredentialException("Invalid Credentials");
        }
        userRepository.save(savedUser);
        return UserResponseDTO.from(savedUser);
    }

    @Override
    public boolean validateToken(String token)
    {
        User savedUser = userRepository.findByToken(token).orElseThrow(
                () -> new InvalidCredentialException("Token is not valid")
        );
        return true;
    }

    @Override
    public boolean logout(String token)
    {
        User savedUser = userRepository.findByToken(token).orElseThrow(
                () -> new InvalidCredentialException("Token is not valid")
        );
        savedUser.setToken(null);
        userRepository.save(savedUser);
        return true;
    }
}
