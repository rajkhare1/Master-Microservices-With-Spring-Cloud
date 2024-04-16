package com.rajkhare.rest.webservices.restfultwebservices.user;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity(name = "user_details")
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	@Size(min = 2, message = "Name should have atleast 2 characters") 
//	@JsonProperty("user_name")
	private String name;
	@Past(message = "Birth Date should be in the past")
//	@JsonProperty("birth_date")
	private LocalDate birthDate;
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Post> posts;

}
