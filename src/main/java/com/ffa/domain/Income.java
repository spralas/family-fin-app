package com.ffa.domain;

import java.math.BigDecimal;
import java.time.Month;
import java.time.Year;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Income {
  private UUID id;
  private Year yearIncome;
  private Month monthIncome;
  private BigDecimal amount;
  private UUID ownerId;
}
