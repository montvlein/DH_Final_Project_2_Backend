package com.dh.eventservice.domain.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {
    private Integer id;
    private List<DateTimeDTO> dateList;
    private String description;
    private String description_title;
    private String name;
    private VenueDTO venue;
    private String miniImageUrl;
    private String bannerImageUrl;
    private String detailImageUrl;
    private CategoryDto category;


}
