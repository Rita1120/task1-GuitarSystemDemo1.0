package dataBaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import dataBaseUtil.DbUtil;
public class utilTester {
     
	public static void main(String[] args) throws Exception {
		DbUtil lianjie=new DbUtil();
		Connection conn = lianjie.getConnection();
		PreparedStatement pstmt = null;
		String sql1 = "INSERT INTO guitar(serialNumber,price,builder,model,type,backWood,topWood) VALUES (?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql1);
		pstmt.setString(1, "11277");
		pstmt.setDouble(2, 3999.95);
		pstmt.setString(3, "Collings");
		pstmt.setString(4, "CJ");
		pstmt.setString(5, "古典");
		pstmt.setString(6, "Sitka");
		pstmt.setString(7, "Indian Rosewood");
		if (pstmt.executeUpdate() > 0) {
			System.out.print("sql1 yeah");
		}
		
		String sql2 = "INSERT INTO guitar(serialNumber,price,builder,model,type,backWood,topWood) VALUES (?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql2);
		pstmt.setString(1, "V95693");
		pstmt.setDouble(2, 1499.95);
		pstmt.setString(3, "Fender");
		pstmt.setString(4, "Stratocastor");
		pstmt.setString(5, "电子");
		pstmt.setString(6, "Alder");
		pstmt.setString(7, "Alder");
		if (pstmt.executeUpdate() > 0) {
			System.out.print("sql2 yeah");
		}
		String sql3 = "INSERT INTO guitar(serialNumber,price,builder,model,type,backWood,topWood) VALUES (?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql3);
		pstmt.setString(1, "V9512");
		pstmt.setDouble(2,  1549.95);
		pstmt.setString(3, "Fender");
		pstmt.setString(4, "Stratocastor");
		pstmt.setString(5, "电子");
		pstmt.setString(6, "Mahogany");
		pstmt.setString(7, "Maple");
		if (pstmt.executeUpdate() > 0) {
			System.out.print("sql3 yeah");
		}

	}

}
