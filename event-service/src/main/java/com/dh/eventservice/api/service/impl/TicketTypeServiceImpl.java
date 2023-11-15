package com.dh.eventservice.api.service.impl;

import com.dh.eventservice.api.Exceptions.ResourceNotFoundExceptions;
import com.dh.eventservice.api.config.ModelMapperConfig;
import com.dh.eventservice.api.service.TicketTypeService;
import com.dh.eventservice.domain.DTO.DateTimeDTO;
import com.dh.eventservice.domain.DTO.EventDTO;
import com.dh.eventservice.domain.DTO.TicketTypeDto;
import com.dh.eventservice.domain.model.*;
import com.dh.eventservice.domain.repository.TicketTypeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.Set;

public class TicketTypeServiceImpl implements TicketTypeService {

    private static final Logger logger = LoggerFactory.getLogger(TicketTypeServiceImpl.class);

    @Autowired
    private TicketTypeRepository ticketTypeRepository;

    @Autowired
    private ModelMapperConfig mapper;

    @Autowired
    private ObjectMapper obmapper;

    @Override
    public TicketTypeDto save(TicketTypeDto ticketTypeDto) {
        TicketType ticketType = mapper.getModelMapper().map(ticketTypeDto, TicketType.class);
        logger.info("Se guardó el ticketType: {}", ticketType);
        return mapper.getModelMapper().map(ticketTypeRepository.save(ticketType), TicketTypeDto.class);
    }

    @Override
    public void delete(Integer id) throws ResourceNotFoundExceptions {
        if (ticketTypeRepository.findById((id)) == null) {
            logger.error("No existe el elmento a eliminar");
            throw new ResourceNotFoundExceptions("No existe el elmento a eliminar");
        } else {
            ticketTypeRepository.deleteById(id);
            logger.info("Se elimino correctamente el elemento con id: " + id);
        }
    }

    @Override
    public TicketTypeDto findById(Integer id) throws ResourceNotFoundExceptions {
        Optional<TicketType> ticket = ticketTypeRepository.findById((id));
        TicketTypeDto ticketTypeDto = null;
        if (ticket.isPresent()) {
            ticketTypeDto = obmapper.convertValue(ticket, TicketTypeDto.class);
        } else {
            throw new ResourceNotFoundExceptions("No existe el elemento buscado con id " + id);
        }
        return ticketTypeDto;
    }

    @Override
    public String updateStock(TicketTypeDto ticketTypeDto) throws ResourceNotFoundExceptions {
        return null;
    }

    @Override
    public Set<TicketTypeDto> getAllTicketType() {
        return null;
    }

    @Override
    public String update(TicketTypeDto ticketTypeDto) throws ResourceNotFoundExceptions {
        Optional<TicketType> ticket = ticketTypeRepository.findById(ticketTypeDto.getId());
        String response;
        if (ticket.isPresent()) {
            //ticketTypeRepository.save(this.updateDb(ticket.get(), ticketTypeDto));
            mapper.getModelMapper().map(ticketTypeRepository.save(this.updateDb(ticket.get(), ticketTypeDto)), TicketTypeDto.class);
            response = "Successful update";
        } else {
            throw new ResourceNotFoundExceptions("El ticketType no pudo ser actualizado");
        }
        return response;
    }



}
