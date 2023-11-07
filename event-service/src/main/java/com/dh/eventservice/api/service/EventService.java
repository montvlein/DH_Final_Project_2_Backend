package com.dh.eventservice.api.service;

import com.dh.eventservice.api.Exceptions.ResourceNotFoundExceptions;
import com.dh.eventservice.domain.DTO.CategoryDto;
import com.dh.eventservice.domain.DTO.EventDTO;
import com.dh.eventservice.domain.model.Event;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface EventService {

	List<Event> getListByCategory(String category);
    List<EventDTO> getListByCountry (String country);
    List<EventDTO> getListByCountryAndCity(String country, String city);
    List<EventDTO> getListByCategoryId(Integer id);
    List<EventDTO> getListByVenue(String venue);
    List<EventDTO> getAllEvents();
    EventDTO save(EventDTO eventDto);
    EventDTO findById(Integer id) throws ResourceNotFoundExceptions;
    void delete(Integer id) throws ResourceNotFoundExceptions;
    String update(EventDTO eventDTO) throws ResourceNotFoundExceptions;

   List<Event> getListByDate (String dateTime) throws ResourceNotFoundExceptions;
}
