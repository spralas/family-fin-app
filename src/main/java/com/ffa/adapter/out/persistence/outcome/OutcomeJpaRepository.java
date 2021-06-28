package com.ffa.adapter.out.persistence.outcome;

import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OutcomeJpaRepository extends JpaRepository<OutcomeJpaEntity, Long> {
    @Query(value = "select i from OutcomeJpaEntity i where i.yearOutcome = ?1 and i.monthOutcome = ?2 and i.ownerId in ?3")
    List<OutcomeJpaEntity> getOutcomeForGivenDateAndOwners(Year year, Month month, List<UUID> owners);
}
