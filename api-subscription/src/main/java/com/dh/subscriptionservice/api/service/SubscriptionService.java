package com.dh.subscriptionservice.api.service;

import com.dh.subscriptionservice.domain.DTO.SubscriptionResponseDto;
import com.dh.subscriptionservice.domain.model.Subscription;
import java.util.Set;

public interface SubscriptionService {

    public Set<SubscriptionResponseDto> GetAllSubs();
    SubscriptionResponseDto save(Subscription subscription);
    public SubscriptionResponseDto findByEmail(String email);

}
