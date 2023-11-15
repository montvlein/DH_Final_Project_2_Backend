package com.dh.eventservice.domain.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ticketTypes")
public class TicketType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
    private String urlImage;

}
