package web_usrs;

import java.io.IOException;

import UsrDB.Usr_db;
import beans.UsrDTo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Delet
 */
public class Delet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/delet").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsrDTo ust = new UsrDTo();
		Usr_db usd = new Usr_db();
		int result = usd.delete(ust) ;
		if (result == 1) {
			//삭제성공했으며, 성공시 페이지 이동을 하게 만들어주세요
			
			
			
		}else {
			//삭제에 실패 했으며, 실패시 페이지 이동을 하게 만들어주세요
			
			
			
		}
		
		
		
	}
}