package com.ffa.adapter.out.persistence.accountowner;

import com.ffa.domain.AccountOwner;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface AccountOwnerMapper {
  AccountOwnerMapper INSTANCE = Mappers.getMapper(AccountOwnerMapper.class);

  AccountOwnerJpaEntity mapToJpaEntity(AccountOwner accountOwner);
  AccountOwner mapToDomainEntity(AccountOwnerJpaEntity accountOwnerJpaEntity);

  default AccountOwner fromId(UUID id) {
    if (id == null) {
      return null;
    }
    return AccountOwner.builder().id(id).build();
  }
}
