package com.dh.eventservice.api.service;

import com.dh.eventservice.domain.DTO.EventDTO;

import java.util.List;

public interface EventService {

	List<EventDTO> getListByCategory(String category);

    List<EventDTO> getListByVenue(String venue);

    List<EventDTO> getAllEvents();

    EventDTO save(EventDTO eventDto);

}
