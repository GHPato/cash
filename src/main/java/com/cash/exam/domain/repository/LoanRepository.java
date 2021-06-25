package com.cash.exam.domain.repository;

import com.cash.exam.domain.Loan;


import java.util.List;
import java.util.Optional;

public interface LoanRepository {
    List<Loan> getLoans ();
    Optional<List<Loan>> getLoansByUserId (int userId);
}
