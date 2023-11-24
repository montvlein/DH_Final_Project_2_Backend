package com.dh.eventservice.domain.repository;

import com.dh.eventservice.domain.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{
}
