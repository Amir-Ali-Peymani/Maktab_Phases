package com.example.phase3.controller;

import com.example.phase3.dto.PaymentDTO;
import com.example.phase3.entity.Payment;
import com.example.phase3.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
@AllArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/process")
    public ResponseEntity<String> processPayment(PaymentDTO paymentDTO) {
        return ResponseEntity.ok("Payment processed successfully");
//        try {
//            Payment payment = PaymentDTO.fromPayment(paymentDTO);
//
//            paymentService.savePayment(payment);
//
//            return ResponseEntity.ok("Payment processed successfully");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Error processing payment: " + e.getMessage());
//        }
//        return null;
    }
}
