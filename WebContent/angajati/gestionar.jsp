<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="produse.Categorie" %>
    <%@ page import="dao.impl.CategorieDaoImpl" %>
<%@ include file="/commons/head.jsp" %>
<body>

<div class="container">
<h1>Gestiune</h1>
	<strong><%=session.getAttribute("utilizator_nume") %></strong>	
	<%@include file="/butoane/logout.jsp" %>
<br><br>


<% 
	CategorieDaoImpl catDaoImpl = new CategorieDaoImpl();
	List<Categorie> categorie = new ArrayList<>(catDaoImpl.selectCategorie());
	
	
%>
<!-- Adaugare produse -->
<div class="container">
	<section style=" float: left;padding: 30px; width: 40%; background-color: #f1f1f1;">
		<h2>Introduceti produse !</h2>
		<form action="/produse_web/ProdNou" method="post">
			Denumire:<input type="text" name="produs_nume"><br>
			Pret: <input type="text" name="produs_pret"><br>
			Stoc:<input type="text" name="produs_stoc">/buc<br>
			Garantie:<input type="text" name="produs_garantie">/luni<br>
			Descriere:<input type="text" name="produs_descriere_scurta"><br>
			Categorie:<select name="categorie_id">
							<option>Alege</option>
						<% for(Categorie cat : categorie){	 %>
							<option value="<%=cat.getCategorie_id() %>"> <%=cat.getCategorie_nume() %></option>
						<% } %>
						</select><br>	
						
			<input type="hidden" name="adauga" value="produs">
			<input type="submit">
		</form>
	</section>
</div>

<!-- Adaugare categorii -->
<div class="container">
	<section style=" float: right;padding: 30px; width: 43%; background-color: #f1f1f1;">
		<h2>Introduceti categorii</h2>
		<form action="/produse_web/ProdNou" method="post">
			Categorie : <input type="text" name="categorie_nume"><br>
			<input type="hidden" name="adauga" value="categorie">
			<input type="submit">
		</form>
	</section>
</div>
</div>
</body>
</html>