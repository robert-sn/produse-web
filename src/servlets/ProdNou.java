package servlets;

import java.io.IOException;
import java.io.PrintWriter;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProdusDAO;
import dao.impl.CategorieDaoImpl;
import produse.Produs;

/**
 * Servlet implementation class prodNou
 */
@WebServlet("/ProdNou")
public class ProdNou extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdNou() {
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
		
		String adauga = request.getParameter("adauga");
		
		if(adauga.equals("produs")) {
					
			Produs prod = new Produs(
				request.getParameter("produs_nume"), 
				request.getParameter("produs_pret"), 
				request.getParameter("produs_stoc"), 
				request.getParameter("produs_garantie"), 
				request.getParameter("produs_descriere_scurta"), 
				request.getParameter("categorie_id"));
				
			ProdusDAO.insertProdus(prod);		
			out.print("Inregistrare reusita cu id-ul:"+prod.getProdus_id() +" !");
			
		}else if (adauga.equals("categorie")) {
			
			CategorieDaoImpl catdaoimpl = new CategorieDaoImpl();
			catdaoimpl.insertCategorie(request.getParameter("categorie_nume"));
			out.print("Categorie adaugata cu succes");
			
		}
		request.getRequestDispatcher("angajati/gestionar.jsp").include(request,response);
		
	}

}
