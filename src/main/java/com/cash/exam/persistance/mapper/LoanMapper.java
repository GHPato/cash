package com.cash.exam.persistance.mapper;

import com.cash.exam.domain.Loan;
import com.cash.exam.persistance.entity.LoanEntity;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LoanMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "total", target = "total"),
            @Mapping(source = "userId", target = "userId"),
    })
    Loan toLoan(LoanEntity loanEntity);
    List<Loan> toLoans(List<LoanEntity> loans);

    @InheritInverseConfiguration
    LoanEntity toLoanEntity(Loan loan);
}
