package com.dh.eventservice.domain.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
	private String name;
	private String miniImageUrl;
	private String bannerImageUrl;
	private String detailImageUrl;
	private String venue;
	@ManyToOne( fetch = FetchType.EAGER)
	@JoinColumn(name = "id_category",nullable = false)
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private Category category;

}
