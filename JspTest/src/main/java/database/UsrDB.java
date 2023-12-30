package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.BoardDTO;
import beans.UsrDTO;

public class UsrDB {
	
	Connection cn = null;
	PreparedStatement ps = null;
	ResultSet rs = null; //결과의 집합, 
	String urs = "jdbc:oracle:thin:@localhost:1521:XE";
	String id = "LHW";
	String pwd = "9894";
	
	
	public void join(UsrDTO ud) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection(urs,id,pwd);
			String sql = "insert into Usr vales"+"(?,?,?,?,?)";
			
			ps = cn.prepareStatement(sql);
			ps.setString(1, ud.getU_id());
			ps.setString(2, ud.getU_pwd());
			ps.setString(3, ud.getU_name());
			ps.setString(4, ud.getBirthday());
			ps.setString(5, ud.getPhone());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public int login(UsrDTO ud) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection(urs,id,pwd);
			String sql = "select * from Usr where u_id =? anr u_pwd =?";
			
			ps = cn.prepareStatement(sql);
			ps.setString(1, ud.getU_id());
			ps.setString(2, ud.getU_pwd());

			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				ud.setU_id(rs.getString("U_id"));
				ud.setU_pwd(rs.getString("U_pwd"));
				return 1;
			}
			else {
				return 2;
			}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		return 0;
	}
	
	}
	public List<BoardDTO> select2() {
		List<BoardDTO> boards = new ArrayList<BoardDTO>();
		/*
		 * BoardDTO dt = new BoardDTO(); boards.add(dt);
		 */
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			cn = DriverManager.getConnection(urs,id,pwd);
			String sql = "select * from board";
			
			
			ps = cn.prepareStatement(sql);

			rs = ps.executeQuery();//인터너블 타입  결과 값을 하나씩 꺼내올수 있는 타입, 하나씩 값을 담을수 있다, 다음값이 있으면 true 없으면 flase를 반환 
			
			while(rs.next()) {//다음 값이 없을때까지 트루를 반환하므로 없어질떄 까지 돈다. 
				BoardDTO board = new BoardDTO();
				board.setB_id(rs.getString("b_id"));
				board.setB_title(rs.getString("b_title"));
				boards.add(board);
			}
			
			return boards;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return null;

		
		
	}
	public void  boardInsert(BoardDTO bdt) {
		try {
			
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection(urs,id,pwd);
			String sql = "insert INTO board values(BOARD_SQ.nextval,?,?,?,?)";
			
			ps = cn.prepareStatement(sql);
			ps.setString(1,bdt.getB_pwd());
			ps.setString(2,bdt.getB_title());
			ps.setString(3,bdt.getB_text());
			ps.setString(4,bdt.getU_id());
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	public void detail(BoardDTO bdt) {
		System.out.println("여기가db임 ㅋㅋ : " + bdt);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection(urs,id,pwd);
			String sql = "select * from board where b_id = ?";
			
			ps = cn.prepareStatement(sql);
			ps.setString(1, bdt.getB_id());
			rs = ps.executeQuery();
			
			
			if(rs.next()) {
				 bdt.setB_title(rs.getString("B_title"));
				 bdt.setB_text(rs.getString("B_text"));
				 
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	
	}
	public List<BoardDTO> viewText(){
		List<BoardDTO> boards = new ArrayList<BoardDTO>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection(urs,id,pwd);
			String sql = "select * from board order by b_id desc";
			
			ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
				
			while(rs.next()) {
				
				BoardDTO bdt1 = new BoardDTO();
				bdt1.setB_id(rs.getString("b_id"));
				bdt1.setB_title(rs.getString("b_title"));
				boards.add(bdt1);
				
				
				
				
			}
			
			return boards;
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		return null;
	}
}
