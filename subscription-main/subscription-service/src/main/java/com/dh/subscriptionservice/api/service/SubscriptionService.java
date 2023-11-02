package com.dh.subscriptionservice.api.service;

import com.dh.subscriptionservice.domain.model.Subscription;
import java.util.List;

public interface SubscriptionService {

    List<Subscription> getAllSubscriptions();

    Subscription save(Subscription subscription);
}
