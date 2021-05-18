package com.ffa.domain;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class AccountOwner {
    private UUID id;
    private String firstName;
    private String lastName;
}
