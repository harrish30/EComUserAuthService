package dev.harrish.EComUserAuthService.service;

import dev.harrish.EComUserAuthService.dto.LoginRequestDTO;
import dev.harrish.EComUserAuthService.dto.SignupRequestDTO;
import dev.harrish.EComUserAuthService.dto.UserResponseDTO;
import dev.harrish.EComUserAuthService.exception.RoleNotFoundException;

public interface UserService
{
    UserResponseDTO signup(SignupRequestDTO signupRequestDTO) throws RoleNotFoundException;
    UserResponseDTO login(LoginRequestDTO loginRequestDTO);
    boolean validateToken(String token);
    boolean logout(String token);
}
