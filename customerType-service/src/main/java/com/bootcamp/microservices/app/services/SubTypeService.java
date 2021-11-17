package com.bootcamp.microservices.app.services;

import com.bootcamp.microservices.app.documents.SubType;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SubTypeService {

	public Mono<SubType> create(SubType subType);

	public Flux<SubType> findAll();

	public Mono<SubType> findById(String id);

	public Mono<SubType> update(SubType subType);

	public Mono<Boolean> delete(String id);

}
