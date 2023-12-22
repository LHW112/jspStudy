package web_usrs;

import java.io.IOException;

import UsrDB.Usr_db;
import beans.UsrDTo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Web_usrs
 */
public class Web_usrs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Web_usrs() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/web_usrs.jsp").forward(request,response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u_id = request.getParameter("u_id");
		String pwd = request.getParameter("pwd");
		String u_name = request.getParameter("u_name");
		String birthday = request.getParameter("birthday");
		String phone = request.getParameter("phone");
		
		UsrDTo ud = new UsrDTo();
		ud.setU_id(u_id);
		ud.setPwd(pwd);
		ud.setU_name(u_name);
		ud.setBirthday(birthday);
		ud.setPhone(phone);
		
		Usr_db udb = new Usr_db();
		udb.join(ud);
		
	}

}
