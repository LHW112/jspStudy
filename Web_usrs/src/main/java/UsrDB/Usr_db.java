package UsrDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.UsrDTo;

public class Usr_db {
	Connection cnt = null;
	PreparedStatement pst = null;
	String urs = "jdbc:oracle:thin:@localhost:1521:XE";
	String pwd = "9894";
	String id = "LHW";
	
	public void join(UsrDTo ud) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cnt = DriverManager.getConnection(urs,id,pwd);
			
			String sql = "insert into Usr values" + "(?,?,?,?,?)";
			
			pst = cnt.prepareStatement(sql);
			pst.setString(1, ud.getU_id());
			pst.setString(2, ud.getPwd());
			pst.setString(3, ud.getU_name());
			pst.setString(4, ud.getBirthday());
			pst.setString(5, ud.getPhone());
			
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			System.out.println("클래서 못찾음 오류");
		}
		
		
		
		
	}

	
}
	