package com.ffa.application.service;

import com.ffa.application.port.in.CreateOutcomeUseCase;
import com.ffa.application.port.out.OutcomePort;
import com.ffa.domain.Outcome;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OutcomeService implements CreateOutcomeUseCase {
  private OutcomePort port;

  @Override
  public Outcome createOutcome(Outcome outcome) {
    outcome.setId(UUID.randomUUID());
    return port.createOutcome(outcome);
  }
}
