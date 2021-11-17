package com.bootcamp.microservices.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.microservices.app.documents.TypeCustomer;
import com.bootcamp.microservices.app.services.TypeCustomerService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("/typecustomer")
public class TypeCustomerController {
	
	@Autowired
    TypeCustomerService service;

    @GetMapping("/list")
    public Flux<TypeCustomer> list(){
        return service.findAll();
    }

    @GetMapping("/find/{id}")
    public Mono<TypeCustomer> findById(@PathVariable String id){
        return service.findById(id);
    }

    @PostMapping("/create")
    public Mono<ResponseEntity<TypeCustomer>> create(@RequestBody TypeCustomer typeCustomer){
        return service.checkSubType(typeCustomer.getSubType().getId())
                .flatMap(subType -> {
                    log.info("buscando subtype");
                    typeCustomer.setSubType(subType);
                    System.out.println(typeCustomer);
                    return service.create(typeCustomer)
                            .map(tc -> new ResponseEntity<>(tc , HttpStatus.CREATED));
                })
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/update")
    public Mono<ResponseEntity<TypeCustomer>> update(@Valid @RequestBody TypeCustomer c) {
        return service.update(c)
                .map(savedCustomer -> new ResponseEntity<>(savedCustomer, HttpStatus.CREATED))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<String>> delete(@PathVariable String id) {
        return service.delete(id)
                .filter(deleteCustomer -> deleteCustomer)
                .map(deleteCustomer -> new ResponseEntity<>("TypeCustomer Deleted", HttpStatus.ACCEPTED))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
