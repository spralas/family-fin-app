package com.ffa.application.port.in;

import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.UUID;

import com.ffa.domain.Income;

public interface GetIncomeUseCase {
    List<Income> getIncomeForGivenPeriodAndOwners(Year year, Month month, List<UUID> owners);
}
