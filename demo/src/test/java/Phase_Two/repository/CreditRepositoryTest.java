package Phase_Two.repository;

import Phase_Two.entity.Credit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CreditRepositoryTest {

    @Autowired
    private CreditRepository creditRepository;

    @Test
    public void testCreateCredit() {
        Credit credit = Credit.builder()
                .balance(2342434)
                .build();
        creditRepository.save(credit);
    }

    @Test
    public void testReadCredit() {
        Credit credit = creditRepository.findById(1L).orElse(null);
        assertNotNull(credit);
        System.out.println("credit: " + credit.getBalance());
    }

    @Test
    public void testUpdateCredit() {
        Credit credit = creditRepository.findById(1L).orElse(null);
        assertNotNull(credit);
        credit.setBalance(333);
        creditRepository.save(credit);
        assertEquals(333, credit.getBalance());
    }

    @Test
    public void testDeleteCredit() {
        Credit credit = creditRepository.findById(1L).orElse(null);
        assertNotNull(credit);
        creditRepository.delete(credit);
    }




}