package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CosCumparaturi
 */
@WebServlet("/StatusChange")
public class StatusChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatusChange() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out =  response.getWriter();
		
		
		DbUtils.DBUpdate.updateComanda(
				request.getParameter("status_comanda"), 
				Integer.parseInt(request.getParameter("comanda_id"))
				);
		out.print("Modificare reusita!");
		out.print(request.getAttribute("status_comanda"));
		out.print(request.getAttribute("comanda_id"));		
		request.getRequestDispatcher("angajati/vanzator.jsp").include(request,response);
	}

}
