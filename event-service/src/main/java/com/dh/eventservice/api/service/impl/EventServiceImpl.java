package com.dh.eventservice.api.service.impl;

import com.dh.eventservice.api.service.EventService;
import com.dh.eventservice.domain.model.Event;
import com.dh.eventservice.domain.repository.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

	private static final Logger logger = LoggerFactory.getLogger(EventServiceImpl.class);

	@Autowired
	private EventRepository eventRepository;


	@Override
	public List<Event> getListByCategory(String category) {

		logger.info("Se listaron los eventos de categoria: {}", category);

		return eventRepository.findAllByCategory(category);

	}

	@Override
	public List<Event> getAllEvents() {

		logger.info("Se listaron todos los eventos");

		return eventRepository.findAll();

	}

	@Override
	public Event save(Event event) {

		Event savedEvent = eventRepository.save(event);

		logger.info("Se guardó el evento: {}", savedEvent);

		return savedEvent;

	}
}
