package com.cash.exam.persistance;

import com.cash.exam.domain.Loan;
import com.cash.exam.domain.repository.LoanRepository;
import com.cash.exam.persistance.crud.LoanCrudeRepository;
import com.cash.exam.persistance.entity.LoanEntity;
import com.cash.exam.persistance.mapper.LoanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class LoanEntityRepository implements LoanRepository
{
    @Autowired
    private LoanCrudeRepository loanCrudRepository;

    @Autowired
    private LoanMapper mapper;



    @Override
    public List<Loan> getLoans() {
       // List<LoanEntity> loans = (List<LoanEntity>) loanCrudRepository.findAll();
        // return (List<Loan>) mapper.toLoan((LoanEntity) loans);
        return mapper.toLoans((List<LoanEntity>)loanCrudRepository.findAll());
    }

    @Override
    public Optional<List<Loan>> getLoansByUserId(int userId) {
        return loanCrudRepository.getLoansByUserId(userId).map(LoanEntity -> mapper.toLoans((List<com.cash.exam.persistance.entity.LoanEntity>) LoanEntity));
    }
}
