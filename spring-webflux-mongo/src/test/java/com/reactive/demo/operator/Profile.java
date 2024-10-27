package com.reactive.demo.operator;

import lombok.Data;

@Data
public class Profile {
	String avatar;
	String email;
	Long id;
	String name;
	String role;
	@Override
	public String toString() {
		return "Profile [avatar=" + avatar + ", email=" + email + ", id=" + id + ", name=" + name + ", role=" + role
				+ "]";
	}
	
	
}
