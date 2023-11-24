package com.dh.eventservice.api.controller;

import com.dh.eventservice.api.Exceptions.ResourceNotFoundExceptions;
import com.dh.eventservice.api.service.CategoryService;
import com.dh.eventservice.api.service.TicketService;
import com.dh.eventservice.domain.DTO.CategoryDto;
import com.dh.eventservice.domain.DTO.TicketDTO;
import com.dh.eventservice.domain.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("event/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    //Registrar Ticket
    @PostMapping
    public ResponseEntity<?> addTicket(@RequestBody TicketDTO ticketDTO) {
        ticketService.save(ticketDTO);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    //Buscar por ID

    @GetMapping("/{id}")
    public TicketDTO findTicketId(@PathVariable Integer id) throws ResourceNotFoundExceptions{
        return ticketService.findById(id);
    }

//    //lista categorias por descreipcion
//    @GetMapping("/desc/{description}")
//    public Category getCategoryByDescription(@PathVariable String description) {
//        return categoryService.getCategoryByDescription(description);
//    }

    //Listar todos los tickets
    @GetMapping
    public ResponseEntity<List<TicketDTO>> listTickets(){
        List<TicketDTO> listarTickets = ticketService.getAllTickets();
        return ResponseEntity.ok(listarTickets);
    }

//    //Eliminar por id
//    @DeleteMapping("/{id}")
//    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable Integer id) throws ResourceNotFoundExceptions {
//        categoryService.delete(id);
//        return ResponseEntity.ok(HttpStatus.OK);
//    }


//    //Actualizar Categoría
//    @PutMapping("/update")
//    public ResponseEntity<String> updateCategory(@RequestBody CategoryDto categoriaDTO) throws ResourceNotFoundExceptions{
//
//        if(categoriaDTO.getId() != null && categoryService.findById(categoriaDTO.getId())!= null){
//            categoryService.update(categoriaDTO);
//        }else{
//            throw new ResourceNotFoundExceptions("No existe la categoria que se queire actualizar");
//        }
//        return ResponseEntity.ok(categoryService.update(categoriaDTO));
//    }

}
