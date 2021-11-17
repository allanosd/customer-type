package com.bootcamp.microservices.app.documents;

import javax.validation.Valid;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Document("type_customer")
@AllArgsConstructor
@NoArgsConstructor
public class TypeCustomer {

	@Id
	private String id;

	@Valid
	private EnumTypeCustomer value;

	private SubType subType;

	enum EnumTypeCustomer {
		EMPRESARIAL, PERSONAL
	}

}
