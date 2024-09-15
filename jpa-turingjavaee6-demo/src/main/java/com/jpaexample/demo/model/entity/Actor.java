package com.jpaexample.demo.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.ToString;

@ToString(callSuper=true)
@Data
@Entity
public class Actor extends Human{

	private static final long serialVersionUID = 1L;
	
	
}
