package Views;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import Views.User;

public class UserTest {
  @Test
  public void updateUserValidTest(){
    User uv = new User();

    assertEquals(3, uv.updateUser("2", "gerente", "gerente@email.com", "gerente", "manager"));
    assertEquals(3, uv.updateUser("3", "user", "user@email.com", "user", "employee"));
  }

  @Test
  public void updateUserValidRoleTest(){
    User uv = new User();

    assertEquals(0, uv.updateUser("1", "admin", "admin@email.com", "admin", ""));
  }

  @Test
  public void updateUserEmptyFieldsTest(){
    User uv = new User();

    assertEquals(1, uv.updateUser("1", "", "admin@email.com", "admin", "admin"));
    assertEquals(1, uv.updateUser("1", "admin", "", "admin", "admin"));
    assertEquals(1, uv.updateUser("1", "admin", "admin@email.com", "", "admin"));
    assertEquals(1, uv.updateUser("1", "", "", "admin", "admin"));
    assertEquals(1, uv.updateUser("1", "", "admin@email.com", "", "admin"));
    assertEquals(1, uv.updateUser("1", "admin", "", "", "admin"));
    assertEquals(1, uv.updateUser("1", "", "", "", "admin"));
  }

  @Test
  public void updateUserUsernameExistsTest(){
    User uv = new User();

    assertEquals(2, uv.updateUser("1", "admin", "admin@email.com", "gerente", "admin"));
  }

  @Test
  public void updateUserEmailExistsTest(){
    User uv = new User();

    assertEquals(2, uv.updateUser("1", "admin", "gerente@email.com", "gerente", "admin"));
  }

  @Test
  public void updateUserInvalidIdTest(){
    User uv = new User();

    assertEquals(2, uv.updateUser("8", "admin", "gerente@email.com", "gerente", "admin"));
  }

  @Test
  public void updateUserInvalidIdAndEmptyFieldsTest(){
    User uv = new User();

   // assertEquals(2, uv.updateUser("8", "", "", "", "admin"));
  }
}
