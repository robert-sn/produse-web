<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="produse.Utilizator"%>

<jsp:useBean id="utilizatorNou" scope="session" class="produse.Utilizator"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Formular Inregistrare</h2>
	<form action="inregistrareFinal.jsp" method="post">
		
		Nume:<input type="text" name="utilizator_nume" value="<jsp:getProperty property="utilizator_nume" name="utilizatorNou"/>"><br>
		Parola:<input type="password" name="utilizator_parola" value="<jsp:getProperty property="utilizator_parola" name="utilizatorNou"/>"><br>
		
		<input  type="hidden" name="rol_id" value="5"><br>
		
		<input type="submit" value="Next">	

	</form>
</body>
</html>