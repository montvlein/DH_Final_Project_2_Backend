package com.dh.eventservice.api.controller;

import com.dh.eventservice.api.Exceptions.ResourceNotFoundExceptions;
import com.dh.eventservice.api.service.EventService;
import com.dh.eventservice.domain.DTO.CategoryDto;
import com.dh.eventservice.domain.DTO.EventDTO;
import com.dh.eventservice.domain.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

	@Autowired
	private EventService eventService;


	@GetMapping("/{id}")
	public EventDTO findEventById(@PathVariable Integer id) throws ResourceNotFoundExceptions{
		return eventService.findById(id);
	}

	@GetMapping("/categoryType/{category}")
	public ResponseEntity<List<Event>> getEventByCategory(@PathVariable String category) {
		return ResponseEntity.ok().body(eventService.getListByCategory(category));
	}

	@GetMapping("/category/{id}")
	public ResponseEntity<List<EventDTO>> getEventByCategoryId(@PathVariable Integer id) {
		return ResponseEntity.ok().body(eventService.getListByCategoryId(id));
	}

	@GetMapping("/venueType/{venue}")
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

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteEvent(@PathVariable Integer id) throws ResourceNotFoundExceptions {
		eventService.delete(id);
		return ResponseEntity.ok(HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody EventDTO eventDTO) throws ResourceNotFoundExceptions{
		return ResponseEntity.ok(eventService.update(eventDTO));
	}
}
