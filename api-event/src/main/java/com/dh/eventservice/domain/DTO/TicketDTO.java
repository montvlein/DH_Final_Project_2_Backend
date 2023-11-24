package com.dh.eventservice.domain.DTO;

import com.dh.eventservice.domain.model.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


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
    private int amount;

}

