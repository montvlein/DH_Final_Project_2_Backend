package com.dh.subscriptionservice.domain.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Table(name = "subscriptions")
@Setter
@Getter
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String name;

    public Subscription(String email, String name) {
    this.email = email;
    this.name = name;
    }

    public Subscription(String email) {
        this.email = email;
    }

    public Subscription() {
    }
}
