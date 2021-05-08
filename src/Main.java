import business.concretes.UserManager;
import core.concretes.GoogleAuthenticationManagerAdapter;
import dataAccess.concretes.InMemoryUserDao;
import entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user1 = new User(1,"Þeyma","Fýrat","seyma@gmail.com","444444");
		User user2 = new User(2,"Pýnar","Bedir","pinar@gmail.com","2525");
		User user3 = new User(3,"Zehra","Gökçe","zehragmail.com","111111");
		UserManager userManager = new UserManager(new InMemoryUserDao());
		userManager.register(user1);
		//userManager.verifyEmail(user1);
		System.out.println("-------------------------");
		
		userManager.login(user1);
		
		System.out.println("-------------------------");
		
		userManager.register(user2);
		
		System.out.println("-------------------------");
		
		userManager.register(user3);
		
		System.out.println("-------------------------");
		
		GoogleAuthenticationManagerAdapter googleAuthenticationManager = new GoogleAuthenticationManagerAdapter();
		googleAuthenticationManager.loginToSystem("seyma@gmail.com", "444444");

	}

}
