package com.ffa.application.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.ffa.application.port.out.IncomePort;
import com.ffa.domain.Income;
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
public class IncomeServiceTest {

  @Mock
  private IncomePort port;

  @InjectMocks
  private IncomeService incomeService;

  @Test
  void createIncome_IdIsGenerated() {
    // given
    Income income = Income.builder()
                          .yearIncome(Year.of(2021))
                          .monthIncome(Month.MAY)
                          .amount(new BigDecimal(12345))
                          .ownerId(UUID.randomUUID())
                          .build();
    when(port.createIncome(eq(income))).thenReturn(income);

    // when
    Income result = incomeService.createIncome(income);

    // then
    assertThat(result.getId()).isNotNull();
  }

  @Test
  void createIncome_IncomeIsCreated() {
    // given
    Income income = Income.builder()
                          .yearIncome(Year.of(2021))
                          .monthIncome(Month.MAY)
                          .amount(new BigDecimal(12345))
                          .ownerId(UUID.randomUUID())
                          .build();
    when(port.createIncome(eq(income))).thenReturn(income);

    // when
    Income result = incomeService.createIncome(income);

    // then
    verify(port).createIncome(eq(income));
  }
}
