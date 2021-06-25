package com.cash.exam.domain.service;

import com.cash.exam.domain.Loan;
import com.cash.exam.domain.User;
import com.cash.exam.domain.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    public List<Loan> getLoans () {
        return loanRepository.getLoans();
    }

    public Optional<List<Loan>> getLoansByUserId (int userId) {
        return loanRepository.getLoansByUserId(userId);
    }
}
