package com.example.phase3.service;

import com.example.phase3.dto.PaymentDTO;
import com.example.phase3.entity.Payment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaymentService {

    void savePayment(Payment payment);

    PaymentDTO getPaymentById(Long id);

    List<PaymentDTO> getAllPayments();

}
