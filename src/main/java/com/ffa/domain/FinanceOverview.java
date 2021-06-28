package com.ffa.domain;

import java.math.BigDecimal;
import java.time.Month;
import java.time.Year;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FinanceOverview {
    private Year year;
    private Month month;
    private BigDecimal totalIncome;
    private BigDecimal totalOutcome;
    private BigDecimal saving;
}
