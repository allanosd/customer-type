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
@Document("SubType")
@AllArgsConstructor
@NoArgsConstructor
public class SubType {

	@Id
	private String id;

	@Valid
	private EnumSubType value;

	public enum EnumSubType {
		NORMAL, VIP, PYME
	}

}
