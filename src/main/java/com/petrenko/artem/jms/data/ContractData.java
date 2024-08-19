package com.petrenko.artem.jms.data;

import com.petrenko.artem.jms.common.ContractStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@Document("contracts")
public class ContractData {

  private String id;

  private ContractStatus status;

  private String contractNumber;

  private LocalDate startDate;

  private LocalDate endDate;

  private double amount;

  private String clientId;
}
