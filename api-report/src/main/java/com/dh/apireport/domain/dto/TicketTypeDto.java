package com.dh.apireport.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketTypeDto {

    private Integer id;
    private String name;
    private Integer stock;
    private Float price;
    private String urlImage;
}
