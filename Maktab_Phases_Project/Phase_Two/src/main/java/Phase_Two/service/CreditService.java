package Phase_Two.service;

import Phase_Two.entity.Credit;

import java.util.List;

public interface CreditService {

    void saveCredit(Credit credit);

    Credit getCreditById(Long id);

    List<Credit> getAllCredit();

    void updateCredit(Credit credit);

    void deleteCredit(Credit credit);
}
