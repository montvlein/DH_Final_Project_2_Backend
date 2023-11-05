package com.DH.apiuser.domain.model;

import com.DH.apiuser.util.DocumentType;
import com.DH.apiuser.util.Role;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "users")
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //@NotBlank(message = "El campo 'firstname' es requerido")
    private String firstName;
    //@NotBlank(message = "El campo 'lastname' es requerido")
    private String lastName;
    //@NotBlank(message = "El campo 'mail' es requerido")
    private String mail;
    //@NotBlank(message = "El campo 'password' es requerido")
    private String password;
    @Column(nullable = true)
    private String birthDate;
    @Column(nullable = true)
    private int phone;
    @Column(nullable = true)
    private String role;
    @Column(nullable = true)
    private String idType;
    @Column(nullable = true)
    private int idNumber;

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

