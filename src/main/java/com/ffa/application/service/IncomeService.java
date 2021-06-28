package com.ffa.application.service;

import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ffa.application.port.in.CreateIncomeUseCase;
import com.ffa.application.port.in.GetIncomeUseCase;
import com.ffa.application.port.out.IncomePort;
import com.ffa.domain.Income;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class IncomeService implements CreateIncomeUseCase, GetIncomeUseCase {
  private final IncomePort port;

  @Override
  public Income createIncome(Income income) {
    income.setId(UUID.randomUUID());
    return port.createIncome(income);
  }

  @Override
  public List<Income> getIncomeForGivenPeriodAndOwners(Year year, Month month, List<UUID> owners) {
    return port.getIncomeForGivenPeriodAndOwners(year, month, owners);
  }
}
