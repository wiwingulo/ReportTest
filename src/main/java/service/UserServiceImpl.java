package service;

import java.util.*;

import model.User;

public class UserServiceImpl implements UserService{

	public User createUser(String firstname, String lastname, String email, String password, String repeatPassword) {
		if(firstname == null || firstname.trim().length()==0) {
			throw new IllegalArgumentException("User firstName is empty");
		}
		
		if(lastname == null || lastname.trim().length()==0) {
			throw new IllegalArgumentException("User lastName is empty");
		}
		return new User(firstname,lastname,email,UUID.randomUUID().toString());
	}
}
