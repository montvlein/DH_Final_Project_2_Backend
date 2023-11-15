package com.dh.eventservice.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketTypeDto {

    private Integer id;
    private String description;
    private String urlImage;
}
