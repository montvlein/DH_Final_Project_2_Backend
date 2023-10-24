package com.dh.eventservice.api.controller;

import com.dh.eventservice.api.service.EventService;
import com.dh.eventservice.domain.model.Event;
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
	public ResponseEntity<List<Event>> getEventByCategory(@PathVariable String category) {
		return ResponseEntity.ok().body(eventService.getListByCategory(category));
	}

	@GetMapping
	public ResponseEntity<List<Event>> getAllEvents() {
		return ResponseEntity.ok().body(eventService.getAllEvents());
	}

	@PostMapping
	public ResponseEntity<Event> saveEvent(@RequestBody Event event) {
		return ResponseEntity.ok().body(eventService.save(event));
	}
}
