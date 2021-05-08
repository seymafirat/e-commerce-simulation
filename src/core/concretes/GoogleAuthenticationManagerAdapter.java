package core.concretes;

import core.abstracts.AuthenticationService;
import googleAuthentication.GoogleAuthenticationManager;

public class GoogleAuthenticationManagerAdapter implements AuthenticationService{
	GoogleAuthenticationManager googleAuthenticationManager = new GoogleAuthenticationManager(); 

	@Override
	public void registerToSystem(String email, String password) {
		googleAuthenticationManager.registerWithGoogle(email, password);
		
	}

	@Override
	public void loginToSystem(String email, String password) {
		googleAuthenticationManager.loginWithGoogle(email, password);
		
	}

}
