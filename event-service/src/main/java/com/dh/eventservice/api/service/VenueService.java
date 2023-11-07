package com.dh.eventservice.api.service;
import com.dh.eventservice.api.Exceptions.ResourceNotFoundExceptions;
import com.dh.eventservice.domain.DTO.VenueDTO;
import com.dh.eventservice.domain.model.Venue;
import com.dh.eventservice.domain.model.Event;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Set;
public interface VenueService {

    Set<VenueDTO> getVenuesByCountry(String country);

    Set<VenueDTO> getAllVenues();

    VenueDTO save(VenueDTO venueDTO);

    void delete(Integer idVenue) throws ResourceNotFoundExceptions;

    VenueDTO findById(Integer idVenue) throws ResourceNotFoundExceptions;

    ResponseEntity update(VenueDTO venueDTO);
}
