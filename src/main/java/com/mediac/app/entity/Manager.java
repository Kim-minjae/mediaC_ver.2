package com.mediac.app.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mediac.app.config.SecurityConfig;
import lombok.Data;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data //@Data is a Project Lombok annotation to autogenerate getters, setters, constructors, toString, hash, equals, and other things. It cuts down on the boilerplate.
@ToString(exclude = "password") //@ToString(exclude = "password") ensures that the Lombok-generated toString() method will NOT print out the password.
@Entity //@Entity is a JPA annotation that denotes the whole class for storage in a relational table.
public class Manager {

    public static final PasswordEncoder PASSWORD_ENCODER = new SecurityConfig.MyPasswordEncoder();

    private @Id @GeneratedValue Long id;

    private String name;

    private @JsonIgnore String password; //@JsonIgnore applied to the password field protects from Jackson serializing this field.

    private String[] roles;

    public void setPassword(String password) {
        this.password = PASSWORD_ENCODER.encode(password);
    }

    public Manager(String name, String password, String... roles) {
        this.name = name;
        this.setPassword(password);
        this.roles = roles;
    }
}
