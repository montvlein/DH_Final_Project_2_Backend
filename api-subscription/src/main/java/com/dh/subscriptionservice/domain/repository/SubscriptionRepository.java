package com.dh.subscriptionservice.domain.repository;

import com.dh.subscriptionservice.domain.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
	Subscription findByEmail(String email);
}
