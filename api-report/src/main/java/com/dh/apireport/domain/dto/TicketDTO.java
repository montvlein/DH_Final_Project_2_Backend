package com.dh.apireport.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class TicketDTO {
    private Integer id;
    private TicketDateDTO dateTime;
    private TicketTypeDto ticketType;
    private TicketEventDTO event;
    private int idUser;
    private int amount = 1;
    private LocalDate purchaseDate;

}

