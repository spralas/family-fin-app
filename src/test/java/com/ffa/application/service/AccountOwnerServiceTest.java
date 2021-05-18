package com.ffa.application.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.ffa.application.port.out.AccountOwnerPort;
import com.ffa.domain.AccountOwner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AccountOwnerServiceTest {

    @Mock
    private AccountOwnerPort accountOwnerPort;

    @InjectMocks
    private AccountOwnerService accountOwnerService;

    @Test
    void createAccountOwner_IdIsGenerated(){
        // given
        AccountOwner accountOwner = AccountOwner.builder()
                                                .firstName("John")
                                                .lastName("First")
                                                .build();
        when(accountOwnerPort.createAccountOwner(eq(accountOwner))).thenReturn(accountOwner);


        // when
        AccountOwner result = accountOwnerService.createAccountOwner(accountOwner);

        // then
        assertThat(result.getId()).isNotNull();
    }

    @Test
    void createAccountOwner_OwnerIsCreated(){
        // given
        AccountOwner accountOwner = AccountOwner.builder()
                                                .firstName("John")
                                                .lastName("First")
                                                .build();
        when(accountOwnerPort.createAccountOwner(eq(accountOwner))).thenReturn(accountOwner);


        // when
        accountOwnerService.createAccountOwner(accountOwner);

        // then
        verify(accountOwnerPort).createAccountOwner(eq(accountOwner));
    }
}
