package com.petrenko.artem.jms.repository;

import com.petrenko.artem.jms.data.ClientData;
import com.petrenko.artem.jms.dto.ClientQueryDto;
import org.springframework.data.domain.Page;

public interface ClientRepositoryCustom {

  Page<ClientData> search(ClientQueryDto query);

}
