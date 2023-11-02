package com.dh.subscriptionservice.api.service.impl;

import com.dh.subscriptionservice.api.service.SubscriptionService;
import com.dh.subscriptionservice.domain.model.Subscription;
import com.dh.subscriptionservice.domain.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

	@Autowired
	private SubscriptionRepository subscriptionRepository;


	@Override
	public List<Subscription> getAllSubscriptions() {
		return subscriptionRepository.findAll();
	}

	@Override
	public Subscription save(Subscription subscription) {

		Subscription savedSubscription = subscriptionRepository.save(subscription);

		return savedSubscription;

	}
}
