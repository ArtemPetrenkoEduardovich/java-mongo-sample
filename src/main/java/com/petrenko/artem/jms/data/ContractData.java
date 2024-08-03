package com.petrenko.artem.jms.data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@Document("contracts")
public class ContractData {

  private String id;

  private String contractNumber;

  private LocalDate startDate;

  private LocalDate endDate;

  private double amount;

  private String clientId;
}
