package com.dh.eventservice.api.service;

import com.dh.eventservice.domain.DAO.EventDTO;
import com.dh.eventservice.domain.model.Event;

import java.util.List;

public interface EventService {

	List<EventDTO> getListByCategory(String category);

    List<EventDTO> getListByVenue(String venue);

    List<EventDTO> getAllEvents();

    EventDTO save(EventDTO eventDto);

}
