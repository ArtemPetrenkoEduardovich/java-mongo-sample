package com.petrenko.artem.jms.controller;

import com.petrenko.artem.jms.dto.ContractDetailsDto;
import com.petrenko.artem.jms.dto.ContractInfoDto;
import com.petrenko.artem.jms.dto.ContractQueryDto;
import com.petrenko.artem.jms.dto.ContractSaveDto;
import com.petrenko.artem.jms.dto.PageDto;
import com.petrenko.artem.jms.dto.RestResponse;
import com.petrenko.artem.jms.service.ContractService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/contract")
public class ContractController {

  private final ContractService contractService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public RestResponse createContract(@Valid @RequestBody ContractSaveDto dto) {
    String id = contractService.createContract(dto);
    return new RestResponse(id);
  }

  @PostMapping("/publish/{id}")
  public void publishContract(@PathVariable String id) {
    contractService.publishContract(id);
  }

  @PostMapping("/cancel/{id}")
  public void cancelContract(@PathVariable String id) {
    contractService.cancelContract(id);
  }

  @PostMapping("/process")
  public void processContractPayment(@Valid @RequestBody List<String> ids) {
    contractService.processContractPayment(ids);
  }

  @GetMapping("/{id}")
  public ContractDetailsDto getContract(@PathVariable String id) {
    return contractService.getContract(id);
  }

  @PostMapping("/_search")
  public PageDto<ContractInfoDto> search(@RequestBody ContractQueryDto query) {
    return contractService.search(query);
  }
}
