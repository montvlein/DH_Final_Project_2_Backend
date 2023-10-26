package com.dh.eventservice.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "events")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String date;
	private String description;
	private Float price;
	private Integer capacity;
	private String imageUrl;
	private String name;
	private String venue;
	@ManyToOne( fetch = FetchType.EAGER)
	@JoinColumn(name = "id_category",nullable = false)
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private Category category;
}
