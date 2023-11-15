package com.dh.eventservice.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateTimeDTO {
    private Integer id;
    private LocalDateTime dateTime;
    private EventDTO event;

}
