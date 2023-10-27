package com.dh.eventservice.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {
    private Integer id;
    private LocalTime date;
    private String description;
    private Float price;
    private Integer capacity;
    private String imageUrl;
    private String name;
    private String venue;
    private String category;
}
