package com.ffa.application.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ffa.application.port.out.IncomePort;
import com.ffa.application.port.out.OutcomePort;
import com.ffa.domain.FinanceOverview;
import com.ffa.domain.Income;
import com.ffa.domain.Outcome;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FinanceOverviewServiceTest {
    private Year year;

    private Month month;

    private List<UUID> owners;

    @Mock
    private IncomePort incomePort;

    @Mock
    private OutcomePort outcomePort;

    @InjectMocks
    private FinanceOverviewService financeOverviewService;

    @BeforeEach
    void init() {
        year = Year.of(LocalDate.now().getYear());
        month = Month.JANUARY;
        owners = List.of(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID());

        List<Income> incomes = List.of(Income.builder().amount(new BigDecimal(200)).build(),
                                       Income.builder().amount(new BigDecimal(300)).build(),
                                       Income.builder().amount(new BigDecimal(500)).build());
        when(incomePort.getIncomeForGivenPeriodAndOwners(eq(year), eq(month), eq(owners))).thenReturn(incomes);

        List<Outcome> outcomes = List.of(Outcome.builder().amount(new BigDecimal(100)).build(),
                                         Outcome.builder().amount(new BigDecimal(200)).build(),
                                         Outcome.builder().amount(new BigDecimal(500)).build());
        when(outcomePort.getOutcomeForGivenPeriodAndOwners(eq(year), eq(month), eq(owners))).thenReturn(outcomes);
    }

    @Test
    void testGetFinanceOverviewForGivenDateAndOwners_CalculateTotalIncome() {
        //when
        FinanceOverview result = financeOverviewService.getFinanceOverviewForGivenDateAndOwners(year, month, owners);

        //then
        assertThat(result.getTotalIncome()).isEqualTo(new BigDecimal(1000));
    }

    @Test
    void testGetFinanceOverviewForGivenDateAndOwners_CalculateTotalOutcome() {
        //when
        FinanceOverview result = financeOverviewService.getFinanceOverviewForGivenDateAndOwners(year, month, owners);

        //then
        assertThat(result.getTotalOutcome()).isEqualTo(new BigDecimal(800));
    }

    @Test
    void testGetFinanceOverviewForGivenDateAndOwners_CalculateSaving() {
        //when
        FinanceOverview result = financeOverviewService.getFinanceOverviewForGivenDateAndOwners(year, month, owners);

        //then
        assertThat(result.getSaving()).isEqualTo(new BigDecimal(200));
    }
}