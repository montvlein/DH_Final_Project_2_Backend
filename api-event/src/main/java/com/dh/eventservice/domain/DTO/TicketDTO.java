package com.dh.eventservice.domain.DTO;

import com.dh.eventservice.domain.model.DateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDTO {
    private Integer id;
    private TicketDateDTO dateTime;
    private TicketTypeDto ticketType;
    private TicketEventDTO event;
    private int idUser;

}

