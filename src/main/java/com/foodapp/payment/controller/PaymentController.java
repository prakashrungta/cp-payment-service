package com.foodapp.payment.controller;

import com.foodapp.payment.dto.PaymentRequest;
import com.foodapp.payment.entity.Payment;
import com.foodapp.payment.repository.PaymentRepository;
import com.foodapp.payment.service.PaymentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

//    @GetMapping({"/{orderId}"})
//    public String getPayment(
//            @PathVariable Integer orderId
//    ) {
//        return paymentService.getPayment(orderId);
//
//    }

    @PostMapping({"/{orderId}"})
    public ResponseEntity<Payment> makePayment(
            @PathVariable Integer orderId, @RequestBody PaymentRequest request) {
        return ResponseEntity.ok(paymentService.makePayment(orderId, request));

    }


}
