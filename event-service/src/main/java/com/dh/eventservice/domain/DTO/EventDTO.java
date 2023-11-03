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
    private String name;
    private String miniImageUrl;
    private String bannerImageUrl;
    private String detailImageUrl;
    private String venue;
    private Category category;
}
