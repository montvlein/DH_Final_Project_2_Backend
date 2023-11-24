package com.dh.eventservice.api.service.impl;

import com.dh.eventservice.api.Exceptions.BadRequestException;
import com.dh.eventservice.api.Exceptions.ResourceNotFoundExceptions;
import com.dh.eventservice.api.config.ModelMapperConfig;
import com.dh.eventservice.api.service.TicketService;
import com.dh.eventservice.api.service.TicketTypeService;
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
    private TicketTypeService ticketTypeService;
    @Autowired
    private ModelMapperConfig mapper;

    @Autowired
    private ObjectMapper obmapper;
    @Override
    public List<TicketDTO> getTicketsByUserId(Integer userId) {

        List<Ticket> tickets = ticketRepository.findAllByIdUser(userId);
        List<TicketDTO> ticketsDTO = new ArrayList<>();

        for (Ticket ticket : tickets){
            ticketsDTO.add(obmapper.convertValue(ticket, TicketDTO.class));
        }
        logger.info("Se listaron todos los tickets");

        return ticketsDTO;
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
    public TicketDTO save(TicketDTO ticketDTO) throws ResourceNotFoundExceptions, BadRequestException {
        Ticket ticket = mapper.getModelMapper().map(ticketDTO, Ticket.class);
        System.out.println(ticketDTO);
        System.out.println(ticket);
        TicketTypeDto ticketType = ticketTypeService.findById(ticket.getTicketType().getId());

        Ticket ticketSaved = null;

        int amount = ticketDTO.getAmount();

        Integer stock = ticketType.getStock();

        if (stock >= amount) {
            ticketType.setStock(stock-amount);
            ticketTypeService.update(ticketType);
        }
        else {
            throw new BadRequestException("No hay suficientes lugares libres");
        }

        for (int i = 0; i < amount; i++) {
            ticket = mapper.getModelMapper().map(ticketDTO, Ticket.class);
            ticketSaved =  ticketRepository.save(ticket);
        }

        logger.info("Se guardó el ticket: {}", ticket);

        return mapper.getModelMapper().map(ticketSaved, TicketDTO.class);
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
