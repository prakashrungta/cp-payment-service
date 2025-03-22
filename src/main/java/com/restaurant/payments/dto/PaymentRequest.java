package com.restaurant.payments.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.springframework.stereotype.Service;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class PaymentRequest {

    @NotNull
    @Positive(message = "Amount must be positive ")
    private double amount;
}
