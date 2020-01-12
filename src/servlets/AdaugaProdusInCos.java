package servlets;
import produse.*;
import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class adaugaProdusInCos
 */
@WebServlet("/AdaugaProdusInCos")
public class AdaugaProdusInCos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher rd; 
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdaugaProdusInCos() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	 doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out =  response.getWriter();
		
		HttpSession session = request.getSession();
		
		ProdusInCos produs = new ProdusInCos(
						Integer.parseInt(request.getParameter("produs_id")),
						request.getParameter("produs_denumire"),
						Integer.parseInt(request.getParameter("produs_valoare")),
						Integer.parseInt(request.getParameter("produs_cantitate"))
				);
		produs.setProdus_cost(produs.getProdus_valoare(), produs.getProdus_cantitate());
	 	
	 	CosCumparaturi cos = (CosCumparaturi) session.getAttribute("cos");
	 	if(cos == null) {
	 		cos = new CosCumparaturi();
	 	}
		
		
	 	if(cos.getLista().size()!= 0) {
	 		int pos = -1;
	 		for(int i=0;i<cos.getLista().size();i++) {
				
				if(cos.getLista().get(i).getProdus_id() == produs.getProdus_id() ) {
					pos = i;					
				}				
			}
	 		
	 		
	 		if (pos != -1) {
	 			cos.getLista().get(pos).setProdus_cantitate(produs.getProdus_cantitate());				
				cos.getLista().get(pos).setProdus_cost(cos.getLista().get(pos).getProdus_cantitate() ,cos.getLista().get(pos).getProdus_valoare());
				 			
	 		}else { 
				cos.addProdusInCos(produs);			
			}
	 	}else cos.addProdusInCos(produs);
		
		session.setAttribute("cos", cos);
		/*
		out.print("<div class='container'> <strong>"+nume+"</strong>");
		request.getRequestDispatcher("butoane/cos.jsp").include(request, response);	
		request.getRequestDispatcher("butoane/logout.jsp").include(request, response);		 
		
		out.print("</div>");
		*/		
		request.getRequestDispatcher("angajati/produse.jsp").include(request,response);
	}

}
