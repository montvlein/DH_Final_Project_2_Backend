package com.DH.apiuser.api.Service;

import com.DH.apiuser.domain.DTO.UserRequestDto;
import com.DH.apiuser.domain.DTO.UserResponseDto;
import com.DH.apiuser.domain.model.User;
import com.DH.apiuser.util.Exceptions.ResourceNotFoundExceptions;


import java.util.Set;

public interface IUserService {

    UserResponseDto save(User usuario);

    public UserResponseDto findById(Integer id) throws ResourceNotFoundExceptions; //throws ResourceNotFoundExceptions;
    public Set<UserResponseDto> FindAll();
    public void delete (Integer id) throws ResourceNotFoundExceptions;// throws ResourceNotFoundExceptions;
    public void update(UserRequestDto usuarioDTO);
    public UserResponseDto findByMail(String email);


}
