package com.dh.eventservice.api.service.impl;

import com.dh.eventservice.api.config.ModelMapperConfig;
import com.dh.eventservice.api.service.EventService;
import com.dh.eventservice.domain.DTO.EventDTO;
import com.dh.eventservice.domain.model.Event;
import com.dh.eventservice.domain.repository.EventRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
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

	@Autowired
	private ModelMapperConfig mapper;

	@Autowired
	private ObjectMapper obmapper;




	@Override
	public List<EventDTO> getListByCategory(String category) {
		List<Event> events = eventRepository.findAllByCategory(category);

		logger.info("Se listaron los eventos de categoria: {}", category);

		return mapper.getModelMapper().map(events, List.class);

	}

	@Override
	public List<EventDTO> getListByVenue(String venue) {
		List<Event>  events = eventRepository.findAllByVenue(venue);

		logger.info("Se listaron los eventos del recinto: {}", venue);
		return mapper.getModelMapper().map(events, List.class);
	}

	@Override
	public List<EventDTO> getAllEvents() {
		List<Event> events = eventRepository.findAll();

		logger.info("Se listaron todos los eventos");

		return mapper.getModelMapper().map(events, List.class);

	}

	@Override
	public EventDTO save(EventDTO eventDto) {

		Event event = mapper.getModelMapper().map(eventDto, Event.class);
		eventRepository.save(event);

		logger.info("Se guardó el evento: {}", event);

		return mapper.getModelMapper().map(eventRepository.save(event), EventDTO.class);

	}
}
