package com.dh.eventservice.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "events")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private String date;
	private String description;
	private Float price;
	private Integer capacity;
	private String imageUrl;
	private String name;
	//@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="venue_id", nullable = false, referencedColumnName = "id")
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private String venue;
	//@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="category_id", nullable = false, referencedColumnName = "id")
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private String category;
}
