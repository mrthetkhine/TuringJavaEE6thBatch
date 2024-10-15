package com.javaee6.webmvc.demo.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {
	@NotBlank(message = "{required.user.username}")
	private String username;

	@NotBlank(message = "{required.user.password}")
	private String password;

}
