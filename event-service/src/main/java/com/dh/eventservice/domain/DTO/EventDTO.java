package com.dh.eventservice.domain.DTO;

import com.dh.eventservice.domain.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {
    private Integer id;
    private String date;
    private String description;
    private Float price;
    private Integer capacity;
    private String imageUrl;
    private String name;
    private String venue;
    private Category category;
}
