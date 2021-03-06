package com.ffa.adapter.out.persistence.income;

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

import com.ffa.adapter.out.persistence.YearAttributeConverter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Income")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncomeJpaEntity {

  @Id
  @Column(name = "id")
  private UUID id;

  @Column(name = "year_income", columnDefinition = "smallint")
  @Convert(
      converter = YearAttributeConverter.class
  )
  private Year yearIncome;

  @Column(name = "month_income", columnDefinition = "smallint")
  @Enumerated
  private Month monthIncome;

  @Column(name = "amount")
  private BigDecimal amount;

  @Column(name = "owner_id")
  private UUID ownerId;
}
