package com.dh.eventservice.api.controller;

import com.dh.eventservice.api.Exceptions.ResourceNotFoundExceptions;
import com.dh.eventservice.api.service.DateTimeService;
import com.dh.eventservice.domain.DTO.DateTimeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("event/dates")
public class DateTimeController {

    @Autowired
    DateTimeService dateTimeService;

    @GetMapping("/{id}")
    public DateTimeDTO findDateTimeById(@PathVariable Integer id) throws ResourceNotFoundExceptions {
        return dateTimeService.findById(id);
    }

    @GetMapping
    public ResponseEntity<List<DateTimeDTO>> getAllDates() {
        return ResponseEntity.ok().body(dateTimeService.getAllDates());
    }

    @PostMapping
    public ResponseEntity<DateTimeDTO> saveDateTime(@RequestBody DateTimeDTO dateTimeDTO) {
        return ResponseEntity.ok().body(dateTimeService.save(dateTimeDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDateTime(@PathVariable Integer id) throws ResourceNotFoundExceptions {
        dateTimeService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody DateTimeDTO dateTimeDTO) throws ResourceNotFoundExceptions{
        return ResponseEntity.ok(dateTimeService.update(dateTimeDTO));
    }

}
