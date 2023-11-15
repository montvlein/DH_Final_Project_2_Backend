package com.DH.apiuser.domain.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Entity
@Table(name = "users")
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "El campo 'firstname' es requerido")
    private String firstName;
    @NotBlank(message = "El campo 'lastname' es requerido")
    private String lastName;
    @NotBlank(message = "El campo 'mail' es requerido")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "El campo debe ser un correo electrónico válido")
    private String mail;
    private String password;
    @Column(nullable = true)
    private String birthDate;
    @Column(nullable = true)
    private String phone;
    @Column(nullable = true)
    private String role;
    @Column(nullable = true)
    private String documentType;
    @Column(nullable = true)
    private String documentNumber;

    public User(String firstName, String lastName, String mail, String password, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.password = password;
        this.role = role;
    }

    public User(String firstName, String lastName, String mail, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.password = password;
    }

    public User() {
    }
}

