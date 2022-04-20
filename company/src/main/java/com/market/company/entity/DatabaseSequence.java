package com.market.company.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document(collection = "db_sequences")
@Component
public class DatabaseSequence {

 @Id
 private String id;

 private Integer seq;

 public DatabaseSequence() {}

 public String getId() {
     return id;
 }

 public void setId(String id) {
     this.id = id;
 }

public Integer getSeq() {
	return seq;
}

public void setSeq(Integer seq) {
	this.seq = seq;
}

}

