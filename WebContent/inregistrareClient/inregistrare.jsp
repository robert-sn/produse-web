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
<body 
	style="background-image:url('https://c-parity.com/wp-content/uploads/2017/02/claims-background.jpg'); 
	background-repeat: no-repeat;
  	background-size: cover;
  	height: 100%;
  	margin:0;
  	padding:0;">

<h2 style="color:white; text-align:center">Formular Inregistrare</h2>
	<form action="inregistrareFinal.jsp" method="post" 
	style="color:#ffb142; 
	font-family:serif;
	font-size:30px;
	text-align:center;
	height:100%;">
		
		Nume:
		<input style="color:red; font-size:20px;" type="text" name="utilizator_nume" value="<jsp:getProperty property="utilizator_nume" name="utilizatorNou"/>"><br><br>
		Parola:
		<input style="color:red; font-size:20px;" type="password" name="utilizator_parola" value="<jsp:getProperty property="utilizator_parola" name="utilizatorNou"/>"><br><br>
		
		<input  type="hidden" name="rol_id" value="5">
		
		<input type="submit" value="Next"  
		style=" vertical-align:middle
		padding-top:5px;
		color:green; 
		font-size:25px; 
		font-family:serif;"/>	

	</form>
</body>
</html>