package com.petrenko.artem.jms.dto;

import lombok.Getter;

@Getter
public class ClientQueryDto extends QueryDto {

  private String firstName;

  private String lastName;

  private ContactInfo contactInfo;

}
