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
<%@ include file="/commons/header.jsp" %>


<%
	List<Produs> listaProdus = new ArrayList<>(ProdusDAO.selectListaProdusActiv());
	
%>

<div class="container">



<%@ include file="/commons/sidemenu.jsp" %>	

<div class="container">
<article style=" float: right;padding: 20px; width: 70%; background-color: #f1f1f1;" >
	<h2>Produse</h2>
	<div class="row">
		<div class="col">Nr</div>
		<div class="col">Denumire</div>
		<div class="col">Pret</div>
		<div class="col">Cantitate</div>
		<div class="col">Garantie</div>
		<div class="col">Descriere</div>
		<div class="col">Cantitate</div>
		<div class="col">Add Cos</div>
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
			
	<form class="form-group" action="/produse_web/AdaugaProdusInCos" method="post">
		<div class="row">
			<div class="col" ><input type="hidden" name="produs_id" value="<%=lista.getProdus_id()%>"><% out.print(lista.getProdus_id());  %></div>
			<div class="col"><input type="hidden" name="produs_denumire" value="<%=lista.getProdus_nume()%>"><% out.print(lista.getProdus_nume());  %></div>		
			<div class="col"><input type="hidden" name="produs_valoare" value="<%=lista.getProdus_pret() %>"><% out.print(lista.getProdus_pret());  %></div>
			<div class="col"><% out.print(lista.getProdus_stoc());  %></div>
			<div class="col"><% out.print(lista.getProdus_garantie());  %></div>
			<div class="col"><% out.print(lista.getProdus_descriere_scurta());  %></div>	
			<div class="col"><input class="form-control" type="number" name="produs_cantitate" min="1" value="1" max="<%=lista.getProdus_stoc() %>"></div>
			<div class="col"><input type="submit" id="adaugaInCos" value="Add"></div>
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
					<form class="form-group" action="/produse_web/AdaugaProdusInCos" method="post">
						<div class="row">
							<div class="col" ><input type="hidden" name="produs_id" value="<%=lista.getProdus_id()%>"><% out.print(lista.getProdus_id());  %></div>
							<div class="col"><input type="hidden" name="produs_denumire" value="<%=lista.getProdus_nume()%>"><% out.print(lista.getProdus_nume());  %></div>		
							<div class="col"><input type="hidden" name="produs_valoare" value="<%=lista.getProdus_pret() %>"><% out.print(lista.getProdus_pret());  %></div>
							<div class="col"><% out.print(lista.getProdus_stoc());  %></div>
							<div class="col"><% out.print(lista.getProdus_garantie());  %></div>
							<div class="col"><% out.print(lista.getProdus_descriere_scurta());  %></div>	
							<div class="col"><input class="form-control" type="number" name="produs_cantitate" min="1" value="1" max="<%=lista.getProdus_stoc() %>"></div>
							<div class="col"><input type="submit" id="adaugaInCos" value="Add"></div>
						</div>
					</form>
<%
					}
				}
			}
%>

</article>
</div>

<%@ include file="/commons/footer.jsp" %>
</div>
