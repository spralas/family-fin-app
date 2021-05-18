package com.ffa.application.port.in;

import com.ffa.domain.AccountOwner;

public interface CreateAccountOwnerUseCase {
    AccountOwner createAccountOwner(AccountOwner accountOwner);
}
