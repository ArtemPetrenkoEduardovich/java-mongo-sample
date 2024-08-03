package com.petrenko.artem.jms.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class ClientSaveDto {

  @NotBlank
  private String firstName;

  @NotBlank
  private String lastName;

  private String contactInfo;
}
