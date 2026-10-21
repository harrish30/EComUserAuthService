package dev.harrish.EComUserAuthService.service;

import dev.harrish.EComUserAuthService.dto.RoleRequestDTO;
import dev.harrish.EComUserAuthService.dto.RoleResponseDTO;
import dev.harrish.EComUserAuthService.entity.Role;
import dev.harrish.EComUserAuthService.exception.RoleNotFoundException;
import dev.harrish.EComUserAuthService.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class RoleServiceImpl implements RoleService
{
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RoleResponseDTO getRole(UUID roleID)
    {
        Role role = roleRepository.findById(roleID).orElseThrow(
                () -> new RoleNotFoundException("Role not found")
        );
        return RoleResponseDTO.from(role);
    }

    @Override
    public List<RoleResponseDTO> getAllRoles()
    {
        List <Role> roles = roleRepository.findAll();
        List<RoleResponseDTO> roleResponseDTOS = new ArrayList<>();
        for(Role role: roles)
        {
            roleResponseDTOS.add(RoleResponseDTO.from(role));
        }
        return roleResponseDTOS;
    }

    @Override
    public RoleResponseDTO createRole(RoleRequestDTO roleRequestDTO)
    {
        Role role = new Role();
        role.setRoleName(roleRequestDTO.getRoleName());
        role.setDescription(roleRequestDTO.getRoleDescription());
        roleRepository.save(role);
        return RoleResponseDTO.from(role);
    }

    @Override
    public boolean deleteRole(UUID roleID)
    {
        roleRepository.deleteById(roleID);
        return true;
    }
}
