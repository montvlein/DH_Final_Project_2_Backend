package com.dh.eventservice;

import com.dh.eventservice.api.Exceptions.ResourceNotFoundExceptions;
import com.dh.eventservice.api.controller.CategoryController;
import com.dh.eventservice.api.controller.EventController;
import com.dh.eventservice.api.service.CategoryService;
import com.dh.eventservice.api.service.EventService;
import com.dh.eventservice.domain.DTO.CategoryDto;
import com.dh.eventservice.domain.DTO.EventDTO;
import com.dh.eventservice.domain.model.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EventControllerTest {

    @InjectMocks
    private EventController eventController;

    @Mock
    private EventService eventService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddEvent() {
        EventDTO eventDTO = new EventDTO();

        // Mock the service's behavior
        EventDTO savedEvent= null;
        Mockito.when(eventService.save(eventDTO)).thenReturn(savedEvent);

        ResponseEntity<?> response = eventController.saveEvent(eventDTO);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testFindEvent() throws ResourceNotFoundExceptions {
        int eventId = 1;
        EventDTO eventDTO = new EventDTO();

        Mockito.when(eventService.findById(eventId)).thenReturn(eventDTO);

        EventDTO response = eventController.findEventById(eventId);

        assertEquals(eventDTO, response);
    }

    @Test
    public void testListEvent() {
        List<EventDTO> eventDtos = new ArrayList<>();

        // Mock the service's behavior
        Mockito.when(eventService.getAllEvents()).thenReturn(eventDtos);

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
        Mockito.verify(eventService).delete(eventId);

        // Verificar que la respuesta sea la esperada (código de estado 204 - NO_CONTENT)
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
