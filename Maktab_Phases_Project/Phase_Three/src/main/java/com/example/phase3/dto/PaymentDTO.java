package com.example.phase3.dto;

import com.example.phase3.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {
    private long id;
    private BigDecimal amount;
    private BigInteger cardNumber;
    private int securityCode;
    private Date paymentDate;
    private long customerId;

    public static PaymentDTO fromPayment(Payment payment){
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setId(payment.getId());
        paymentDTO.setAmount(payment.getAmount());
        paymentDTO.setCardNumber(payment.getCardNumber());
        paymentDTO.setSecurityCode(payment.getSecurityCode());
        paymentDTO.setPaymentDate(payment.getPaymentDate());
        paymentDTO.setCustomerId(paymentDTO.getCustomerId());
        return paymentDTO;
    }
}
