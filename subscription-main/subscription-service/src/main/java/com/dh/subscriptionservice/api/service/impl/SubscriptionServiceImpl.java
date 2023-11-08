package com.dh.subscriptionservice.api.service.impl;

import com.dh.subscriptionservice.api.service.SubscriptionService;
import com.dh.subscriptionservice.domain.DTO.SubscriptionResponseDto;
import com.dh.subscriptionservice.domain.model.Subscription;
import com.dh.subscriptionservice.domain.repository.SubscriptionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.Optional;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

	@Autowired
	private SubscriptionRepository subscriptionRepository;

	@Autowired
	ObjectMapper mapper;

	@Override
	public Set<SubscriptionResponseDto> GetAllSubs() {
		List<Subscription> subscriptions = subscriptionRepository.findAll();
		Set<SubscriptionResponseDto> subscriptionsDTOS = new HashSet<>();
		for (Subscription s : subscriptions) {
			subscriptionsDTOS.add(mapper.convertValue(s, SubscriptionResponseDto.class));
		}
		return subscriptionsDTOS;
	}

	@Override
	public SubscriptionResponseDto save(Subscription subscription){
		if (subscriptionRepository.findByEmail(subscription.getEmail()) == null) {
		subscriptionRepository.save(subscription);
		}
		SubscriptionResponseDto subscriptionSaved = mapper.convertValue(subscription, SubscriptionResponseDto.class);
		return subscriptionSaved;
	}

	@Override
	public SubscriptionResponseDto findByEmail(String email) {
		return mapper.convertValue(subscriptionRepository.findByEmail(email), SubscriptionResponseDto.class);
	}

}
