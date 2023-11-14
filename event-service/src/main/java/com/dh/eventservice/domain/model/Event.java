package com.dh.eventservice.domain.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval = true)
    private Set<DateTime> dateList;
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
}
