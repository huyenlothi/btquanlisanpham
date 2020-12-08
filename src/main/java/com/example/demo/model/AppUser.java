package com.example.demo.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String password;
    @ManyToOne
    @JoinColumn(name = "app_role.id")
    private AppRole roles;

    public AppRole getRoles() {
        return roles;
    }

    public void setRoles(AppRole roles) {
        this.roles = roles;
    }
}
