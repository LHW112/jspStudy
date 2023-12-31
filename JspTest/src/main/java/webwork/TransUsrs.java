package webwork;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import beans.UsrDTO;
import database.UsrDB;

/**
 * Servlet implementation class TransUsrs
 */
public class TransUsrs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransUsrs() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/transUsrs.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String u_id = request.getParameter("u_id");
		String u_pwd= request.getParameter("u_pwd");
		String u_name = request.getParameter("u_name");
		String phone= request.getParameter("phone");
		
		UsrDTO ud = new UsrDTO();
		ud.setU_id(u_id);
		ud.setU_pwd(u_pwd);
		ud.setU_name(u_name);
		ud.setPhone(phone);
		
		UsrDB udb = new UsrDB();
		udb.usrTrans(ud);
		
		
		response.sendRedirect("/JspTest/BoardMain");
		
	}

}