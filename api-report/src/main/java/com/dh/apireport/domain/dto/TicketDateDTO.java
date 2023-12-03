package com.dh.apireport.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDateDTO {
    private Integer id;
    private LocalDateTime dateTime;
    private Integer capacity;
}