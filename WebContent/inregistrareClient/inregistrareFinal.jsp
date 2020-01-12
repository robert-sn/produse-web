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
<body
   style="background-image:url('https://image.shutterstock.com/image-vector/welcome-abstract-background-sign-light-260nw-583376173.jpg'); 
	background-repeat: no-repeat;
  	background-size: cover;
  	height: 100%;
  	margin:0;
  	padding:0;"
>
<h2 style="color:white; text-align:center">Formular Inregistrare</h2>
<form action="bunvenit.jsp" method="post" action="inregistrareFinal.jsp" method="post" 
	style="color:#ffb142; 
	font-family:serif;
	font-size:30px;
	text-align:center;
	height:100%;">
	
	Nume: <jsp:getProperty property="utilizator_nume" name="utilizatorNou"/><br>
	Parola:<input type="password" value="<jsp:getProperty property="utilizator_parola" name="utilizatorNou"/>" ><br>
	<input  type="hidden" name="rol_id" value="<jsp:getProperty property="rol_id" name="utilizatorNou"/>">
	
	<input type="submit" value="Back" formaction="inregistrare.jsp" style=" vertical-align:middle
		padding-top:5px;
		color:green; 
		font-size:25px; 
		font-family:serif;"><br>
	<input type="submit" value="Finally" style=" vertical-align:middle
		padding-top:5px;
		color:green; 
		font-size:25px; 
		font-family:serif;">	

</form>

</body>
</html>