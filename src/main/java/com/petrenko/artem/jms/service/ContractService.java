package com.petrenko.artem.jms.service;

import com.petrenko.artem.jms.dto.ContractDetailsDto;
import com.petrenko.artem.jms.dto.ContractInfoDto;
import com.petrenko.artem.jms.dto.ContractQueryDto;
import com.petrenko.artem.jms.dto.ContractSaveDto;
import com.petrenko.artem.jms.dto.PageDto;

import java.util.List;

public interface ContractService {

  String createContract(ContractSaveDto dto);

  void publishContract(String id);

  void processContractPayment(List<String> ids);

  void cancelContract(String id);

  ContractDetailsDto getContract(String id);

  PageDto<ContractInfoDto> search(ContractQueryDto query);

}
