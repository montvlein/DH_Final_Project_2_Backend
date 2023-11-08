package com.dh.eventservice.domain.DTO;
import com.dh.eventservice.domain.model.Category;
import com.dh.eventservice.domain.model.Venue;
import com.dh.eventservice.domain.model.DateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {
    private Integer id;
    private ArrayList<DateTime> dateList;
    private String description;
    private String name;
    private Venue venue;
    private String miniImageUrl;
    private String bannerImageUrl;
    private String detailImageUrl;
    private Category category;
}
