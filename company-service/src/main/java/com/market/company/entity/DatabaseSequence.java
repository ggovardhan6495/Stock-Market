package com.market.company.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "db_sequences")
@Component
@Data
@NoArgsConstructor
public class DatabaseSequence {

	@Id
	private String id;

	private Integer seq;
}