package Utils;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import Utils.JDBCUtil;

public class JDBCUtilTest {
  //JDBCUtil
	@Test
	public void JDBCUtilInitTest() throws IOException, ClassNotFoundException{
		JDBCUtil con = new JDBCUtil();
		String path = System.getProperty("user.dir");
		File config_file = new File(path + "/src/main/java/Utils/configuracaobd.properties");

		JDBCUtil.init(config_file);
	}

	// @Test
	// public void JDBCUtilGetConnectionTest() throws IOException, ClassNotFoundException, SQLException{
	// 	String path = System.getProperty("user.dir");
	// 	File config_file = new File(path + "/src/main/java/Utils/configuracaobd.properties");

	// 	JDBCUtil.init(config_file);

	// 	assertEquals(JDBCUtil.getConnection(), Connection.class);
	// }
}
