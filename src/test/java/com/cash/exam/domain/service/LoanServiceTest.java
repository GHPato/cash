package com.cash.exam.domain.service;

import com.cash.exam.domain.Loan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class LoanServiceTest {

    @Autowired
    LoanService loanService;

    @Test
    void getLoans() {

    }

    @Test
    void getLoansByUserId() {
        loanService = new LoanService();
        Optional<List<Loan>> loan = loanService.getLoansByUserId(8);

        Double loanAmmount = 94550.00;
        Double total = loan.get().get(0).getTotal();

        Assertions.assertEquals(loanAmmount, total);


    }
}