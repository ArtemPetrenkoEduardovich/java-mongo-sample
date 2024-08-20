package com.petrenko.artem.jms.repository;

import com.petrenko.artem.jms.data.ContractData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContractRepository extends MongoRepository<ContractData, String>, ContractRepositoryCustom {

}
