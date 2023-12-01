package com.dh.apireport.domain.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class ReportDTO {
    private Integer id;
    private String event;
    private LocalDate day;
    private Integer quantity;
    private Float amount;
}
