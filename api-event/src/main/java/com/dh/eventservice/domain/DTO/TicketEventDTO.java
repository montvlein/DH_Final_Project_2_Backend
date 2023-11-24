package com.dh.eventservice.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketEventDTO {
    private Integer id;
    private String description;
    private String description_title;
    private String name;
    private VenueDTO venue;
    private String miniImageUrl;
    private String bannerImageUrl;
    private String detailImageUrl;
    private CategoryDto category;

}

