package com.dh.eventservice.api.controller;

import com.dh.eventservice.api.Exceptions.ResourceNotFoundExceptions;
import com.dh.eventservice.api.service.TicketTypeService;
import com.dh.eventservice.domain.DTO.TicketTypeDto;
import com.dh.eventservice.domain.model.TicketType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("event/ticketType")
public class TicketTypeController {
    @Autowired
    private TicketTypeService ticketTypeService;

    //Registrar ticketType
    @PostMapping
    public ResponseEntity<?> addTicketType(@RequestBody TicketTypeDto ticketTypeDto) {
        ticketTypeService.save(ticketTypeDto);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    //Buscar por ID

    @GetMapping("/{id}")
    public TicketTypeDto findTicketTypeId(@PathVariable Integer id) throws ResourceNotFoundExceptions {
        return ticketTypeService.findById(id);
    }

    //Listar todas las ticketType
    @GetMapping
    public ResponseEntity<List<TicketTypeDto>> listTicketType() {
        List<TicketTypeDto> listarTicketType = ticketTypeService.getAllTicketType();
        return ResponseEntity.ok(listarTicketType);
    }

    //Eliminar por id
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTicketType(@PathVariable Integer id) throws ResourceNotFoundExceptions {
        ticketTypeService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    //Actualizar ticketType
    @PutMapping("/update")
    public ResponseEntity<String> updateTicketType(@RequestBody TicketTypeDto ticketTypeDto) throws ResourceNotFoundExceptions {

        if (ticketTypeDto.getId() != null && ticketTypeService.findById(ticketTypeDto.getId()) != null) {
            ticketTypeService.update(ticketTypeDto);
        } else {
            throw new ResourceNotFoundExceptions("No existe la categoria que se queire actualizar");
        }
        return ResponseEntity.ok(ticketTypeService.update(ticketTypeDto));
    }

}
