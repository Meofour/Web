package thu2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	
	private final String serverName = "MEWFOURR\\SQLEXPRESS";


	 private final String dbName = "laptrinhwebchieuthu2";


	 private final String portNumber = "1433";


	 private final String userID = "sa";


	 private final String password = "123";



	 public Connection getConnection() throws Exception {



	 String url = "jdbc:sqlserver://" + serverName + ";databaseName=" + dbName;


	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");


	 return DriverManager.getConnection(url, userID, password);

	 }
	 public static void main(String[] args) {



		 try {



		 System.out.println(new DB().getConnection());



		 } catch (Exception e) {



		 e.printStackTrace();



		 }



		 }

    
}
