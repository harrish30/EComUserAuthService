package dev.harrish.EComUserAuthService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "ECOM_USER")
@Getter
@Setter
public class User extends BaseModel
{
    private String name;
    private String email;
    private String password; //won't store actual password
    @ManyToMany
    private List <Role> roles;
}
