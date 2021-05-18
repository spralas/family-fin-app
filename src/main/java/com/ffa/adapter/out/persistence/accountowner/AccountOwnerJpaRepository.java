package com.ffa.adapter.out.persistence.accountowner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountOwnerJpaRepository extends JpaRepository<AccountOwnerJpaEntity, Long>{
}
