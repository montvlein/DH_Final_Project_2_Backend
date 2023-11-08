package com.DH.apiuser.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String mail;
    private String birthDate;
    private int phone;
    private String role;
    private String idType;
    private int idNumber;
}
