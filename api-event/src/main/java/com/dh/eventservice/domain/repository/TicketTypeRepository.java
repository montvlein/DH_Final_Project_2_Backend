package com.dh.eventservice.domain.repository;

import com.dh.eventservice.domain.model.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TicketTypeRepository extends JpaRepository<TicketType, Integer> {

}
