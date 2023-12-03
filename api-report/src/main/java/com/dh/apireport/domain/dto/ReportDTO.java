package com.dh.apireport.domain.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class ReportDTO {
//    private Integer id;
    private String event;
    private List<LocalDate> dateList;
    private List<Integer> quantityList;

}
