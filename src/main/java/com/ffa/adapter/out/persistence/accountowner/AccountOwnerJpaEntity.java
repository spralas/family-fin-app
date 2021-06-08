package com.ffa.adapter.out.persistence.accountowner;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "account_owner")
@Data
public class AccountOwnerJpaEntity {

  @Id
  @Column(name="id")
  private UUID id;

  @Column(name="first_name")
  private String firstName;

  @Column(name="last_name")
  private String lastName;
}
