package com.DH.apiuser.api.Service.Impl;

import com.DH.apiuser.api.Service.IUserService;
import com.DH.apiuser.domain.DTO.UserRequestDto;
import com.DH.apiuser.domain.DTO.UserResponseDto;
import com.DH.apiuser.domain.model.User;
import com.DH.apiuser.domain.repository.UserRepository;
import com.DH.apiuser.util.Exceptions.BadRequestException;
import com.DH.apiuser.util.Exceptions.ResourceNotFoundExceptions;
import com.DH.apiuser.util.Role;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.istack.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class UserServiceImpl implements IUserService {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public UserResponseDto save(User usuario) throws BadRequestException {
        if (userRepository.findByMail(usuario.getMail()) != null) {
            throw new BadRequestException("El usuario ya existe!");
        }
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        if (usuario.getRole() == null) {
            usuario.setRole(String.valueOf(Role.USER));
        }
        userRepository.save(usuario);
        UserResponseDto usuarioGuardado = mapper.convertValue(usuario, UserResponseDto.class);
        return usuarioGuardado;
    }

    @Override
    public UserResponseDto findById(Integer id) throws ResourceNotFoundExceptions {
        Optional<User> usuario = userRepository.findById(id);
        UserResponseDto userDto = null;
        if (usuario.isPresent()) {
            userDto = mapper.convertValue(usuario, UserResponseDto.class);
        } else {
            throw new ResourceNotFoundExceptions("No existe el usuario buscado");
        }
        return userDto;
    }


    @Override
    public Set<UserResponseDto> FindAll() {
        List<User> usuarios = userRepository.findAll();
        Set<UserResponseDto> usuarioDTOS = new HashSet<>();
        for (User u : usuarios) {
            usuarioDTOS.add(mapper.convertValue(u, UserResponseDto.class));
        }
        return usuarioDTOS;
    }

    @Override
    public void delete(Integer id) throws ResourceNotFoundExceptions {
        if (userRepository.findById(id) == null) {
            throw new ResourceNotFoundExceptions("No existe el usuario que desea eñliminar");
        } else {
            userRepository.deleteById(id);
            logger.info("Se elimino correctamente el ususario con id " + id);
        }

    }

    @Override
    public User update(Integer id, User usuario) {

        return null;
    }

    @Override
    public UserResponseDto findByMail(String email) {
        return mapper.convertValue(userRepository.findByMail(email), UserResponseDto.class);
    }


}
