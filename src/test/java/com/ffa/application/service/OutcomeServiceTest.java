package com.ffa.application.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.ffa.application.port.out.OutcomePort;
import com.ffa.domain.Outcome;
import java.math.BigDecimal;
import java.time.Month;
import java.time.Year;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class OutcomeServiceTest {

  @Mock
  private OutcomePort port;

  @InjectMocks
  private OutcomeService outcomeService;

  @Test
  void createOutcome_IdIsGenerated() {
    // given
    Outcome outcome = Outcome.builder()
                             .yearOutcome(Year.of(2021))
                             .monthOutcome(Month.MAY)
                             .amount(new BigDecimal(12345))
                             .ownerId(UUID.randomUUID())
                             .build();
    when(port.createOutcome(eq(outcome))).thenReturn(outcome);

    // when
    Outcome result = outcomeService.createOutcome(outcome);

    // then
    assertThat(result.getId()).isNotNull();
  }

  @Test
  void createOutcome_OutcomeIsCreated() {
    // given
    Outcome outcome = Outcome.builder()
                          .yearOutcome(Year.of(2021))
                          .monthOutcome(Month.MAY)
                          .amount(new BigDecimal(12345))
                          .ownerId(UUID.randomUUID())
                          .build();
    when(port.createOutcome(eq(outcome))).thenReturn(outcome);

    // when
    Outcome result = outcomeService.createOutcome(outcome);

    // then
    verify(port).createOutcome(eq(outcome));
  }
}
