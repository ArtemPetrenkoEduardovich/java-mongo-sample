package com.petrenko.artem.jms.service;

import com.petrenko.artem.jms.dto.ContractDetailsDto;
import com.petrenko.artem.jms.dto.ContractInfoDto;
import com.petrenko.artem.jms.dto.ContractQueryDto;
import com.petrenko.artem.jms.dto.ContractSaveDto;
import com.petrenko.artem.jms.dto.PageDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

  @Override
  public String createContract(ContractSaveDto dto) {
    return null;
  }

  @Override
  public void publishContract(String id) {

  }

  @Override
  public void processContractPayment(List<String> ids) {

  }

  @Override
  public void cancelContract(String id) {

  }

  @Override
  public ContractDetailsDto getContract(String id) {
    return null;
  }

  @Override
  public PageDto<ContractInfoDto> search(ContractQueryDto query) {
    return null;
  }
}
