package com.dh.eventservice.api.controller;

import com.dh.eventservice.api.service.EventService;
import com.dh.eventservice.domain.DAO.EventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

	@Autowired
	private EventService eventService;

	@GetMapping("/{category}")
	public ResponseEntity<List<EventDTO>> getEventByCategory(@PathVariable String category) {
		return ResponseEntity.ok().body(eventService.getListByCategory(category));
	}

	@GetMapping("/{venue}")
	public ResponseEntity<List<EventDTO>> getEventByVenue(@PathVariable String venue) {
		return ResponseEntity.ok().body(eventService.getListByVenue(venue));
	}

	@GetMapping
	public ResponseEntity<List<EventDTO>> getAllEvents() {
		return ResponseEntity.ok().body(eventService.getAllEvents());
	}

	@PostMapping
	public ResponseEntity<EventDTO> saveEvent(@RequestBody EventDTO eventDto) {
		return ResponseEntity.ok().body(eventService.save(eventDto));
	}
}
