package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import produse.CosCumparaturi;
import produse.Produs;
import produse.ProdusInCos;

/**
 * Servlet implementation class ScoateProdusDinCos
 */
@WebServlet("/ScoateProdusDinCos")
public class ScoateProdusDinCos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScoateProdusDinCos() {
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
		
		HttpSession session = request.getSession();
		ProdusInCos produs = new ProdusInCos();
		//session.getAttribute("produs_id");
		produs.setProdus_id(Integer.parseInt(request.getParameter("produs_id")));
		produs.setProdus_denumire(request.getParameter("produs_denumire"));
		CosCumparaturi cos = (CosCumparaturi) session.getAttribute("cos");
	 	if(cos == null) {
	 		cos = new CosCumparaturi();
	 	}
		
		
	 	if(cos.getLista().size()!= 0) {	 	
	 		cos.sterge(produs);	 		
	 	}
	 		session.setAttribute("cos", cos);
				
			request.getRequestDispatcher("angajati/coscumparaturi.jsp").include(request,response);
	}

}
