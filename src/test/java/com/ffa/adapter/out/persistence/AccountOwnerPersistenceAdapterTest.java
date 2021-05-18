package com.ffa.adapter.out.persistence;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

import com.ffa.adapter.out.persistence.accountowner.AccountOwnerJpaEntity;
import com.ffa.adapter.out.persistence.accountowner.AccountOwnerJpaRepository;
import com.ffa.adapter.out.persistence.accountowner.AccountOwnerMapper;
import com.ffa.adapter.out.persistence.accountowner.AccountOwnerPersistenceAdapter;
import com.ffa.domain.AccountOwner;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AccountOwnerPersistenceAdapterTest {

  @Mock
  private AccountOwnerJpaRepository accountOwnerJpaRepository;

  @InjectMocks
  private AccountOwnerPersistenceAdapter accountOwnerPersistenceAdapter;

  @Test
  void createAccountOwner_AccountOwnerIsCreated(){
    // given
    AccountOwner accountOwner = AccountOwner.builder().build();
    when(accountOwnerJpaRepository.save(isA(AccountOwnerJpaEntity.class))).thenReturn(new AccountOwnerJpaEntity());

    // when
    AccountOwner result = accountOwnerPersistenceAdapter.createAccountOwner(accountOwner);

    // then
    assertThat(result).isNotNull();
  }
}
