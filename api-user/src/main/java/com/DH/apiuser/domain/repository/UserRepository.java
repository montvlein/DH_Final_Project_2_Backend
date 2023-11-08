package com.DH.apiuser.domain.repository;

import com.DH.apiuser.domain.DTO.UserResponseDto;
import com.DH.apiuser.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByMail(String mail);
}
