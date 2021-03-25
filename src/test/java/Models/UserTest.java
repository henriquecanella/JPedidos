package Models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import Models.User;

public class UserTest {
  //USER
	@Test
	public void userConstructorTest() {
		// System.out.println("some test");
		User u = new User(0, "João", "joao123", "minhasenha", "joao@email.com", "admin");
        
		assertEquals("João", u.getUser_name());
	}

	@Test
	public void userGettersSettersTest() {
		// System.out.println("some test");
		User u = new User();

		u.setUser_id(0);
		u.setUser_name("João");
		u.setUser_login("joao123");
		u.setUser_password("minhasenha");
		u.setUser_mail("joao@email.com");
		u.setUser_role("admin");

		assertEquals(0, u.getUser_id());
		assertEquals("João", u.getUser_name());
		assertEquals("joao123", u.getUser_login());
		assertEquals("minhasenha", u.getUser_password());
		assertEquals("joao@email.com", u.getUser_mail());
		assertEquals("admin", u.getUser_role());
	}

	@Test
	public void userToStringTest(){
		User u = new User(0, "João", "joao123", "minhasenha", "joao@email.com", "admin");

		assertEquals(0 + "\n" 
			+ "João\n" 
			+ "joao123\n"
			+ "minhasenha\n"
			+ "joao@email.com\n"
			+ "admin\n",
			u.toString());
	} 
}
