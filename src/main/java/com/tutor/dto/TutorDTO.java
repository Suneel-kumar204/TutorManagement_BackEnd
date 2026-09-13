package com.tutor.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TutorDTO {
	
	private long tutor_id;
	
	@NotBlank(message="Name is required")
	private String name;
	
	@NotNull(message="Phone Number is required")
	private long phonenumber;
	
	@NotBlank(message="Email is required")
	private String email;
	
	@NotBlank(message="City is required")
	private String city;
	
	@NotBlank(message="Course is required")
	private String course;
	
}
