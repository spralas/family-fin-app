package com.ffa.domain;

import java.math.BigDecimal;
import java.time.Month;
import java.time.Year;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Outcome {
    private UUID id;
    private Year yearOutcome;
    private Month monthOutcome;
    private BigDecimal amount;
    private UUID ownerId;
}
