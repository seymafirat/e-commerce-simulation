package dataAccess.abstracts;

import java.util.List;

import entities.concretes.User;

public interface UserDao {
	void login(User user);
	void register(User user);
	List<User> getAll();
	//void add(User user);
	//void delete(User user);
	//void update(User user);
	
}
