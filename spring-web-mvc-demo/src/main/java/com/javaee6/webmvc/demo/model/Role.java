package com.javaee6.webmvc.demo.model;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
public class Role implements GrantedAuthority{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String role;
    
    @JsonIgnore
	@ToString.Exclude
	@ManyToOne(
			cascade= CascadeType.ALL
			)
	@JoinColumn(name="user_id")
	User user;
    
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.role;
	}

}
