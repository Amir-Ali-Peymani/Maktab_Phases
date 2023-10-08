package org.example.service;

import org.example.entity.Credit;

import java.util.List;

public interface CreditService {

    void saveCredit(Credit credit);

    Credit getCreditById(Long id);

    List<Credit> getAllCredit();

    void updateCredit(Credit credit);

    void deleteCredit(Credit credit);
}
