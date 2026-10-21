package dev.harrish.EComUserAuthService.dto;

import dev.harrish.EComUserAuthService.entity.Role;
import dev.harrish.EComUserAuthService.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserResponseDTO
{
    private String name;
    private String email;
    private List <RoleResponseDTO> roles;
    private String token;

    public static UserResponseDTO from(User user)
    {
        if(user == null)
            return null;
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setName(user.getName());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setToken(user.getToken());
        List <RoleResponseDTO> roleResponseDTOList = new ArrayList <> ();
        //convert to lambda and stream
        for(Role role: user.getRoles())
        {
            RoleResponseDTO roleResponseDTO = new RoleResponseDTO();
            roleResponseDTO.setRoleName(role.getRoleName());
            roleResponseDTO.setDescription(role.getDescription());
            roleResponseDTOList.add(roleResponseDTO);
        }
        userResponseDTO.setRoles(roleResponseDTOList);
        return userResponseDTO;
    }

    public static User from(UserResponseDTO userResponseDTO)
    {
        return null;
    }
}
