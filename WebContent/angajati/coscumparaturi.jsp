<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="produse.*"%>
    <jsp:useBean id="produseCumparate" class="produse.ProdusInCos" scope="session" />
<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	CosCumparaturi cos =(CosCumparaturi)session.getAttribute("cos");
	if(cos == null) {
		cos = new CosCumparaturi();
	}
	int total = 0;
%>
<div class="container">
<strong><%=session.getAttribute("utilizator_nume") %></strong>
<%@include file="/butoane/inapoiLaCumparaturi.jsp" %>
<%@include file="/butoane/logout.jsp" %>
</div>
<div class="container">
<table class="table">
	<thead>
		<tr>
			<th></th>
			<th>Denumire</th>
			<th>Valoare</th>
			<th>Cantitate</th>
			<th>Cost</th>
			
		</tr>
	</thead>
	<%
	for(int i=0;i<cos.getLista().size();i++){
		total+=cos.getLista().get(i).getProdus_cost();
	%>
	<tr>
		<td></td>
		<td><%=cos.getLista().get(i).getProdus_denumire()  %></td>
		<td><%=cos.getLista().get(i).getProdus_valoare()     %></td>		
		<td><%=cos.getLista().get(i).getProdus_cantitate()   %></td>
		<td><%=cos.getLista().get(i).getProdus_cost()        %></td>
		<form action="/produse_web/ScoateProdusDinCos" method= "post">
		<input type="hidden" name="produs_id" value="<%=cos.getLista().get(i).getProdus_id()%>">
		<input type="hidden" name="produs_denumire" value="<%=cos.getLista().get(i).getProdus_denumire()%>">
		<td><input type="submit" value="-"> </td>
		</form>
	</tr>
	<% } %>
	<tr>
		<td></td>
		<td><ins><strong>Total</strong></ins></td>
		<td></td>
		<td></td>
		<td><strong><%=total %></strong></td>
	</tr>
	<tr>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<form action="/produse_web/TrimiteComanda" method="post">
			<td><input type="submit" value="Trimite Comanda"></td>
		</form>
	</tr>
	
</table>
</div>
</body>
</html>