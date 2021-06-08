package com.ffa.adapter.out.persistence.income;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeJpaRepository extends JpaRepository<IncomeJpaEntity, Long> {
}
