package core.abstracts;



public interface AuthenticationService {
	void registerToSystem(String email, String password);
	void loginToSystem(String email, String password);
}
