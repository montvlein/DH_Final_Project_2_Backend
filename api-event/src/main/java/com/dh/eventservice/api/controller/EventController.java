package com.dh.eventservice.api.controller;

import com.dh.eventservice.api.Exceptions.ResourceNotFoundExceptions;
import com.dh.eventservice.api.service.EventService;
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
    public EventDTO findEventById(@PathVariable Integer id) throws ResourceNotFoundExceptions {
        return eventService.findById(id);
    }

    @GetMapping("/byCategoryType/{category}")
    public ResponseEntity<List<Event>> getEventByCategory(@PathVariable String category) {
        return ResponseEntity.ok().body(eventService.getListByCategory(category));
    }

    @GetMapping("/byDateTime/{dateTime}")
    public ResponseEntity<List<Event>> getEventsByDate(@PathVariable String dateTime) throws ResourceNotFoundExceptions {
        return ResponseEntity.ok().body(eventService.getListByDate(dateTime));
    }


    @GetMapping("/byCategoryId/{id}")
    public ResponseEntity<List<EventDTO>> getEventByCategoryId(@PathVariable Integer id) {
        return ResponseEntity.ok().body(eventService.getListByCategoryId(id));
    }


    @GetMapping("byName/{name}")
    public ResponseEntity<List<EventDTO>> getEventByName(@PathVariable String name) {
        return ResponseEntity.ok().body(eventService.getListByName(name));
    }

    @GetMapping("/byVenue/{venue}")
    public ResponseEntity<List<Event>> getEventsByVenue(@PathVariable String venue) {
        List<Event> events = eventService.getEventsByVenue(venue);
        return ResponseEntity.ok().body(events);
    }

    @GetMapping("/byCityAndCountry")
    public ResponseEntity<List<Event>> getEventsByCityAndCountry(
            @RequestParam String city,
            @RequestParam String country
    ) {
        return ResponseEntity.ok().body(eventService.getListByCountryAndCity(city, country));
    }

    @GetMapping("/byVenueCountry/{country}")
    public ResponseEntity<List<Event>> getEventByVenueCountry(@PathVariable String country) throws ResourceNotFoundExceptions {
        return ResponseEntity.ok().body(eventService.getListByCountry(country));
    }

    @GetMapping
    public ResponseEntity<List<EventDTO>> getAllEvents() {
        return ResponseEntity.ok().body(eventService.getAllEvents());
    }


    @PostMapping
    public ResponseEntity<?> saveEvent(@RequestBody EventDTO eventDto) {
        eventService.save(eventDto);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteEvent(@PathVariable Integer id) throws ResourceNotFoundExceptions {
        eventService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody EventDTO eventDTO) throws ResourceNotFoundExceptions {
        return ResponseEntity.ok(eventService.update(eventDTO));
    }
}
