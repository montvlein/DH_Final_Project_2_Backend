package com.dh.subscriptionservice.api.controller;

import com.dh.subscriptionservice.api.service.SubscriptionService;
import com.dh.subscriptionservice.domain.model.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {

	@Autowired
	private SubscriptionService subscriptionService;


	@GetMapping
	public ResponseEntity<List<Subscription>> getAllSubscriptions() {
		return ResponseEntity.ok().body(subscriptionService.getAllSubscriptions());
	}

	@PostMapping
	public ResponseEntity<Subscription> saveSubscription(@RequestBody Subscription subscription) {
		return ResponseEntity.ok().body(subscriptionService.save(subscription));
	}
}
