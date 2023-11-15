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
    private String name;
    private Integer stock;
    private String urlImage;

    public void setStock(int stock) {
        this.stock = stock;
    }
}
