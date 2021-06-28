package com.ffa.adapter.out.persistence.income;

import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeJpaRepository extends JpaRepository<IncomeJpaEntity, Long> {
    @Query(value = "select i from IncomeJpaEntity i where i.yearIncome = ?1 and i.monthIncome = ?2 and i.ownerId in ?3")
    List<IncomeJpaEntity> getIncomeForGivenDateAndOwners(Year year, Month month, List<UUID> owners);
}
