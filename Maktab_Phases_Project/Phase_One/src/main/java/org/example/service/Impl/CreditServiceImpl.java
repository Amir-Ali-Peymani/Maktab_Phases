package org.example.service.Impl;

import org.example.base.BaseRepository;
import org.example.entity.Credit;
import org.example.repository.CreditRepository;
import org.example.service.CreditService;

import java.util.List;

public class CreditServiceImpl implements CreditService {

    private final CreditRepository creditRepository;

    public CreditServiceImpl(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }


    @Override
    public void saveCredit(Credit credit) {
        creditRepository.saveCredit(credit);
    }

    @Override
    public Credit getCreditById(Long id) {
        return creditRepository.getCreditById(id);
    }

    @Override
    public List<Credit> getAllCredit() {
        return creditRepository.getAllCredit();
    }

    @Override
    public void updateCredit(Credit credit) {
        creditRepository.updateCredit(credit);
    }

    @Override
    public void deleteCredit(Credit credit) {
        creditRepository.deleteCredit(credit);
    }
}
