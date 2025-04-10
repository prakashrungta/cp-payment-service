package com.restaurant.payments.controller;

import com.restaurant.payments.dto.PaymentRequest;
import com.restaurant.payments.entity.Payment;
import com.restaurant.payments.service.PaymentService;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payments")
@Tag(name = "Payment Controller", description = "API Endpoint for managing Payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


@PreAuthorize("hasRole('admin')")
@Operation(summary = "Creates a new payment", description = "Creates a new payment with the provided details")
@PostMapping({"/{orderId}"})
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Payment created successfully"),
        @ApiResponse(responseCode = "401", description = "Unauthorized"),
        @ApiResponse(responseCode = "403", description = "Forbidden"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
})

@RateLimiter(name = "paymentRateLimiter", fallbackMethod = "rateLimitFallback")
    public ResponseEntity<Payment> makePayment(
            @PathVariable Integer orderId, @Valid  @RequestBody PaymentRequest request) {
        return ResponseEntity.ok(paymentService.makePayment(orderId, request));

    }

    public ResponseEntity<String> rateLimitFallback(Integer orderId, PaymentRequest request, Throwable t) {
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
                .body("Rate limit exceeded. Please try again later.");
    }
}
