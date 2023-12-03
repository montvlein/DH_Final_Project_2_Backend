package com.dh.apireport.domain.model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
//@Entity
//@Table(name = "reports")
public class Report {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
    private String event;
    private List<LocalDate> dateList;
    private List<Integer> quantityList;

}
