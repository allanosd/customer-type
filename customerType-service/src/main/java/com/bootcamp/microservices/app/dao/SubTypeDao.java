package com.bootcamp.microservices.app.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.bootcamp.microservices.app.documents.SubType;

public interface SubTypeDao extends ReactiveMongoRepository<SubType, String>{

}
