package com.dh.eventservice.domain.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "venues")
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String venue;
    private String country;
    private String city;
    private String address;

}