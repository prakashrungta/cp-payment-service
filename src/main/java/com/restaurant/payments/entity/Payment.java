package com.restaurant.payments.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity(name = "payments")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Entity representing an payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;

    @NotNull
    private Integer orderId;


    private Double amount;

    private String paymentStatus;


    @Autowired
    public Payment(Integer orderId, double amount) {
        this.orderId = orderId;
        this.amount = amount;

    }
}
