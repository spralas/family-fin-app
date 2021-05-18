package com.ffa.adapter.in.web;

import com.ffa.adapter.in.web.resource.AccountOwnerResource;
import com.ffa.application.port.in.CreateAccountOwnerUseCase;
import com.ffa.domain.AccountOwner;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account-owner")
@RequiredArgsConstructor
public class AccountOwnerController {
  private final CreateAccountOwnerUseCase createAccountOwnerUseCase;


  @PostMapping("/create-account-owner")
  AccountOwnerResource createAccountOwner(@Valid @RequestBody AccountOwnerResource accountOwnerResource){
    AccountOwner accountOwner = AccountOwner.builder()
                                            .id(accountOwnerResource.getId())
                                            .firstName(accountOwnerResource.getFirstName())
                                            .lastName(accountOwnerResource.getLastName())
                                            .build();
    AccountOwner createdAccountOwner =  createAccountOwnerUseCase.createAccountOwner(accountOwner);

    return AccountOwnerResource.builder()
                               .id(createdAccountOwner.getId())
                               .firstName(createdAccountOwner.getFirstName())
                               .lastName(createdAccountOwner.getLastName())
                               .build();

  }
}
