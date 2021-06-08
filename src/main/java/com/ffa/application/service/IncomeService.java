package com.ffa.application.service;

import com.ffa.application.port.in.CreateIncomeUseCase;
import com.ffa.application.port.out.IncomePort;
import com.ffa.domain.Income;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IncomeService implements CreateIncomeUseCase {
  private final IncomePort port;

  @Override
  public Income createIncome(Income income) {
    income.setId(UUID.randomUUID());
    return port.createIncome(income);
  }
}
