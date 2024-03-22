 package com.rajkhare.rest.webservices.restfultwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;


@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	private static int userId = 0;
	
//	static {
//		users.add(new User(++userId,"Raj",LocalDate.now().minusYears(42)));
//		users.add(new User(++userId,"Richa",LocalDate.now().minusYears(40)));
//		users.add(new User(++userId,"Sia",LocalDate.now().minusYears(7)));
//	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findById(int id) {
		return (User) users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
	}
	
	public void deleteById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
	}
	
	public User save(User user) {
		user.setId(++userId);
		users.add(user);
		return user;
	}

}
