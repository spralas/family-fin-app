package com.ffa.adapter.in.web;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ffa.adapter.in.web.resource.OutcomeResource;
import com.ffa.application.port.in.CreateOutcomeUseCase;
import com.ffa.domain.Outcome;
import java.math.BigDecimal;
import java.time.Month;
import java.time.Year;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = OutcomeController.class)
public class OutcomeControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @MockBean
  private CreateOutcomeUseCase createOutcomeUseCase;

  @Test
  void createOutcome_ReturnStatus200() throws Exception {
    // given
    OutcomeResource outcomeResource = OutcomeResource.builder()
                                                   .yearOutcome(Year.of(2021))
                                                   .monthOutcome(Month.APRIL)
                                                   .amount(new BigDecimal(12222))
                                                   .ownerId(UUID.randomUUID())
                                                   .build();

    Outcome outcome = Outcome.builder()
                            .yearOutcome(outcomeResource.getYearOutcome())
                            .monthOutcome(outcomeResource.getMonthOutcome())
                            .amount(outcomeResource.getAmount())
                            .ownerId(outcomeResource.getOwnerId())
                            .build();
    when(createOutcomeUseCase.createOutcome(eq(outcome))).thenReturn(outcome);

    // when
    mockMvc.perform(post("/outcome/create-outcome")
        .content(objectMapper.writeValueAsString(outcomeResource))
        .contentType("application/json"))
           .andExpect(status().isOk());
  }

}
