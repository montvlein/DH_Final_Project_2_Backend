package com.dh.eventservice.domain.repository;

import com.dh.eventservice.domain.model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dh.eventservice.domain.DTO.VenueDTO;
import com.dh.eventservice.domain.model.Category;
import com.dh.eventservice.domain.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Integer> {
    List<Venue> findAllByCountry(String country);
}