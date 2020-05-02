package com.mx.kafka.enity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
	private String name;
	private String lastName;
	private Integer age;
	private Boolean isParent;
}
