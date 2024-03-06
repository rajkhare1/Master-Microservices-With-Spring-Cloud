package com.rajkhare.rest.webservices.restfultwebservices.user;

import java.time.LocalDate;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
	private Integer id;
	@Size(min = 2, message = "Name should have atleast 2 characters") 
	private String name;
	@Past(message = "Birth Date should be in the past")
	private LocalDate birthDate;

}
