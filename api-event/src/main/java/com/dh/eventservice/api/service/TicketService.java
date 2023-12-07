package com.dh.eventservice.api.service;

import com.dh.eventservice.api.Exceptions.BadRequestException;
import com.dh.eventservice.api.Exceptions.ResourceNotFoundExceptions;
import com.dh.eventservice.domain.DTO.TicketDTO;


import java.util.List;
import java.util.Set;

public interface TicketService {

    List<TicketDTO> getTicketsByUserId(Integer userId);
    List<TicketDTO> getTicketsByEventId(Integer eventId);

    List<TicketDTO> getAllTickets();

    TicketDTO save(TicketDTO ticketDTO) throws ResourceNotFoundExceptions, BadRequestException;

    void delete(Integer idTicket) throws ResourceNotFoundExceptions;

    TicketDTO findById(Integer idTicket) throws ResourceNotFoundExceptions;

    String update(TicketDTO ticketDTO) throws ResourceNotFoundExceptions;
}