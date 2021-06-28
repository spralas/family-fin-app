package com.ffa.adapter.out.persistence.outcome;

import com.ffa.adapter.out.persistence.YearAttributeConverter;
import java.math.BigDecimal;
import java.time.Month;
import java.time.Year;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "outcome")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutcomeJpaEntity {

  @Id
  @Column(name = "id")
  private UUID id;

  @Column(name = "year_outcome", columnDefinition = "smallint")
  @Convert(
      converter = YearAttributeConverter.class
  )
  private Year yearOutcome;

  @Column(name = "month_outcome", columnDefinition = "smallint")
  @Enumerated
  private Month monthOutcome;

  @Column(name = "amount")
  private BigDecimal amount;

  @Column(name = "owner_id")
  private UUID ownerId;
}
