package com.example.phase3.service.Impl;

import com.example.phase3.dto.CreditDTO;
import com.example.phase3.entity.Credit;
import com.example.phase3.exception.AuthenticationNotFoundException;
import com.example.phase3.exception.NullPointerException;
import com.example.phase3.repository.CreditRepository;
import com.example.phase3.service.CreditService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CreditServiceImpl implements CreditService {

    private final CreditRepository creditRepository;

    @Override
    public void saveCredit(Credit credit) throws NullPointerException {
        if (credit == null) {
            throw new NullPointerException();
        }
        creditRepository.save(credit);
    }

    @Override
    public CreditDTO getCreditById(Long id) throws AuthenticationNotFoundException {
        Credit credit = creditRepository.getCreditById(id);
        if (credit == null) {
            throw new AuthenticationNotFoundException();
        }
        return CreditDTO.fromCredit(credit);
    }

    @Override
    public List<CreditDTO> getAllCredit() {
        List<Credit> credits = creditRepository.findAll();
        return credits.stream()
                .map(CreditDTO::fromCredit)
                .toList();
    }

    @Override
    public void updateCredit(long id, Credit credit) throws NullPointerException {
        Credit creditUpdate = creditRepository.getCreditById(id);
        if (credit == null) {
            throw new NullPointerException();
        }
        creditUpdate.setBalance(credit.getBalance());
        creditRepository.save(creditUpdate);
    }

    @Override
    public void deleteCredit(long id) throws AuthenticationNotFoundException {
        Credit credit = creditRepository.getCreditById(id);
        if (credit == null) {
            throw new AuthenticationNotFoundException();
        }
        creditRepository.delete(credit);
    }
}
