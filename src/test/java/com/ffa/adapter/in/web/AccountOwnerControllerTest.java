package com.ffa.adapter.in.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ffa.adapter.in.web.resource.AccountOwnerResource;
import com.ffa.application.port.in.CreateAccountOwnerUseCase;
import com.ffa.domain.AccountOwner;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@WebMvcTest(controllers = AccountOwnerController.class)
public class AccountOwnerControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @MockBean
  private CreateAccountOwnerUseCase createAccountOwnerUseCase;

  @Test
  void createAccountOwner_ReturnStatus200() throws Exception {
    // given
    AccountOwnerResource accountOwnerResource = AccountOwnerResource.builder()
                                                     .id(UUID.randomUUID())
                                                     .firstName("Mark")
                                                     .lastName("Snow")
                                                     .build();

    AccountOwner accountOwner = AccountOwner.builder()
                                            .id(accountOwnerResource.getId())
                                            .firstName(accountOwnerResource.getFirstName())
                                            .lastName(accountOwnerResource.getLastName())
                                            .build();

    when(createAccountOwnerUseCase.createAccountOwner(eq(accountOwner))).thenReturn(accountOwner);

    // when
    mockMvc.perform(post("/account-owner/create-account-owner")
        .content(objectMapper.writeValueAsString(accountOwnerResource))
        .contentType("application/json"))
           .andExpect(status().isOk());
  }

  @Test
  void createAccountOwner_ReturnSavedAccountOwner() throws Exception {
    // given
    AccountOwnerResource accountOwnerResource = AccountOwnerResource.builder()
                                                                    .id(UUID.randomUUID())
                                                                    .firstName("Mark")
                                                                    .lastName("Snow")
                                                                    .build();

    AccountOwner accountOwner = AccountOwner.builder()
                                            .id(accountOwnerResource.getId())
                                            .firstName(accountOwnerResource.getFirstName())
                                            .lastName(accountOwnerResource.getLastName())
                                            .build();

    when(createAccountOwnerUseCase.createAccountOwner(eq(accountOwner))).thenReturn(accountOwner);

    // when
    MvcResult mvcResult = mockMvc.perform(post("/account-owner/create-account-owner")
        .content(objectMapper.writeValueAsString(accountOwnerResource))
        .contentType("application/json"))
                                 .andExpect(status().isOk())
                                 .andReturn();

    // then
    AccountOwnerResource actualResponseBody = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), AccountOwnerResource.class);
    assertThat(actualResponseBody).isEqualTo(accountOwnerResource);
  }
}
