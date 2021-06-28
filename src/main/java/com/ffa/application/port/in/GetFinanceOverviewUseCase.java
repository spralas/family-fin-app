package com.ffa.application.port.in;

import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.UUID;

import com.ffa.domain.FinanceOverview;

public interface GetFinanceOverviewUseCase {
    FinanceOverview getFinanceOverviewForGivenDateAndOwners(Year year, Month month, List<UUID> owners);
}
