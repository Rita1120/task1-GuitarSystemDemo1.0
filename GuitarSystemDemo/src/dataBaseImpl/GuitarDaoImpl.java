package dataBaseImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import dataBaseDao.GuitarDao;
import dataBaseTable.Guitar;

public class GuitarDaoImpl implements GuitarDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public GuitarDaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public List<Guitar> findAll(String keyWord) throws Exception {
		List<Guitar> result = new ArrayList<Guitar>();
		String sql = "SELECT * FROM guitar WHERE  ( serialNumber LIKE  ? "	
				+ "OR model  LIKE   ? "
				+ "OR builder  LIKE  ? "
				+ "OR type  LIKE  ? "
				+ "OR backWood  LIKE  ? "
				+ "OR topWood  LIKE  ? ) ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setString(2, "%" + keyWord + "%");
		this.pstmt.setString(3, "%" + keyWord + "%");
		this.pstmt.setString(4, "%" + keyWord + "%");
		this.pstmt.setString(5, "%" + keyWord + "%");
		this.pstmt.setString(6, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		Guitar guitar = null;
		while (rs.next()) {
			guitar = new Guitar();
			guitar.setSerialNumber(rs.getString("serialNumber"));
			guitar.setPrice(rs.getDouble("price"));
			guitar.setModel(rs.getString("model"));
			guitar.setBuilder(rs.getString("builder"));
			guitar.setType(rs.getString("type"));
			guitar.setBackWood(rs.getString("backWood"));
			guitar.setTopWood(rs.getString("topWood"));
			result.add(guitar);
		}
		this.pstmt.close();
		return result;
	}

}
