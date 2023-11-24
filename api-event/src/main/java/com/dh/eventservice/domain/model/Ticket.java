package com.dh.eventservice.domain.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.net.UnknownServiceException;

@Data
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "date_time_id", nullable = false)
    private DateTime dateTime;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "ticket_type_id", nullable = false)
    private TicketType ticketType;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    private int idUser;

}





