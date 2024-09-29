package com.jpaexample.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@Entity
@Data
@Slf4j
@EqualsAndHashCode(callSuper=true)
public class BankAccount extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	@Column
	private String accountName;
	
	@Column
	private Long balance;
}
