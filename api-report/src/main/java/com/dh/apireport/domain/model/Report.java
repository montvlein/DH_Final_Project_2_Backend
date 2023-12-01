package com.dh.apireport.domain.model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "reports")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String event;
    private LocalDate day;
    private Integer quantity;
    private Float amount;
}
