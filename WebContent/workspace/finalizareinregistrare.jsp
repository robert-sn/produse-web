<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="produse.Utilizator" %>
    
    <jsp:useBean id="angajatNou" scope="session" class="produse.Utilizator"/>
    <jsp:setProperty property="*" name="angajatNou"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<form action="/produse_web/workspace/bunvenit.jsp">
		Utilizator:<jsp:getProperty property="utilizator_nume" name="angajatNou"/> <br>
		Parola:<jsp:getProperty property="utilizator_parola" name="angajatNou"/><br>
		Departament:<jsp:getProperty property="rol_id" name="angajatNou"/><br>
		
		<input type="submit" value="inapoi" formaction="inregistrareangajat.jsp">
		<input type="submit">
	
	</form>
</body>
</html>