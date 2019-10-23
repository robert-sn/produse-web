<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="produse.Utilizator" %>
<%@ page import="DbUtils.DbInsert" %>

<jsp:useBean id="angajatNou" scope="session" class="produse.Utilizator" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
	DbInsert.insertUtilizator(angajatNou);
%>
<h3> Felicitari</h3> <br><br>

V-ati inregistrat cu succes! <br><br>
Idul dvs este <jsp:getProperty property="utilizator_id" name="angajatNou"/><br>
Nume: <jsp:getProperty property="utilizator_nume" name="angajatNou"/><br>
Parola: <jsp:getProperty property="utilizator_parola" name="angajatNou"/><br>
Tip utilizator: <jsp:getProperty property="rol_id" name="angajatNou"/>

<form action="/produse_web/workspace/inregistrareangajat.jsp">
	<input type="submit" value=" ok "><br>
</form>

<%
	session.removeAttribute("angajatNou");
%>
</body>
</html>