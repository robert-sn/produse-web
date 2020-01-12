<%@page import="DbUtils.DBUpdate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="DbUtils.DbSelect" %>
<%@ page import="java.util.*" %>
<%@ page import="produse.*" %>
<%@ page import="dao.*" %>
<%@ page import="org.apache.ibatis.*" %>
<%@ page import="org.apache.ibatis.io.*" %>
    
<%@ include file="/commons/head.jsp" %>


<%
	List<Produs> listaProdus = new ArrayList<>(ProdusDAO.selectListaProdusActiv());
%>
<body>
<div class="">
	<%@ include file="/commons/header.jsp" %>
	<div class="row ml-2 mr-2">
		<div class="col-4 mb-3">
			<%@ include file="/commons/sidemenu.jsp" %>	
		</div>
		<div class="mb-3 col-8">
			<h2>Produse</h2>
			<div class="" >
				<div class="row font-weight-bold text-center bg-info mb-6">
					<div class="col-1">Nr.</div>
					<div class="col-2">Denumire</div>
					<div class="col-1">Pret</div>
					<div class="col-2">Cantitate</div>
					<div class="col-1">Garantie</div>
					<div class="col-2">Descriere</div>
					<div class="col-1">Cantitate</div>
					<div class="col-2">Cos</div>
				</div>
			
				<% 
					int sesCategorie_id;
					if(session.getAttribute("categorie_id") != null){
						sesCategorie_id = (Integer)session.getAttribute("categorie_id");				
					}else{
						sesCategorie_id = 0;			
					}
					
					if(sesCategorie_id == 0){
						for(Categorie cat : listaCategorie){ 	
							for(Produs lista : listaProdus){ 
								if(cat.getCategorie_id() == lista.getCategorie_id()){
				%>
						
				<form class="" action="/produse_web/AdaugaProdusInCos" method="post">
					<div class="row">
						<div class="col-1" ><input type="hidden" name="produs_id" value="<%=lista.getProdus_id()%>"><% out.print(lista.getProdus_id());  %></div>
						<div class="col-3"><input type="hidden" name="produs_denumire" value="<%=lista.getProdus_nume()%>"><% out.print(lista.getProdus_nume());  %></div>		
						<div class="col-1"><input type="hidden" name="produs_valoare" value="<%=lista.getProdus_pret() %>"><% out.print(lista.getProdus_pret());  %></div>
						<div class="col-1"><% out.print(lista.getProdus_stoc());  %></div>
						<div class="col-1"><% out.print(lista.getProdus_garantie());  %></div>
						<div class="col-3"><% out.print(lista.getProdus_descriere_scurta());  %></div>	
						<div class="col-1" ><input style="width: 70px;" type="number" name="produs_cantitate" min="1" value="1" max="<%=lista.getProdus_stoc() %>"></div>
						<div class="col-1"><input style="background-color:#3c6382; color:#fad390;" type="submit" id="adaugaInCos" value="Add"></div>
					</div>
				</form>
				<%
								}
							}
						}
					}else{
				
						for(Produs lista : listaProdus){ 
							if(sesCategorie_id == lista.getCategorie_id()){
		
				%>
							<form class="" action="/produse_web/AdaugaProdusInCos" method="post">
								<div class="row mb-2">
									<div class="col-1" ><input type="hidden" name="produs_id" value="<%=lista.getProdus_id()%>"><% out.print(lista.getProdus_id());  %></div>
									<div class="col-2"><input type="hidden" name="produs_denumire" value="<%=lista.getProdus_nume()%>"><% out.print(lista.getProdus_nume());  %></div>		
									<div class="col-1"><input type="hidden" name="produs_valoare" value="<%=lista.getProdus_pret() %>"><% out.print(lista.getProdus_pret());  %></div>
									<div class="col-2"><% out.print(lista.getProdus_stoc());  %></div>
									<div class="col-1"><% out.print(lista.getProdus_garantie());  %></div>
									<div class="col-2"><% out.print(lista.getProdus_descriere_scurta());  %></div>	
									<div class="col-1"><input style="width: 70px;" type="number" name="produs_cantitate" min="1" value="1" max="<%=lista.getProdus_stoc() %>"></div>
									<div class="col-2"><input type="submit" id="adaugaInCos" value="Add"></div>
								</div>
							</form>
				<%
							}
						}
					}
				%>
			</div>
		</div>
		
	</div>
	
	<%@ include file="/commons/footer.jsp" %>
</div>
</body>
</html>
