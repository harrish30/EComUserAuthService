package dev.harrish.EComUserAuthService.controller;

import dev.harrish.EComUserAuthService.dto.RoleRequestDTO;
import dev.harrish.EComUserAuthService.dto.RoleResponseDTO;
import dev.harrish.EComUserAuthService.exception.InvalidInputException;
import dev.harrish.EComUserAuthService.exception.RoleNotFoundException;
import dev.harrish.EComUserAuthService.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/role")
public class RoleController
{
    @Autowired
    private RoleService roleService;

    @PostMapping
    public ResponseEntity <RoleResponseDTO> createRole(@RequestBody RoleRequestDTO roleRequestDTO)
    {
        return ResponseEntity.ok(roleService.createRole(roleRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity <RoleResponseDTO> getRoleById(@PathVariable ("id") UUID id)
    {
        if(id == null)
        {
            throw new InvalidInputException("The input is not correct");
        }
        return ResponseEntity.ok(roleService.getRole(id));
    }

    @GetMapping
    public ResponseEntity <List <RoleResponseDTO>> getAllRoles()
    {
        return ResponseEntity.ok(roleService.getAllRoles());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Boolean> deleteRole(@PathVariable ("id") UUID id)
    {
        return ResponseEntity.ok(roleService.deleteRole(id));
    }
}
