package Controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import Models.OrderProduct;
import Models.User;

public class UserDAOTest {
  //UserDAO
	@Test
	public void userDAOUserAuthTest(){
		UserDAO userDAO = new UserDAO();
		User u = new User();

		u.setUser_name("Joao");
		u.setUser_login("joaovitor");
		u.setUser_password("minhasenha");
		u.setUser_mail("joao@email.com");
		u.setUser_role("admin");

		userDAO.userAuth(u);
	}

	@Test
	public void userDAOCreateUserTest(){
		UserDAO userDAO = new UserDAO();
		User u = new User();

		u.setUser_name("Joao");
		u.setUser_login("joaovitor");
		u.setUser_password("minhasenha");
		u.setUser_mail("joao@email.com");
		u.setUser_role("admin");

		userDAO.createUser(u);
	}

	@Test
	public void userDAOAlterUserTest(){
		UserDAO userDAO = new UserDAO();
		User u = new User();

		u.setUser_name("Joao");
		u.setUser_login("joaovitor");
		u.setUser_password("minhasenha");
		u.setUser_mail("joao@email.com");
		u.setUser_role("admin");

		userDAO.alterarUser(u);
	}

	@Test
	public void userDAODeleteUserTest(){
		UserDAO userDAO = new UserDAO();
		User u = new User();

		u.setUser_name("Joao");
		u.setUser_login("joaovitor");
		u.setUser_password("minhasenha");
		u.setUser_mail("joao@email.com");
		u.setUser_role("admin");

		userDAO.deleteUser(u);
	}

	@Test
	public void checkEmailExistsTest() {
		UserDAO uc = new UserDAO();

		assertFalse(uc.checkIfEmailExists("emailnaoexiste@email.com"));
	}

	@Test
	public void checkLoginExistsTest() {
		UserDAO uc = new UserDAO();

		assertFalse(uc.checkIfLoginExists("loginnaoexiste"));
	}

	@Test
	public void userAuthTest() {
		UserDAO uc = new UserDAO();
		User u = new User(1, "admin", "admin", "admin123", "admin@email.com", "admin");

		uc.userAuth(u);
	}
}
