package com.dh.subscriptionservice.domain.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "subscriptions")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
}
