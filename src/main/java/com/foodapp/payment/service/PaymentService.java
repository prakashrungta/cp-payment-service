package com.foodapp.payment.service;

import com.foodapp.payment.dto.PaymentRequest;
import com.foodapp.payment.entity.Payment;
import com.foodapp.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }


    public Payment makePayment(Integer orderId, PaymentRequest request) {
        Payment payment = new Payment(orderId, request.getAmount());
        return paymentRepository.save(payment);
    }

//    public String getPayment(Integer orderId) {
//        return paymentRepository.findById(orderId).toString();
//    }
}
