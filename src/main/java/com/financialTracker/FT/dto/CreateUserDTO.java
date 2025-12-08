package com.financialTracker.FT.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDTO {
	
	
	private Long id;
	@NotBlank
	private String password;
	@NotBlank
	private String name;
	@NotBlank
	private String email;
}
