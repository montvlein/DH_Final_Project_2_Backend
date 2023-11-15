package com.dh.eventservice.api.service;

import com.dh.eventservice.api.Exceptions.ResourceNotFoundExceptions;
import com.dh.eventservice.domain.DTO.TicketTypeDto;
import com.dh.eventservice.domain.model.TicketType;

import java.util.Set;

public interface TicketTypeService {
    TicketTypeDto save(TicketTypeDto ticketTypeDto);

    TicketTypeDto findById(Integer id) throws ResourceNotFoundExceptions;

    void delete(Integer id) throws ResourceNotFoundExceptions;

    String updateStock(TicketTypeDto ticketTypeDto) throws ResourceNotFoundExceptions;

    String update(TicketTypeDto ticketTypeDto) throws ResourceNotFoundExceptions;

    Set<TicketTypeDto> getAllTicketType();
}
