package com.dh.eventservice;

import com.dh.eventservice.api.Exceptions.ResourceNotFoundExceptions;
import com.dh.eventservice.api.controller.CategoryController;
import com.dh.eventservice.api.controller.EventController;
import com.dh.eventservice.api.service.CategoryService;
import com.dh.eventservice.api.service.EventService;
import com.dh.eventservice.domain.DTO.CategoryDto;
import com.dh.eventservice.domain.DTO.EventDTO;
import com.dh.eventservice.domain.model.Event;
import com.dh.eventservice.domain.repository.EventRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class EventControllerTest {

    @InjectMocks
    private EventController eventController;

    @Mock
    private EventService eventService;


    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp()  {
        MockitoAnnotations.openMocks(this);

    }


    @Test
    public void testAddEvent() {
        EventDTO eventDTO = new EventDTO();

        // Mock the service's behavior
        EventDTO savedEvent= null;
        when(eventService.save(eventDTO)).thenReturn(savedEvent);
        /*rever esto porque siempre devuelve null*/
        ResponseEntity<?> response = eventController.saveEvent(eventDTO);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testFindEvent() throws ResourceNotFoundExceptions {
        int eventId = 1;
        EventDTO eventDTO = new EventDTO();

        when(eventService.findById(eventId)).thenReturn(eventDTO);

        EventDTO response = eventController.findEventById(eventId);

        assertEquals(eventDTO, response);
    }

    @Test
    public void testListEvent() {
        List<EventDTO> eventDtos = new ArrayList<>();

        // Mock the service's behavior
        when(eventService.getAllEvents()).thenReturn(eventDtos);

        ResponseEntity<List<EventDTO>> response = eventController.getAllEvents();
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
    }

    @Test
    public void testDeleteEvent() throws ResourceNotFoundExceptions {
        int eventId = 1;

        // Realizar la acción que se va a probar
        ResponseEntity<HttpStatus> response = eventController.deleteEvent(eventId);

        // Verificar que el método delete del servicio se ha llamado con el ID correcto
        verify(eventService).delete(eventId);

        // Verificar que la respuesta sea la esperada (código de estado 204 - NO_CONTENT)
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    /*@Test

    public void testUpdateEvent() throws Exception {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setId(1);
        eventDTO.setName("Updated Event Name");

        // Configurar el repositorio para devolver un evento simulado cuando se llama a findById
        Event event = new Event();
        when(eventRepository.findById(1)).thenReturn(Optional.of(event));

        // Realizar una solicitud POST con el cuerpo JSON
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/events/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(eventDTO)))
                .andExpect(status().isOk());
    }

    // Método para convertir un objeto Java a una cadena JSON
    private String asJsonString(final Object obj) {
        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }*/
}
