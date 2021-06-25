package com.cash.exam.persistance.crud;

import com.cash.exam.persistance.entity.LoanEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LoanCrudeRepository extends CrudRepository<LoanEntity, Integer> {
    //Optional<LoanEntity> getLoanByUserId(int userId);
    Optional<List<LoanEntity>> getLoansByUserId(int userId);
}
