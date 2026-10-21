package dev.harrish.EComUserAuthService.service;

import dev.harrish.EComUserAuthService.dto.RoleRequestDTO;
import dev.harrish.EComUserAuthService.dto.RoleResponseDTO;
import dev.harrish.EComUserAuthService.exception.RoleNotFoundException;

import java.util.List;
import java.util.UUID;

public interface RoleService
{
    RoleResponseDTO getRole(UUID roleID) throws RoleNotFoundException;
    List<RoleResponseDTO> getAllRoles();
    RoleResponseDTO createRole(RoleRequestDTO roleRequestDTO);
    boolean deleteRole(UUID roleID);
}
