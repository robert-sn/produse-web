package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.impl.UtilizatorDaoImpl;
import produse.Utilizator;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
				
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();		
		HttpSession session = request.getSession();
		String utilizator_nume =(String) session.getAttribute("utilizator_nume");
		
		UtilizatorDaoImpl utilizator = new UtilizatorDaoImpl();
		
		Utilizator util = new Utilizator(utilizator.selectUtilizator(utilizator_nume));
		
		if(util.getRol_id() == 5 ) {
			response.sendRedirect("/produse_web/");
			out.print("Te-ai deconectat cu succes!");
			request.getSession().invalidate();
		}else {
			response.sendRedirect("/produse_web/administrare");
			out.print("Te-ai deconectat cu succes!");
			request.getSession().invalidate();
		}
		
		
		
	
	
	}

	
	
}
