package com.dh.eventservice.domain.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /*@OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval = true)*/
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="event_id")
    private List<DateTime> dateList;
    @Lob
    private String description;
    private String name;
    private String miniImageUrl;
    private String bannerImageUrl;
    private String detailImageUrl;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_category", nullable = false)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Category category;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_venue", nullable = false)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Venue venue;


    /*public void addDate(DateTime date) {
        date.setEvent(this);
        dateList.add(date);
    }

    public void setDates(Set<DateTime> dates) {
        for (DateTime date : dates) {
            date.setEvent(this);
        }
        this.dateList = dates;
    }*/
}
