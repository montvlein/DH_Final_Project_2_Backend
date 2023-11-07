package com.DH.apiuser.domain.DTO;

import com.DH.apiuser.util.Role;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    private Integer id;
    private String firstname;
    private String lastname;
    private String mail;
    private String password;
}
