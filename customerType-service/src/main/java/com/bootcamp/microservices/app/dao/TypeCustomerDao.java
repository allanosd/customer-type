package com.bootcamp.microservices.app.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.bootcamp.microservices.app.documents.TypeCustomer;

public interface TypeCustomerDao extends ReactiveMongoRepository<TypeCustomer, String>{

}
