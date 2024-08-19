package com.petrenko.artem.jms.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ClientDetailsDto {

  private String id;

  private String firstName;

  private String lastName;

  private ContactInfo contactInfo;
}
