package Views;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CentralTest {
  //Central
	@Test
	public void centralTest(){
		Central c = new Central();
	}

	@Test
	public void centralAdminTest(){
		Central m = new Central("admin", "0");
	}

	@Test
	public void centralEmployeeTest(){
		Central m = new Central("Manager", "0");
	}

	@Test
	public void centralManagerTest(){
		Central m = new Central("Employee", "0");
	}
}
