package webwork;

import java.io.IOException;

import beans.BoardDTO;
import database.UsrDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public Detail() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getParameter("b_id");
		UsrDB bdb = new UsrDB();
		BoardDTO bdt = new BoardDTO();
		bdt.setB_id(request.getParameter("b_id"));
		//반환타입???
		bdb.detail(bdt);
		request.setAttribute("bdt", bdt);
		request.getRequestDispatcher("/WEB-INF/detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
