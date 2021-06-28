package com.ffa.adapter.out.persistence.outcome;

    import com.ffa.domain.Outcome;
    import org.mapstruct.Mapper;
    import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OutcomeMapper {
  OutcomeMapper INSTANCE = Mappers.getMapper(OutcomeMapper.class);

  OutcomeJpaEntity mapToJpaEntity(Outcome outcome);
  Outcome mapToDomainEntity(OutcomeJpaEntity outcomeJpaEntity);
}
