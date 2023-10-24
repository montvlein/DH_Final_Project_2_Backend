package com.dh.eventservice.domain.model;

import lombok.Data;
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
	private String category;
}
