package com.petrenko.artem.jms.data;

import com.petrenko.artem.jms.dto.ContactInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@FieldNameConstants
@Document("clients")
public class ClientData {

  private String id;

  private String firstName;

  private String lastName;

  private LocalDate birthDate;

  private ContactInfo contactInfo;
}
