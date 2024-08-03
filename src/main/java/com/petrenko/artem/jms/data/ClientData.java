package com.petrenko.artem.jms.data;

import com.petrenko.artem.jms.dto.ContactInfo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("clients")
public class ClientData {

  private String id;

  private String firstName;

  private String lastName;

  private ContactInfo contactInfo;
}
