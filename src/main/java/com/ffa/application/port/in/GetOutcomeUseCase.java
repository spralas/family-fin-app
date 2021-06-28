package com.ffa.application.port.in;

import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.UUID;

import com.ffa.domain.Outcome;

public interface GetOutcomeUseCase {
    List<Outcome> getOutcomeForGivenPeriodAndOwners(Year year, Month month, List<UUID> owners);
}
