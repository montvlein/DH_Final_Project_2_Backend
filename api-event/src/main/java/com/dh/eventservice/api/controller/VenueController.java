package com.dh.eventservice.api.controller;

import com.dh.eventservice.api.Exceptions.ResourceNotFoundExceptions;
import com.dh.eventservice.api.service.VenueService;
import com.dh.eventservice.domain.DTO.EventDTO;
import com.dh.eventservice.domain.DTO.VenueDTO;
import com.dh.eventservice.domain.model.Venue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import com.dh.eventservice.domain.model.Event;
import java.util.List;

@RestController
@RequestMapping("event/venue")
public class VenueController {

    @Autowired
    private VenueService venueService;

    //Registrar Recinto
    @PostMapping
    public ResponseEntity<?> addVenue(@RequestBody VenueDTO venueDTO) {
        venueService.save(venueDTO);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    //Buscar por ID

    @GetMapping("/{id}")
    public VenueDTO findVenueId(@PathVariable Integer id) throws ResourceNotFoundExceptions {
        return venueService.findById(id);
    }

    //lista recintos por pais
    @GetMapping("/country/{country}")
    public ResponseEntity<Set<VenueDTO>> getVenueByDescription(@PathVariable String country) {
        Set<VenueDTO> venues= venueService.getVenuesByCountry(country);
        return ResponseEntity.ok(venues);

    }

    //Listar todas las venues
    @GetMapping
    public ResponseEntity<Set<VenueDTO>> listVenue(){
        Set<VenueDTO> venues= venueService.getAllVenues();
        return ResponseEntity.ok(venues);
    }

    //Eliminar por id
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteVenue(@PathVariable Integer id) throws ResourceNotFoundExceptions {
        venueService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    //Actualizar recinto
    @PutMapping
    public ResponseEntity<String> update(@RequestBody VenueDTO venueDTO) throws ResourceNotFoundExceptions {
        return ResponseEntity.ok(venueService.update(venueDTO));
    }

}
