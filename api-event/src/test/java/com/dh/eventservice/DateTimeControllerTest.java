package com.dh.eventservice;

import com.dh.eventservice.api.Exceptions.ResourceNotFoundExceptions;
import com.dh.eventservice.api.controller.DateTimeController;
import com.dh.eventservice.api.controller.EventController;
import com.dh.eventservice.api.service.DateTimeService;
import com.dh.eventservice.api.service.EventService;
import com.dh.eventservice.domain.DTO.DateTimeDTO;
import com.dh.eventservice.domain.DTO.EventDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DateTimeControllerTest {

    @InjectMocks
    private DateTimeController dateTimeController;

    @Mock
    private DateTimeService dateTimeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddDateTime() {
        DateTimeDTO dateTimeDTO = new DateTimeDTO();

        // Mock the service's behavior
        DateTimeDTO savedDate= null;
        when(dateTimeService.save(dateTimeDTO)).thenReturn(savedDate);

        ResponseEntity<?> response = dateTimeController.saveDateTime(dateTimeDTO);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

  @Test
    public void testFindDateTime() throws ResourceNotFoundExceptions {
        int dateId = 1;
        DateTimeDTO dateTimeDTO = new DateTimeDTO();

        when(dateTimeService.findById(dateId)).thenReturn(dateTimeDTO);

      DateTimeDTO response = dateTimeController.findDateTimeById(dateId);

        assertEquals(dateTimeDTO, response);
    }

     @Test
    public void testListDateTimes() {
        List<DateTimeDTO> dateTimeDTOS = new ArrayList<>();

        // Mock the service's behavior
        when(dateTimeService.getAllDates()).thenReturn(dateTimeDTOS);

        ResponseEntity<List<DateTimeDTO>> response = dateTimeController.getAllDates();
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
    }

   @Test
    public void testDeleteDateTime() throws ResourceNotFoundExceptions {
        int dateId = 1;

        // Realizar la acción que se va a probar
        ResponseEntity<HttpStatus> response = dateTimeController.deleteDateTime(dateId);

        // Verificar que el método delete del servicio se ha llamado con el ID correcto
        verify(dateTimeService).delete(dateId);

        // Verificar que la respuesta sea la esperada (código de estado 204 - NO_CONTENT)
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
