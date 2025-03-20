package com.restaurant.payments.controller;

import com.restaurant.payments.dto.PaymentRequest;
import com.restaurant.payments.entity.Payment;
import com.restaurant.payments.service.PaymentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payments")
@Tag(name = "Payment Controller", description = "API Endpoint for managing Payments")
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
@PreAuthorize("hasRole('CLIENT_S_ADMIN')")
@Operation(summary = "Creates a new payment", description = "Creates a new payment with the provided details")
@PostMapping({"/{orderId}"})
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Payment created successfully"),
        @ApiResponse(responseCode = "401", description = "Unauthorized"),
        @ApiResponse(responseCode = "403", description = "Forbidden"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
})
    public ResponseEntity<Payment> makePayment(
            @PathVariable Integer orderId, @Valid  @RequestBody PaymentRequest request) {
        return ResponseEntity.ok(paymentService.makePayment(orderId, request));

    }


}
