package com.DH.apiuser.Security.DTO;

public class AuthenticationResponseDTO {
    private String jwt;


    public AuthenticationResponseDTO(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
