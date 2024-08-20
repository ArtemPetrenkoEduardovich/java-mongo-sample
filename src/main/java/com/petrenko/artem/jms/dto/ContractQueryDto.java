package com.petrenko.artem.jms.dto;

import com.petrenko.artem.jms.common.ContractStatus;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ContractQueryDto extends QueryDto {

  private ContractStatus status;

  private String contractNumber;

  private LocalDate startDate;

  private LocalDate endDate;

  private double amount;

}
