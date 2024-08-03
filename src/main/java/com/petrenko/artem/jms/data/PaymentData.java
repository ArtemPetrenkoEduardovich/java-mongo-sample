package com.petrenko.artem.jms.data;

import com.petrenko.artem.jms.common.PaymentMethod;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Getter
@Setter
@Document("payments")
public class PaymentData {

  private String id;

  private Instant paymentDate;

  private double amount;

  private PaymentMethod paymentMethod;

  private String contractId;
}
