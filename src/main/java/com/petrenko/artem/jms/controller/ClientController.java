package com.petrenko.artem.jms.controller;

import com.petrenko.artem.jms.dto.ClientSaveDto;
import com.petrenko.artem.jms.dto.RestResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/client")
public class ClientController {

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public RestResponse createGroup(@Valid @RequestBody ClientSaveDto dto) {
//    String id = groupService.createGroup(dto);
    return new RestResponse("String.valueOf(id)");
  }
}
