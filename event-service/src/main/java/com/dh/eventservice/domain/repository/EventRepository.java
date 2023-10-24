package com.dh.eventservice.domain.repository;

import com.dh.eventservice.domain.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

	List<Event> findAllByCategory(String category);

}
