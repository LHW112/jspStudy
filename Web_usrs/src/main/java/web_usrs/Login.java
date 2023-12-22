package web_usrs;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import UsrDB.Usr_db;
import beans.UsrDTo;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u_id = request.getParameter("u_id");		
		String pwd = request.getParameter("pwd");
		
		UsrDTo ud = new UsrDTo();
		ud.setU_id(u_id);
		ud.setPwd(pwd);
		
		
		Usr_db udb = new Usr_db();
		
		int t = (int) udb.select(ud);
		
		if(t == 0) {
			response.sendRedirect("/Web/usrs");
		}else {
			request.getRequestDispatcher("/Login");
		}
		
		System.out.println(ud.getU_id());
		
	}

}
