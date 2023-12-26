package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.UsrDTO;

public class Usr_db {
	
	Connection cn = null;
	PreparedStatement ps = null;
	String urs = "jdbc:oracle:thin:@localhost:1521:XE";
	String id = "LHW";
	String pwd = "9894";
			
	
	public void join(UsrDTO us) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection(urs,id,pwd);
			
			String sql = "insert into Usr values"+"(?,?,?,?,?)";
			
			
			ps = cn.prepareStatement(sql);
			ps.setString(1,us.getU_id());
			ps.setString(2,us.getPwd());
			ps.setString(3,us.getU_name());
			ps.setString(4,us.getPhone());
			ps.setString(5,us.getBirthday());
			
			ps.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			System.out.println("클래스를 못찾음");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	public int select(UsrDTO us) {
		try {
			
		Class.forName("oracle.jdbc.driver.OracleDriver");
		cn = DriverManager.getConnection(urs,id,pwd);
		
		String sql = "select * from usr where u_id = ? and pwd = ? ";
		

		ps = cn.prepareStatement(sql);
		ps.setString(1, us.getU_id());
		ps.setString(2, us.getPwd());

		ResultSet rs = ps.executeQuery();
	
		if(rs.next()) {
			System.out.println("여기가 실행이 되나요?ㅋㅋ");
			us.setU_id(rs.getString("u_id"));
			
			return 1;
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch(ClassNotFoundException e) {
		System.out.println("클래서 못찾음 오류");
	}
	return 0;
}
