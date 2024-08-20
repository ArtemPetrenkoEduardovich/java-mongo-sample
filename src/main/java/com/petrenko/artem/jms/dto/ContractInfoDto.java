package com.petrenko.artem.jms.dto;

import com.petrenko.artem.jms.common.ContractStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Builder
@Jacksonized
@Getter
public class ContractInfoDto {

  private String id;

  private ContractStatus status;

  private String contractNumber;

  private String clientId;
}
