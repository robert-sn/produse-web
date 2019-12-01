<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="produse.*" %>
<%@ page import="dao.*" %>
<%@ page import="dao.impl.*" %>
<%@ page import="java.util.*" %>
    
<% 
	CategorieDaoImpl catdaoimpl = new CategorieDaoImpl();
	List<Categorie> listaCategorie = new ArrayList<>(catdaoimpl.selectCategorie());
%>
<div>
	<h2 class="ml-3">Categorii</h2>
	<div class="m-2">
	<form action="/produse_web/SelecteazaCategorie" method="post">
		<div  class="list-group">
			<input type="submit" name="categorie_nume" class="list-group-item list-group-item-action" 
				value="Toate Produsele">
			<input type="hidden" name="categorie_id" value="0">	
		</div>	
	</form>
	<% for(Categorie cat : listaCategorie){ %>
	<form action="/produse_web/SelecteazaCategorie" method="post">
		<div  class="list-group">
			<input type="submit" name="categorie_nume" class="list-group-item list-group-item-action" 
				value="<%=cat.getCategorie_nume() %>">
			<input type="hidden" name="categorie_id" value="<%= cat.getCategorie_id() %>">	
		</div>	
	</form>
	<% } %> 
	</div>
</div>