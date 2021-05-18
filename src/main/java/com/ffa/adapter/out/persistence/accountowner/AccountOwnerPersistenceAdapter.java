package com.ffa.adapter.out.persistence.accountowner;

import com.ffa.application.port.out.AccountOwnerPort;
import com.ffa.domain.AccountOwner;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountOwnerPersistenceAdapter implements AccountOwnerPort {
  private final AccountOwnerJpaRepository accountOwnerJpaRepository;

  @Override
  public AccountOwner createAccountOwner(AccountOwner accountOwner) {
    AccountOwnerJpaEntity accountOwnerJpaEntity = AccountOwnerMapper.INSTANCE.mapToJpaEntity(accountOwner);
    return AccountOwnerMapper.INSTANCE.mapToDomainEntity(accountOwnerJpaRepository.save(accountOwnerJpaEntity));
  }
}
