package com.dh.eventservice.domain.repository;

import com.dh.eventservice.domain.DTO.DateTimeDTO;
import com.dh.eventservice.domain.model.DateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DateTimeRepository extends JpaRepository<DateTime, Integer> {


}
