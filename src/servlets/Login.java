package servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DbUtils.DbSelect;
import dao.impl.CategorieDaoImpl;
import produse.Categorie;
import produse.Utilizator;


/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out =  response.getWriter();
		HttpSession session = request.getSession();
		
		String nume = request.getParameter("utilizator_nume");
		String parola = request.getParameter("utilizator_parola");
		int categorie_id = 0;
		
		Utilizator util = new Utilizator(DbSelect.selectUtilizator(nume, parola));
		session.setAttribute("utilizator_id", util.getUtilizator_id());
		session.setAttribute("utilizator_nume", nume);
		session.setAttribute("utilizator", util);
		session.setAttribute("categorie_id", categorie_id);
		switch(util.getRol_id()) {
			case 1: 
				
				request.getRequestDispatcher("angajati/administrator.jsp").include(request, response);								
				break;
			case 2: 
				
				 request.getRequestDispatcher("angajati/vanzator.jsp").include(request, response);				 
				break;
			case 3: 
				
				 request.getRequestDispatcher("angajati/marketing.jsp").include(request, response);				
				break;
			case 4: 
						 
				 request.getRequestDispatcher("angajati/gestionar.jsp").include(request, response);		
				 CategorieDaoImpl catdaoimpl = new CategorieDaoImpl();				 
				 List<Categorie> categorie = new ArrayList<>(catdaoimpl.selectCategorie());				 
				 session.setAttribute("categorie", categorie);
				 
				break;			
			case 5:
				 
				 request.getRequestDispatcher("angajati/produse.jsp").include(request, response);											
			break;			
			default: 
				 out.print("Sorry username or password error");  
		 		 request.getRequestDispatcher("index.jsp").include(request, response);		 		 
		 		break;
		}
		
		out.close();


		
		
	}

}
