package com.ffa.adapter.out.persistence.income;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

  @Override
  public List<Income> getIncomeForGivenPeriodAndOwners(Year year, Month month, List<UUID> owners) {
    List<IncomeJpaEntity> incomeJpaEntities = repository.getIncomeForGivenDateAndOwners(year, month, owners);
    List<Income> incomes = new ArrayList<>();
    incomeJpaEntities.forEach( incomeJpaEntity -> incomes.add(IncomeMapper.INSTANCE.mapToDomainEntity(incomeJpaEntity)));
    return incomes;
  }
}
