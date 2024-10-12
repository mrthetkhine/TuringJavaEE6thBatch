package com.jpaexample.demo.model.entity;

import java.util.Date;

import org.hibernate.annotations.Formula;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@MappedSuperclass
public class Human extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	//Name name;
	
	//@ColumnTransformer(read="UPPER(first_name)")
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Formula(value = "CONCAT(first_name,\" \",last_name)")
	private String fullName;
		
	@Column
	private Date birthday;
	
	@Formula(value="DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(), birthday)), '%Y') + 0")
	private Integer age;
	
	@Column
	@Enumerated(EnumType.ORDINAL)
	Gender gender;
}
