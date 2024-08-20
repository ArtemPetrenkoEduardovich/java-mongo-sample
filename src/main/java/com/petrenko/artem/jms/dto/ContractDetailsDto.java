package com.petrenko.artem.jms.dto;

import com.petrenko.artem.jms.common.ContractStatus;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class ContractDetailsDto {

  private String id;

  private ContractStatus status;

  private String contractNumber;

  private LocalDate startDate;

  private LocalDate endDate;

  private double amount;

  private String clientId;
}
