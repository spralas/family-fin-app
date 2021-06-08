package com.ffa.adapter.out.persistence.income;

import com.ffa.application.port.out.IncomePort;
import com.ffa.domain.Income;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IncomePersistenceAdapter implements IncomePort {
  private final IncomeJpaRepository repository;

  @Override
  public Income createIncome(Income income) {
    IncomeJpaEntity incomeJpaEntity = IncomeMapper.INSTANCE.mapToJpaEntity(income);
    return IncomeMapper.INSTANCE.mapToDomainEntity(repository.save(incomeJpaEntity));
  }
}
