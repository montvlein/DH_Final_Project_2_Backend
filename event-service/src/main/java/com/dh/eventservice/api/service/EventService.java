package com.dh.eventservice.api.service;

import com.dh.eventservice.domain.model.Event;

import java.util.List;

public interface EventService {

	List<Event> getListByCategory(String category);

    List<Event> getAllEvents();

    Event save(Event event);

}
