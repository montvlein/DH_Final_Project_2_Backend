package com.dh.subscriptionservice.api.controller;

import com.dh.subscriptionservice.api.service.SubscriptionService;
import com.dh.subscriptionservice.domain.DTO.SubscriptionResponseDto;
import com.dh.subscriptionservice.domain.model.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {
	@Autowired
	private SubscriptionService subscriptionService;

	@GetMapping
	public ResponseEntity<Set<SubscriptionResponseDto>> GetAllSubs() {
		Set<SubscriptionResponseDto> listSubscriptions = subscriptionService.GetAllSubs();
		return ResponseEntity.ok(listSubscriptions);
	}

	@PostMapping
	public ResponseEntity<SubscriptionResponseDto> saveSubscription(@RequestBody Subscription subscription) {
		return ResponseEntity.ok().body(subscriptionService.save(subscription));
	}

}
