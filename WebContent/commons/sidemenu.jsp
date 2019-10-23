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
    <section style=" float: left;padding: 20px; width: 30%; background-color: lightblue;">
    <h2>Categorii</h2>
    <% for(Categorie cat : listaCategorie){ %>
    <form action="/produse_web/SelecteazaCategorie" method="post">
    <div class="row">
    	<div class="col">
    		<div  class="list-group">
    		
    			<input type="submit" name="categorie_nume" class="list-group-item list-group-item-action" 
    				value="<%=cat.getCategorie_nume() %>">
    			<input type="hidden" name="categorie_id" value="<%= cat.getCategorie_id() %>">	
    			 
    		</div>	
    	</div>
    </div>
    
    </form>
    <%} %> 
    </section>