package com.dh.eventservice.api.service;

import com.dh.eventservice.api.Exceptions.ResourceNotFoundExceptions;
import com.dh.eventservice.domain.DTO.DateTimeDTO;
import com.dh.eventservice.domain.model.DateTime;

import java.time.LocalDateTime;
import java.util.List;

public interface DateTimeService {

    DateTimeDTO save(DateTimeDTO dateTimeDTO);
    DateTimeDTO findById(Integer id) throws ResourceNotFoundExceptions;
    List<DateTimeDTO> getAllDates();
    void delete(Integer id) throws ResourceNotFoundExceptions;
    String update(DateTimeDTO dateTimeDTO) throws ResourceNotFoundExceptions;

    /*List<DateTime> findAllByDate(LocalDateTime date);*/


}
