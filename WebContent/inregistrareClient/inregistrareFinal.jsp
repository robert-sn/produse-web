<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="produse.Utilizator"%>

<jsp:useBean id="utilizatorNou" scope="session" class="produse.Utilizator"/>
    <jsp:setProperty property="*" name="utilizatorNou"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Formular Inregistrare</h2>
<form action="bunvenit.jsp" method="post">
	Nume: <jsp:getProperty property="utilizator_nume" name="utilizatorNou"/><br>
	Parola:<input type="password" value="<jsp:getProperty property="utilizator_parola" name="utilizatorNou"/>" ><br>
	<input  type="hidden" name="rol_id" value="<jsp:getProperty property="rol_id" name="utilizatorNou"/>"><br>
	
	<input type="submit" value="Back" formaction="inregistrare.jsp"><br>
	<input type="submit" value="Finally">	

</form>

</body>
</html>