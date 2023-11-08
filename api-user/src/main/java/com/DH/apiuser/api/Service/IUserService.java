package com.DH.apiuser.api.Service;

import com.DH.apiuser.domain.DTO.UserRequestDto;
import com.DH.apiuser.domain.DTO.UserResponseDto;
import com.DH.apiuser.domain.model.User;
import com.DH.apiuser.util.Exceptions.BadRequestException;
import com.DH.apiuser.util.Exceptions.ResourceNotFoundExceptions;


import java.util.Optional;
import java.util.Set;

public interface IUserService {

    UserResponseDto save(User usuario) throws BadRequestException;

    public UserResponseDto findById(Integer id) throws ResourceNotFoundExceptions; //throws ResourceNotFoundExceptions;

    public Set<UserResponseDto> FindAll();

    public void delete(Integer id) throws ResourceNotFoundExceptions;// throws ResourceNotFoundExceptions;

    public UserResponseDto addProfileData(Integer id, User usuario) throws ResourceNotFoundExceptions;

    public UserResponseDto findByMail(String email);


}
