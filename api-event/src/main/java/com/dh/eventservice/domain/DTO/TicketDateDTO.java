package com.dh.eventservice.domain.DTO;

import com.dh.eventservice.domain.model.TicketType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDateDTO {
    private Integer id;
    private LocalDateTime dateTime;
    private Integer capacity;
}