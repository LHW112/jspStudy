package webwork;

import java.io.IOException;

import beans.UsrDTO;
import database.UsrDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = (String)request.getAttribute("msg");		
		if(msg == null) {
			request.setAttribute("msg", msg);
		}
		request.getRequestDispatcher("/JspTest/login.jsp").forward(request, response);
		// TODO Auto-generated method stub
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String u_id = request.getParameter("u_id");
		String u_pwd = request.getParameter("u_pwd");
		
		UsrDTO ud = new UsrDTO();
		ud.setU_id(u_id);
		ud.setU_pwd(u_pwd);
		
		UsrDB udb = new UsrDB();
		int result = udb.login(ud);
		
		if(result == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("usr", ud);
			response.sendRedirect("/TestWeb/BoardMain");
		}
		else {
			request.setAttribute("msg", "로그인실패");
			doGet(request,response);
		}
	}

}
