package com.petrenko.artem.jms.repository;


import com.petrenko.artem.jms.data.ClientData;
import com.petrenko.artem.jms.dto.ClientQueryDto;
import com.petrenko.artem.jms.dto.ContactInfo;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Repository
@RequiredArgsConstructor
public class ClientRepositoryCustomImpl implements ClientRepositoryCustom {

  private final MongoTemplate mongoTemplate;

  @Override
  public Page<ClientData> search(ClientQueryDto query) {
    PageRequest pageRequest = PageRequest.of(
        query.getPage(),
        query.getSize(),
        Sort.by(Sort.Direction.ASC, ClientData.Fields.id)
    );
    Query mongoQuery = new Query().with(pageRequest);
    if (StringUtils.isNotBlank(query.getFirstName())) {
      mongoQuery.addCriteria(where(ClientData.Fields.firstName).is(query.getFirstName()));
    }
    if (StringUtils.isNotBlank(query.getLastName())) {
      mongoQuery.addCriteria(where(ClientData.Fields.lastName).is(query.getLastName()));
    }
    if (query.getContactInfo() != null) {
      if (StringUtils.isNotBlank(query.getContactInfo().getEmail())) {
        mongoQuery.addCriteria(where(ClientData.Fields.contactInfo + '.' + ContactInfo.Fields.email).is(query.getContactInfo().getEmail()));
      }
      if (StringUtils.isNotBlank(query.getContactInfo().getPhone())) {
        mongoQuery.addCriteria(where(ClientData.Fields.contactInfo + '.' + ContactInfo.Fields.phone).is(query.getContactInfo().getPhone()));
      }
    }

    final List<ClientData> users = mongoTemplate.find(mongoQuery, ClientData.class);

    return PageableExecutionUtils.getPage(
        users,
        pageRequest,
        () -> mongoTemplate.count((Query.of(mongoQuery).limit(-1).skip(-1)), ClientData.class)
    );
  }
}
