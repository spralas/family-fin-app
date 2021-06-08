package com.ffa.adapter.out.persistence.income;

import com.ffa.domain.Income;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IncomeMapper {
  IncomeMapper INSTANCE = Mappers.getMapper(IncomeMapper.class);

  IncomeJpaEntity mapToJpaEntity(Income income);
  Income mapToDomainEntity(IncomeJpaEntity incomeJpaEntity);
}
