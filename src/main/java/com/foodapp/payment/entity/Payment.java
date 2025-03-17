package com.foodapp.payment.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "payments")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;

    private Integer orderId;

    private double amount;

    private String paymentStatus;


    @Autowired
    public Payment(Integer orderId, double amount) {
        this.orderId = orderId;
        this.amount = amount;

    }
}
