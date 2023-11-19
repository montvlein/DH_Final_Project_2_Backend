package com.dh.subscriptionservice.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionResponseDto {
    private Integer id;
    private String email;
    private String Name;
}
