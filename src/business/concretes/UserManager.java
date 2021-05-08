package business.concretes;

import business.abstracts.UserService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService{
	
	private UserDao userDao;
	
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	
	@Override
	public void login(User user) {
		if(user.getEmail() != null && user.getPassword().length()>=6) {
			System.out.println("Login is successful. " +user.getFirstName() + " " + user.getLastName());
		}
		else {
			System.out.println("Your email/password is wrong.Please try again!");
		}
		
	}

	@Override
	public void register(User user) {
		if(checkInformation(user)) {
			if(user.getPassword().length()>=6 && checkMail(user) ==true &&  checkNameAndSurname(user)==true){
				System.out.println("Register successful.Welcome to our system! " +user.getFirstName() + " " + user.getLastName());
				userDao.register(user);
				sendEmail(user);
			}
			else {
				System.out.println("Register is not successful! Please try again! " +user.getFirstName());
			}
		}
		else {
			System.out.println("Register is not successful! Please try again! " + user.getFirstName());
		}
		
	}

	@Override
	public void sendEmail(User user) {
		System.out.println("Sended email to your mail adress " +user.getEmail() + " " + user.getFirstName() + " " + user.getLastName());
		verifyEmail(user);
	}

	@Override
	public void verifyEmail(User user) {
		System.out.println("You verified your email! " +user.getFirstName() + " " + user.getLastName());
	}
	
	private boolean checkNameAndSurname(User user) {
		if(user.getFirstName().length()>=2 && user.getLastName().length()>=2) {
			return true;
		}
		else {
			System.out.println("Your name or surname should be least 2 characters : " +user.getFirstName() + " " +user.getLastName());
			return false;
			
		}
	}
	private boolean checkInformation(User user) {
		if(user.getFirstName() != null && user.getLastName() !=null && user.getEmail() !=null && user.getPassword().length() >=6 ) {
			return true;
		}
		else {
			System.out.println("Please fill in all blanks correctly! : "  + user.getFirstName());
			return false;
		}
	}
	private boolean checkMail(User user) {
		if(user.getEmail().matches(".*@.*")==true) {
			return isThereMail(user);
		}
		else {
			return false;
		}
	}
	private boolean isThereMail(User user) {
		for(var onDataUser: userDao.getAll()) {
			if(onDataUser.getEmail()==user.getEmail()) {
				return false;
			}
		}
		return true;
	}
	
	

}
