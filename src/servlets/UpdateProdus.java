package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProdusDAO;
import produse.Produs;


/**
 * Servlet implementation class UpdateProdus
 */
@WebServlet("/UpdateProdus")
public class UpdateProdus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Produs produs;
		String operatiune = new String(request.getParameter("operatiune")); 
		String produs_nume;
		response.setContentType("text/html");
		PrintWriter out =  response.getWriter();
		HttpSession session = request.getSession();
		String actiune = request.getParameter("actiune");//asupra bd




		if(actiune.equals("select") ) {
			//asupra produslui				
			produs_nume = request.getParameter("produs_nume");
			
			if(produs_nume!=null) {
				produs = new Produs(ProdusDAO.getData(produs_nume));
				session.setAttribute("produs", produs);				
			}
			session.setAttribute("operatiune", operatiune);
			request.getRequestDispatcher("angajati/marketing.jsp").include(request,response);
		
		}else if (actiune.equals("update")) {
			operatiune = new String((String) session.getAttribute("operatiune"));
			
			if(operatiune.equals("modificaPret")) {
				ProdusDAO.updateProdusPret(
						Integer.parseInt(request.getParameter("produs_id")), 
						Integer.parseInt(request.getParameter("produs_pret"))
						);
				
				produs = new Produs((Produs)session.getAttribute("produs"));
				produs.setProdus_pret(Integer.parseInt(request.getParameter("produs_pret")));
				session.setAttribute("produs", produs);
				out.print("Modificare pret reusit!");
				//response.sendRedirect("angajati/marketing.jsp");
				request.getRequestDispatcher("angajati/marketing.jsp").include(request,response);
			
			}else if (operatiune.equals("stareProdus")) {
				ProdusDAO.updateProdusStare(
						Integer.parseInt( request.getParameter("produs_id")),
						Boolean.parseBoolean(request.getParameter("produs_stare"))
						);	
				produs = new Produs((Produs)session.getAttribute("produs"));
				produs.setProdus_stare(Boolean.parseBoolean(request.getParameter("produs_stare")));
				session.setAttribute("produs", produs);
				out.print("Modificare stare reusit!");
				//response.sendRedirect("angajati/marketing.jsp");
				request.getRequestDispatcher("angajati/marketing.jsp").include(request,response);
			}

		}


		
		

	}

}
