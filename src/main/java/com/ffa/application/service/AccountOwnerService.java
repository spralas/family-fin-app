package com.ffa.application.service;

import com.ffa.application.port.in.CreateAccountOwnerUseCase;
import com.ffa.application.port.out.AccountOwnerPort;
import com.ffa.domain.AccountOwner;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class AccountOwnerService implements CreateAccountOwnerUseCase {
    private final AccountOwnerPort port;

    @Override
    public AccountOwner createAccountOwner(AccountOwner accountOwner) {
        accountOwner.setId(UUID.randomUUID());
        return port.createAccountOwner(accountOwner);
    }
}
