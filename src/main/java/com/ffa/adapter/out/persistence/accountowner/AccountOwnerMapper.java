package com.ffa.adapter.out.persistence.accountowner;

import com.ffa.domain.AccountOwner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountOwnerMapper {
  AccountOwnerMapper INSTANCE = Mappers.getMapper(AccountOwnerMapper.class);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "firstName", source = "firstName")
  @Mapping(target = "lastName", source = "lastName")
  AccountOwnerJpaEntity mapToJpaEntity(AccountOwner accountOwner);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "firstName", source = "firstName")
  @Mapping(target = "lastName", source = "lastName")
  AccountOwner mapToDomainEntity(AccountOwnerJpaEntity accountOwnerJpaEntity);
}
