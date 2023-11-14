package com.dh.eventservice.domain.repository;


import com.dh.eventservice.domain.DTO.EventDTO;
import com.dh.eventservice.domain.model.DateTime;
import com.dh.eventservice.domain.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    List<Event> findAllByCategoryDescription(String category);

    List<Event> findAllByCategoryId(Integer id);

    List<EventDTO> findAllByName(String name);

    @Query(value = "SELECT * FROM events e " +
            "INNER JOIN dates d ON e.id = d.event_id " +
            "WHERE DATE(d.date_time) = ?1", nativeQuery = true)
    List<Event> findAllByDateList(String date);

    @Query("SELECT e FROM Event e JOIN e.venue v WHERE v.venue = :venue")
    List<Event> findEventsByVenue(@Param("venue") String venue);

    @Query("SELECT e FROM Event e WHERE e.venue.country = ?1")
    List<Event> findEventsByCountry(String country);


    @Query("SELECT e FROM Event e WHERE e.venue.city = ?1 AND e.venue.country = ?2")
    List<Event> findEventsByCityAndCountry(String city, String country);


}
