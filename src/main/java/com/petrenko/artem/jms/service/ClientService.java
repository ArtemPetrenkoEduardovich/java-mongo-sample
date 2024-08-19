package com.petrenko.artem.jms.service;

import com.petrenko.artem.jms.dto.ClientDetailsDto;
import com.petrenko.artem.jms.dto.ClientSaveDto;
import com.petrenko.artem.jms.dto.ClientInfoDto;
import com.petrenko.artem.jms.dto.ClientQueryDto;
import com.petrenko.artem.jms.dto.PageDto;

public interface ClientService {

  String createClient(ClientSaveDto dto);

  ClientDetailsDto getClient(String id);

  void updateClient(String id, ClientSaveDto dto);

  PageDto<ClientInfoDto> search(ClientQueryDto query);

}
