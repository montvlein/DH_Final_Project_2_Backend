package com.dh.eventservice.domain.repository;



import com.dh.eventservice.domain.DTO.EventDTO;
import com.dh.eventservice.domain.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

	List<Event> findAllByCategoryDescription(String category);

	List<Event> findAllByCategoryId(Integer id);

	List<Event> findAllByVenue(String venue);

	List<EventDTO> getListByCountry (String country);

	List<EventDTO> getListByCountryAndCity(String country, String city);

}
