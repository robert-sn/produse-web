package servlets;

import java.io.IOException;

import produse.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProdusDAO;
import produse.CosCumparaturi;

/**
 * Servlet implementation class TrimiteComanda
 */
@WebServlet("/TrimiteComanda")
public class TrimiteComanda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrimiteComanda() {
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
		HttpSession session = request.getSession();
		
		CosCumparaturi cos = (CosCumparaturi) session.getAttribute("cos");
		
		int utilizator_id = (int) session.getAttribute("utilizator_id");
		int sum = 0;
		String status_comanda = "In asteptare";
		String modalitate_plata = "cash";
		int produs_id = 0;
		int cant = 0;
		
		for(int i=0;i<cos.getLista().size();i++) {
			sum+= cos.getLista().get(i).getProdus_cost();					
		}
		
		
		java.util.Date date = new java.util.Date();
		
		Comanda comanda = new Comanda(utilizator_id, sum, status_comanda, modalitate_plata, DateUtil.convertDate(date));
		DbUtils.DbInsert.insertComanda(comanda);
		int comanda_id = comanda.getComanda_id();
		
		
		for(int i=0;i<cos.getLista().size();i++) {
			produs_id = cos.getLista().get(i).getProdus_id();
			cant = cos.getLista().get(i).getProdus_cantitate();
			
			ContinutComanda cc = new ContinutComanda(comanda_id,produs_id,cant);
			DbUtils.DbInsert.insertContinutComanda(cc);
			Produs produs = new Produs(ProdusDAO.getData(produs_id));
			int produs_cantitate = produs.getProdus_stoc() - cant;
			ProdusDAO.updateProdusCantitate(produs_id, produs_cantitate);
		}
		
		
		cos.stergeToateProduseleDinCos();
		request.getRequestDispatcher("/angajati/coscumparaturi.jsp").include(request, response);
		
	}

}
