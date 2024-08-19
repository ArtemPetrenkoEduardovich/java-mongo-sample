package com.petrenko.artem.jms.repository;

import com.petrenko.artem.jms.data.ClientData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<ClientData, String>, ClientRepositoryCustom {

}
