package com.ffa.adapter.in.web;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ffa.adapter.in.web.resource.IncomeResource;
import com.ffa.application.port.in.CreateIncomeUseCase;
import com.ffa.domain.Income;
import java.math.BigDecimal;
import java.time.Month;
import java.time.Year;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = IncomeController.class)
public class IncomeControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @MockBean
  private CreateIncomeUseCase createIncomeUseCase;

  @Test
  void createAccountOwner_ReturnStatus200() throws Exception {
    // given
    IncomeResource incomeResource = IncomeResource.builder()
                                                  .yearIncome(Year.of(2021))
                                                  .monthIncome(Month.APRIL)
                                                  .amount(new BigDecimal(12222))
                                                  .ownerId(UUID.randomUUID())
                                                  .build();

    Income income = Income.builder()
                          .yearIncome(incomeResource.getYearIncome())
                          .monthIncome(incomeResource.getMonthIncome())
                          .amount(incomeResource.getAmount())
                          .ownerId(incomeResource.getOwnerId())
                          .build();
    when(createIncomeUseCase.createIncome(eq(income))).thenReturn(income);

    // when
    mockMvc.perform(post("/income/create-income")
        .content(objectMapper.writeValueAsString(incomeResource))
        .contentType("application/json"))
           .andExpect(status().isOk());
  }

}
