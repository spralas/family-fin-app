package com.ffa.application.port.out;

import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.UUID;

import com.ffa.domain.Outcome;

public interface OutcomePort {
  Outcome createOutcome(Outcome outcome);

  List<Outcome> getOutcomeForGivenPeriodAndOwners(Year year, Month month, List<UUID> owners);
}
