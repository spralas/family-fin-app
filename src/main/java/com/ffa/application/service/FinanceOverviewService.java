package com.ffa.application.service;

import java.math.BigDecimal;
import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ffa.application.port.in.GetFinanceOverviewUseCase;
import com.ffa.application.port.out.IncomePort;
import com.ffa.application.port.out.OutcomePort;
import com.ffa.domain.FinanceOverview;
import com.ffa.domain.Income;
import com.ffa.domain.Outcome;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FinanceOverviewService implements GetFinanceOverviewUseCase {
    private final IncomePort incomePort;
    private final OutcomePort outcomePort;

    @Override
    public FinanceOverview getFinanceOverviewForGivenDateAndOwners(Year year, Month month, List<UUID> owners) {
        List<Income> incomes = incomePort.getIncomeForGivenPeriodAndOwners(year, month, owners);
        List<Outcome> outcomes = outcomePort.getOutcomeForGivenPeriodAndOwners(year, month, owners);

        BigDecimal totalIncome = incomes.stream()
                                        .map(Income::getAmount)
                                        .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalOutcome = outcomes.stream()
                                          .map(Outcome::getAmount)
                                          .reduce(BigDecimal.ZERO, BigDecimal::add);
        return FinanceOverview.builder()
                              .year(year)
                              .month(month)
                              .totalIncome(totalIncome)
                              .totalOutcome(totalOutcome)
                              .saving(totalIncome.subtract(totalOutcome))
                              .build();
    }
}
