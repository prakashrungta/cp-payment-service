package com.foodapp.payment.dto;

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
