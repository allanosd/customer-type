package com.bootcamp.microservices.app.services;

import com.bootcamp.microservices.app.documents.SubType;
import com.bootcamp.microservices.app.documents.TypeCustomer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TypeCustomerService {

	public Mono<TypeCustomer> create(TypeCustomer typeCustomer);

	public Flux<TypeCustomer> findAll();

	public Mono<TypeCustomer> findById(String id);

	public Mono<TypeCustomer> update(TypeCustomer typeCustomer);

	public Mono<Boolean> delete(String id);

	public Mono<SubType> checkSubType(String id);
}
