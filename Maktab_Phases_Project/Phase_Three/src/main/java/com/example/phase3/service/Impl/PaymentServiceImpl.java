package com.example.phase3.service.Impl;

import com.example.phase3.dto.PaymentDTO;
import com.example.phase3.entity.Payment;
import com.example.phase3.repository.PaymentRepository;
import com.example.phase3.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public void savePayment(Payment payment) {
        paymentRepository.save(payment);
    }

    @Override
    public PaymentDTO getPaymentById(Long id) {
        Payment payment = paymentRepository.getPaymentsById(id);
        return PaymentDTO.fromPayment(payment);
    }

    @Override
    public List<PaymentDTO> getAllPayments() {
        List<Payment> payments = paymentRepository.findAll();
        return payments.stream()
                .map(PaymentDTO::fromPayment)
                .toList();
    }

}
