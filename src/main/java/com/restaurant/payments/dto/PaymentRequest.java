package com.restaurant.payments.dto;

import lombok.*;
import org.springframework.stereotype.Service;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaymentRequest {
    private double amount;
}
