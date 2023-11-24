package com.dh.eventservice.api.service.impl;

import com.dh.eventservice.api.Exceptions.ResourceNotFoundExceptions;
import com.dh.eventservice.api.config.ModelMapperConfig;
import com.dh.eventservice.api.service.TicketService;
import com.dh.eventservice.domain.DTO.TicketDTO;
import com.dh.eventservice.domain.DTO.TicketTypeDto;
import com.dh.eventservice.domain.model.Ticket;
import com.dh.eventservice.domain.model.TicketType;
import com.dh.eventservice.domain.repository.TicketRepository;
import com.dh.eventservice.domain.repository.TicketTypeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    private static final Logger logger = LoggerFactory.getLogger(TicketServiceImpl.class);

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ModelMapperConfig mapper;

    @Autowired
    private ObjectMapper obmapper;
    @Override
    public List<TicketDTO> getTicketsByUserId(Integer userId) {
        return null;
    }

    @Override
    public List<TicketDTO> getAllTickets() {

        List<Ticket> tickets = ticketRepository.findAll();
        List<TicketDTO> ticketsDTO = new ArrayList<>();

        for (Ticket ticket : tickets){
            ticketsDTO.add(obmapper.convertValue(ticket, TicketDTO.class));
        }
        logger.info("Se listaron todos los tickets");

        return ticketsDTO;
    }

    @Override
    public TicketDTO save(TicketDTO ticketDTO) {
        Ticket ticket = mapper.getModelMapper().map(ticketDTO, Ticket.class);
        logger.info("Se guardó el ticket: {}", ticket);
        return mapper.getModelMapper().map(ticketRepository.save(ticket), TicketDTO.class);
    }

    @Override
    public void delete(Integer idTicket) throws ResourceNotFoundExceptions {

    }

    @Override
    public TicketDTO findById(Integer idTicket) throws ResourceNotFoundExceptions {
        Optional<Ticket> ticket = ticketRepository.findById(idTicket);
        TicketDTO ticketDTO = null;
        if (ticket.isPresent()) {
            ticketDTO = obmapper.convertValue(ticket, TicketDTO.class);
        } else {
            throw new ResourceNotFoundExceptions("No existe el elemento buscado con id " + idTicket);
        }
        return ticketDTO;
    }

    @Override
    public String update(TicketDTO ticketDTO) throws ResourceNotFoundExceptions {
        return null;
    }
}
