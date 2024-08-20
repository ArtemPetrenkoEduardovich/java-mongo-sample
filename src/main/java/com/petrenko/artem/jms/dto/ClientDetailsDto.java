package com.petrenko.artem.jms.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class ClientDetailsDto {

  private String id;

  private String firstName;

  private String lastName;

  private LocalDate birthDate;

  private ContactInfo contactInfo;
}
