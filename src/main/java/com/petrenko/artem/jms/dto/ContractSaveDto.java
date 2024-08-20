package com.petrenko.artem.jms.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class ContractSaveDto {

  @Positive
  private double amount;

  @NotBlank
  private String clientId;
}
