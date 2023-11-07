package com.DH.apiuser.Security;


import com.DH.apiuser.domain.DTO.UserRequestDto;
import com.DH.apiuser.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service

public class UserServiceSecurity implements UserDetailsService {

    @Autowired
    private UserRepository userRespository;

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //Debemos traer un Usuario basado en un string q recibe
        com.DH.apiuser.domain.model.User usuario = userRespository.findByMail(s);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario o Paswword inválido");
        }

        // Antes le asignabamos manualmente un rol
        //List<GrantedAuthority> roles = new ArrayList<>();
        //roles.add(new SimpleGrantedAuthority("ADMIN"));

        // Ahora se lo asignamos
        // Armamos un User de spring secutiry con nuestros datos del modelo Usuario
        // username, password y roles del usuario que quiere iniciar sesión
        UserDetails userDetail = new User(usuario.getMail(), usuario.getPassword(), getAuthorities(usuario));

        return userDetail;
    }

    public static Set<? extends GrantedAuthority> getAuthorities(com.DH.apiuser.domain.model.User retrievedUser) {
        String rol = retrievedUser.getRole();
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        // Si tuvieramos un Usuario con muchos roles haríamos el forEach
        //roles.forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName())));
        authorities.add(new SimpleGrantedAuthority("ROLE_" + rol));
        return authorities;
    }
}
