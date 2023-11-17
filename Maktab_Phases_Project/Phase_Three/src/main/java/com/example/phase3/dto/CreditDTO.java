package com.example.phase3.dto;

import com.example.phase3.entity.Credit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreditDTO {
    private long id;
    private double balance;
    private long customerId;
    private long specialistId;

    public static CreditDTO fromCredit(Credit credit){
        CreditDTO creditDTO = new CreditDTO();
        creditDTO.setId(credit.getId());
        creditDTO.setBalance(credit.getBalance());
        creditDTO.setCustomerId(credit.getCustomer().getId());
//        creditDTO.setSpecialistId(credit.getSpecialist().getId());
        return creditDTO;
    }
}
