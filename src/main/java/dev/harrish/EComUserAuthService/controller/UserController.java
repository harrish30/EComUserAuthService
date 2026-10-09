package dev.harrish.EComUserAuthService.controller;

import dev.harrish.EComUserAuthService.dto.LoginRequestDTO;
import dev.harrish.EComUserAuthService.dto.SignupRequestDTO;
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
    public ResponseEntity login(@RequestBody LoginRequestDTO loginRequestDTO)
    {
        return null;
    }

    @GetMapping("/logout")
    public ResponseEntity logout()
    {
        return null;
    }

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody SignupRequestDTO signupRequestDTO)
    {
        return null;
    }

    @GetMapping("/validate")
    public ResponseEntity validate()
    {
        return null;
    }
}
