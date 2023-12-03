package com.dh.eventservice.domain.repository;

import com.dh.eventservice.domain.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{

    List<Ticket> findAllByIdUser(int idUser);
    List<Ticket> findAllByEvent_Id(int idEvent);
}
