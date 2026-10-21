package dev.harrish.EComUserAuthService.dto;

import dev.harrish.EComUserAuthService.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleResponseDTO
{
    private String roleName;
    private String description;

    public static RoleResponseDTO from(Role role)
    {
        RoleResponseDTO roleResponseDTO = new RoleResponseDTO();
        roleResponseDTO.setRoleName(role.getRoleName());
        roleResponseDTO.setDescription(role.getDescription());
        return roleResponseDTO;
    }
}
