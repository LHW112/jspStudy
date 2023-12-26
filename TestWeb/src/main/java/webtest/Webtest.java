package webtest;

import java.io.IOException;

import beans.UsrDTO;
import db.Usr_db;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Webtest
 */
public class Webtest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Webtest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Webtest.jsp").forward(request, response);
        	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u_name 	= 	request.getParameter("u_name");
		String u_id 	= 	request.getParameter("u_id");
		String pwd		= 	request.getParameter("pwd");
		String birthday = 	request.getParameter("birthday");
		String phone	= 	request.getParameter("phone");
		
		UsrDTO us = new UsrDTO();
		us.setU_id(u_id);
		us.setPhone(phone);
		us.setPwd(pwd);
		us.setBirthday(birthday);
		us.setU_name(u_name);
		
		Usr_db ud = new Usr_db();
		ud.join(us);
		
		response.sendRedirect("/TestWeb/Login");
		
	}

}
