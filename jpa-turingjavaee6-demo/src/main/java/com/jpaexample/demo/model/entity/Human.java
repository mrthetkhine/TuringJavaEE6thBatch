package com.jpaexample.demo.model.entity;

import java.util.Date;

import org.hibernate.annotations.Formula;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.ToString;

@ToString(callSuper=true)
@Data
@MappedSuperclass
public class Human extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	Name name;
	
	@Column
	private Date birthday;
	
	@Formula(value="DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(), birthday)), '%Y') + 0")
	private Integer age;
	
	@Column
	@Enumerated(EnumType.ORDINAL)
	Gender gender;
}
