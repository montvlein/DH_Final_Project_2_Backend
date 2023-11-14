package com.DH.apiuser.api.Controller;


import com.DH.apiuser.Security.DTO.AuthenticationRequestDTO;
import com.DH.apiuser.Security.DTO.AuthenticationResponseDTO;
import com.DH.apiuser.Security.JwtUtil;

import com.DH.apiuser.Security.UserServiceSecurity;
import com.DH.apiuser.api.Service.IUserService;
import com.DH.apiuser.domain.DTO.UserRequestDto;
import com.DH.apiuser.domain.DTO.UserResponseDto;
import com.DH.apiuser.domain.model.User;
import com.DH.apiuser.util.Exceptions.BadRequestException;
import com.DH.apiuser.util.Exceptions.ResourceNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceSecurity userDetailsService;

    @Autowired
    private IUserService userService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<?> addUser(@Validated @RequestBody User usuario) throws BadRequestException {
        UserResponseDto usuarioNuevo = userService.save(usuario);
        UserDetails detalle = userDetailsService.loadUserByUsername(usuarioNuevo.getMail());
        String jwt = jwtTokenUtil.generateToken(detalle, usuarioNuevo);
        return ResponseEntity.status(HttpStatus.CREATED).body(new AuthenticationResponseDTO(jwt));
    }

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequestDTO authDTO) throws BadCredentialsException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authDTO.getEmail(), authDTO.getPassword()));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Nombre usuario o contraseña incorrecta", e);
        }
        UserDetails detalle = userDetailsService.loadUserByUsername(authDTO.getEmail());
        UserResponseDto usuarioAuth = userService.findByMail(authDTO.getEmail());
        String jwt = jwtTokenUtil.generateToken(detalle, usuarioAuth);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new AuthenticationResponseDTO(jwt));
    }

    @GetMapping("/dataUser")
    public UserResponseDto datosUsuarioAut(@RequestHeader(name = "token") String jwt) {
        return userService.findByMail(jwtTokenUtil.extractUserName(jwt));
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PatchMapping("/profile/{id}")
    public ResponseEntity<UserResponseDto> profileUser(@PathVariable Integer id, @RequestBody User updatedUser) throws ResourceNotFoundExceptions {
        UserResponseDto updated = userService.addProfileData(id, updatedUser);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public UserResponseDto findUserById(@PathVariable Integer id) throws ResourceNotFoundExceptions {
        return userService.findById(id);
    }


    @GetMapping
    public ResponseEntity<Set<UserResponseDto>> allUsers() {
        Set<UserResponseDto> listarUsuarios = userService.FindAll();
        return ResponseEntity.ok(listarUsuarios);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Integer id) throws ResourceNotFoundExceptions {
        userService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PatchMapping("/updatePassword")
    public ResponseEntity<String> updatePassword(@RequestHeader(name = "token") String jwt, @RequestBody Map<String, String> passwordData) throws BadRequestException, ResourceNotFoundExceptions {
        String currentPassword = passwordData.get("currentPassword");
        String newPassword = passwordData.get("newPassword");
        String result = userService.updatePassword(jwtTokenUtil.extractUserId(jwt), currentPassword, newPassword);
        return ResponseEntity.ok(result);

    }
}
