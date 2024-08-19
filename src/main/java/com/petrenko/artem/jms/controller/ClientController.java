package com.petrenko.artem.jms.controller;

import com.petrenko.artem.jms.dto.RestResponse;
import com.petrenko.artem.jms.dto.ClientSaveDto;
import com.petrenko.artem.jms.dto.ClientDetailsDto;
import com.petrenko.artem.jms.dto.ClientInfoDto;
import com.petrenko.artem.jms.dto.ClientQueryDto;
import com.petrenko.artem.jms.dto.PageDto;
import com.petrenko.artem.jms.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/client")
public class ClientController {

  private final ClientService clientService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public RestResponse createClient(@Valid @RequestBody ClientSaveDto dto) {
    String id = clientService.createClient(dto);
    return new RestResponse(id);
  }

  @GetMapping("/{id}")
  public ClientDetailsDto getClient(@PathVariable String id) {
    return clientService.getClient(id);
  }

  @PostMapping("/{id}")
  public RestResponse updateClient(@Valid @PathVariable String id, @RequestBody ClientSaveDto dto) {
    clientService.updateClient(id, dto);
    return new RestResponse("OK");
  }

  @PostMapping("/_search")
  public PageDto<ClientInfoDto> search(@RequestBody ClientQueryDto query) {
    return clientService.search(query);
  }
}
