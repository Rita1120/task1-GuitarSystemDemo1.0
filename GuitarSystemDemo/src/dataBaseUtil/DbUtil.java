package dataBaseUtil;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	
	private static final String DBDRIVER = "org.sqlite.JDBC";
	private static final String DBURL = "jdbc:sqlite://e:/sqlitedata/instrument.db";
	
	private Connection conn;

	public DbUtil() throws Exception {
		Class.forName(DBDRIVER);
	
		this.conn = DriverManager.getConnection(DBURL);
	}

	public Connection getConnection() {
		
		return this.conn;
		
	}
	public void close() throws Exception {
		if (this.conn != null) {
			try {
				this.conn.close();
				System.out.println("ok");
			} catch (Exception e) {
				throw e;
			}
		}
	}
}
