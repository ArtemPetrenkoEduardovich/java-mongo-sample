package com.petrenko.artem.jms.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

/**
 * Contact information about the client
 */
@Getter
@Setter
@FieldNameConstants
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class ContactInfo {

  private String email;

  private String phone;
}
