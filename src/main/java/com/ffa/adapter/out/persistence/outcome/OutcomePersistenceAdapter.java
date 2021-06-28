package com.ffa.adapter.out.persistence.outcome;

import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ffa.application.port.out.OutcomePort;
import com.ffa.domain.Outcome;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OutcomePersistenceAdapter implements OutcomePort {
  private OutcomeJpaRepository outcomeJpaRepository;

  @Override
  public Outcome createOutcome(Outcome outcome) {
    OutcomeJpaEntity outcomeJpaEntity = OutcomeMapper.INSTANCE.mapToJpaEntity(outcome);
    return OutcomeMapper.INSTANCE.mapToDomainEntity(outcomeJpaRepository.save(outcomeJpaEntity));
  }

  @Override
  public List<Outcome> getOutcomeForGivenPeriodAndOwners(Year year, Month month, List<UUID> owners) {
    List<OutcomeJpaEntity> outcomeJpaEntities = outcomeJpaRepository.getOutcomeForGivenDateAndOwners(year, month, owners);
    List<Outcome> outcomes = new ArrayList<>();
    outcomeJpaEntities.stream().forEach(outcomeJpaEntity -> outcomes.add(OutcomeMapper.INSTANCE.mapToDomainEntity(outcomeJpaRepository.save(outcomeJpaEntity))));
    return outcomes;
  }
}
