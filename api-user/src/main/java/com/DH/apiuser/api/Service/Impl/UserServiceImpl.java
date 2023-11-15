package com.DH.apiuser.api.Service.Impl;

import com.DH.apiuser.api.Service.IUserService;
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

import static com.DH.apiuser.util.PasswordValidator.isValidPassword;


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
        if (isValidPassword(usuario.getPassword())) {
            usuario.setPassword(encoder.encode(usuario.getPassword()));
        } else {
            throw new BadRequestException("la contraseña no cumple con los requisitos");
        }
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
    public UserResponseDto addProfileData(Integer id, User usuario) throws ResourceNotFoundExceptions {
        Optional<User> updateUser = userRepository.findById(id);
        if (userRepository.findById(id) == null) {
            throw new ResourceNotFoundExceptions("No existe el usuario");
        }
        User userDto = mapper.convertValue(updateUser, User.class);
        if (usuario.getFirstName() != null) {
            userDto.setFirstName(usuario.getFirstName());
        }
        if (usuario.getLastName() != null) {
            userDto.setLastName(usuario.getLastName());
        }
        if (usuario.getBirthDate() != null) {
            userDto.setBirthDate(usuario.getBirthDate());
        }
        if (usuario.getPhone() != null) {
            userDto.setPhone(usuario.getPhone());
        }
        if (usuario.getDocumentNumber() != null) {
            userDto.setDocumentNumber(usuario.getDocumentNumber().replaceAll("[.-]", ""));
        }

        if (usuario.getDocumentType() != null) {
            userDto.setDocumentType(usuario.getDocumentType().toUpperCase());
        }

        User savedUser = userRepository.save(userDto);
        return mapper.convertValue(savedUser, UserResponseDto.class);

    }

    @Override
    public UserResponseDto findByMail(String email) {
        return mapper.convertValue(userRepository.findByMail(email), UserResponseDto.class);
    }

    public String updatePassword(Integer id, String currentPassword, String newPassword) throws BadRequestException, ResourceNotFoundExceptions {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            logger.info(user.toString());
            // Verificar que la contraseña actual coincida
            if (!encoder.matches(currentPassword, user.getPassword())) {
                throw new BadRequestException("La contraseña actual no es válida.");
            }

            // Verificar y actualizar la nueva contraseña
            if (isValidPassword(newPassword)) {
                user.setPassword(encoder.encode(newPassword));
                userRepository.save(user);
                return "Contraseña actualizada correctamente.";
            } else {
                throw new BadRequestException("La nueva contraseña no cumple con los requisitos.");
            }
        } else {
            throw new ResourceNotFoundExceptions("Usuario no encontrado.");
        }
    }

}
