package com.ffa.adapter.in.web.resource;

import com.sun.istack.NotNull;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountOwnerResource {
  @NotNull
  private UUID id;

  @NotNull
  private String firstName;

  @NotNull
  private String lastName;
}
