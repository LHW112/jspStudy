package webwork;

import java.io.IOException;

import beans.UsrDTO;
import database.UsrDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Join
 */
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Join() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/join.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u_id = request.getParameter("u_id");
		String u_pwd= request.getParameter("u_pwd");
		String u_name = request.getParameter("u_name");
		String birthday= request.getParameter("birthday");
		String phone= request.getParameter("phone");
		
		UsrDTO ud = new UsrDTO();
		ud.setU_id(u_id);
		ud.setU_pwd(u_pwd);
		ud.setU_name(u_name);
		ud.setBirthday(birthday);
		ud.setPhone(phone);
		
		UsrDB udb = new UsrDB();
		udb.join(ud);
		
		response.sendRedirect("");
		
		
	}

}
