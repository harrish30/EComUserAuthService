package dev.harrish.EComUserAuthService.controller;

import dev.harrish.EComUserAuthService.dto.LoginRequestDTO;
import dev.harrish.EComUserAuthService.dto.SignupRequestDTO;
import dev.harrish.EComUserAuthService.dto.UserResponseDTO;
import dev.harrish.EComUserAuthService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity <UserResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO)
    {
        return ResponseEntity.ok(userService.login(loginRequestDTO));
    }

    @GetMapping("/logout")
    public ResponseEntity logout(@RequestHeader ("Authorization") String authToken)
    {
        return ResponseEntity.ok(userService.logout(authToken));
    }

    @PostMapping("/signup")
    public ResponseEntity <UserResponseDTO> signup(@RequestBody SignupRequestDTO signupRequestDTO)
    {
        return ResponseEntity.ok(userService.signup(signupRequestDTO));
    }

    @GetMapping("/validate")
    public ResponseEntity <Boolean> validate(@RequestHeader ("Authorization") String authToken)
    {
        return ResponseEntity.ok(userService.validateToken(authToken));
    }
}
