package com.petrenko.artem.jms.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Builder
@Jacksonized
@Getter
public class ClientInfoDto {

  private String id;

  private String fullName;
}
