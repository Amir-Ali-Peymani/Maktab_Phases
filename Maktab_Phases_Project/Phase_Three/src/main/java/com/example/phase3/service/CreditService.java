package com.example.phase3.service;

import com.example.phase3.dto.CreditDTO;
import com.example.phase3.entity.Credit;
import com.example.phase3.exception.AuthenticationNotFoundException;
import com.example.phase3.exception.NullPointerException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CreditService {

    void saveCredit(Credit credit) throws NullPointerException;

    CreditDTO getCreditById(Long id) throws AuthenticationNotFoundException;

    List<CreditDTO> getAllCredit();

    void updateCredit(long id, Credit credit) throws NullPointerException;

    void deleteCredit(long id) throws AuthenticationNotFoundException;
}
