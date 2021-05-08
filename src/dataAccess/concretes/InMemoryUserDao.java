package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class InMemoryUserDao implements UserDao {
	List<User> users = new ArrayList<User>();
	@Override
	public void login(User user) {
		System.out.println("Login is successful " +user.getFirstName() + " " +user.getLastName());
		
	}

	@Override
	public void register(User user) {
		users.add(user);
		System.out.println("Register is successsful, check your email and verify your account " +user.getEmail());
		
		
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return users;
	}
	
}
