package com.ffa.application.port.out;

import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.UUID;

import com.ffa.domain.Income;

public interface IncomePort {
    Income createIncome(Income income);

    List<Income> getIncomeForGivenPeriodAndOwners(Year year, Month month, List<UUID> owners);
}
