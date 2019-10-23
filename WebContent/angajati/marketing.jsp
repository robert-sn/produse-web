<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="DbUtils.DbSelect"%>
<%@ page import="java.util.*"%>
<%@ page import="produse.*"%>
<%@ page import="dao.*"%>
<%@ page import="dao.impl.*"%>

<%@ include file="/commons/head.jsp"%>
<%@ include file="/commons/header.jsp"%>

<%
	String operatiuneDinSesiune = "";
	if(session.getAttribute("operatiune") != null){
		operatiuneDinSesiune =(String) session.getAttribute("operatiune");
	}

	
	boolean edp = false;
	boolean eda = false;
		if(operatiuneDinSesiune.equals("modificaPret")){
			edp = true;
			eda = false;
		}else if (operatiuneDinSesiune.equals("stareProdus")){
			eda = true;
			edp = false;
		}
	Produs produs = (Produs) session.getAttribute("produs");

	List<Produs> listaProdus = new ArrayList<>(ProdusDAO.getData());
	CategorieDaoImpl catDaoImpl = new CategorieDaoImpl();
	List<Categorie> listaCategorie = new ArrayList<>(catDaoImpl.selectCategorie());
%>

<div class="container">
	<h2>Marketing</h2>
	

<form action="/produse_web/UpdateProdus" method="post">
	<section
		style="float: left; padding: 20px; width: 70%; background-color: #f1f1f1;">
		
			<div class="row">
				<div class="col">Operatiune</div>
				<div class="col">Cauta produs</div>
				<div class="col"></div>
			</div>
			<div class="row">
				<div class="col">
					<select class="form-control" id="operatiune" name="operatiune">
						<option value="alege">Alege</option>
						<option value="modificaPret">Modifica pret</option>
						<option value="stareProdus">Stare Produs</option>
					</select>
				</div>
				<div class="col">
					<input class="form-control" type="text" width="300" name="produs_nume">
				</div>
				<div class="col">
					<input type="submit" name="actiune"	value="select"> 					
				</div>
			</div>
		
	
		<div class="container">

			<div class="row">
				<div class="col">Nr</div>
				<div class="col">Denumire</div>
				<div class="col">Pret</div>
				<div class="col">Cantitate</div>
				<div class="col">Status</div>
				<div class="col">Actiune</div>
			</div>
			<%
				if (produs != null) {
			%>
			
				<div class="row">
				<!-- produs_id -->
					<div class="col"><%=produs.getProdus_id()%></div>
						<input type="hidden" id="produs_id" 
							name="produs_id" value="<%=produs.getProdus_id()%>">
							
				<!-- produs_nume -->
					<div class="col"><%=produs.getProdus_nume()%></div>
					
				<!-- produs-pret -->	
					<div class="col">
						<input class="form-control" type="text" id="produs_pret" contenteditable="<%=edp %>"
							name="produs_pret" value="<%=produs.getProdus_pret()%>">
					</div>
					
				<!-- produs_stoc -->
					<div class="col"><%=produs.getProdus_stoc()%></div>
					
				<!-- produs_stare -->	
					<div class="col">
						
							<select class="form-control" name="produs_stare">
								<option>produs.getProdus_stare()</option>
								<option value="true">Activ</option>
								<option value="flase">Inactiv</option>
							</select>
					</div>
					
				<!-- buton submit actiune -->	
					<div class="col">
						<input type="submit" name="actiune"	value="update">
					</div>
				</div>
			
			<%
				}
			%>
		</div>
	</section>

</form>
</div>

<%@ include file="/commons/footer.jsp"%>