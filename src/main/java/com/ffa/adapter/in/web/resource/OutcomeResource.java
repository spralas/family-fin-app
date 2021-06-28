package com.ffa.adapter.in.web.resource;

import java.math.BigDecimal;
import java.time.Month;
import java.time.Year;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OutcomeResource {
  private UUID id;

  @NotNull
  private Year yearOutcome;

  @NotNull
  private Month monthOutcome;

  @NotNull
  private BigDecimal amount;

  @NotNull
  private UUID ownerId;
}
