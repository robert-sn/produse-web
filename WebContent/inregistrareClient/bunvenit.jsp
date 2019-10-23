<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="produse.Utilizator" %>
<%@ page import="DbUtils.DbInsert" %>

<jsp:useBean id="utilizatorNou" scope="session" class="produse.Utilizator" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
	DbInsert.insertUtilizator(utilizatorNou);
%>
<h3> Felicitari</h3> <br><br>

V-ati inregistrat cu succes! <br><br>
Idul dvs este <jsp:getProperty property="utilizator_id" name="utilizatorNou"/><br>
Nume: <jsp:getProperty property="utilizator_nume" name="utilizatorNou"/><br>
Parola: <jsp:getProperty property="utilizator_parola" name="utilizatorNou"/><br>
Tip utilizator: <jsp:getProperty property="rol_id" name="utilizatorNou"/>
<form action="">
	<input type="submit" value="Log in" formaction="/produse_web/index.jsp"><br>
</form>

<%
	session.removeAttribute("utilizatorNou");
%>
</body>
</html>