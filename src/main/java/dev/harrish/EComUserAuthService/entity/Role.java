package dev.harrish.EComUserAuthService.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "ECOM_ROLE")
@Getter
@Setter
public class Role extends BaseModel
{
    private String roleName;
    private String description;
}
