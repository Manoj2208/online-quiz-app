package com.manu.userservice.Dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

	@NotNull
	@Pattern(regexp = "^[a-zA-Z ]+$", message = "First name should contain only alphabets")
	private String firstName;
	@NotNull
	@Pattern(regexp = "^[a-zA-Z ]+$", message = "second name should contain only alphabets")
	private String lastName;
	@Column(unique = true)
	@Email(message = "enter valid email")
	private String email;
}
