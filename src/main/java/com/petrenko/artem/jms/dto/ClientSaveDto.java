package com.petrenko.artem.jms.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;

@Getter
@Builder
@Jacksonized
public class ClientSaveDto {

  @NotBlank
  private String firstName;

  @NotBlank
  private String lastName;

  private LocalDate birthDate;

  private ContactInfo contactInfo;
}
