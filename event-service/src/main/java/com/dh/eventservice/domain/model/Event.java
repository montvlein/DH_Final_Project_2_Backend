package com.dh.eventservice.domain.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "events")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	//@JsonFormat(pattern = "dd-MM-yyyy")
	//@Temporal(TemporalType.DATE)
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
