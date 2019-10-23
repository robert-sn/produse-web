<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<section id="loginsection" style="float: none; padding: 20px; width: 70%; background-color: lightblue;">

	<div class="container">
	<form action="/produse_web/Login" method="post" >
		Utilizator:<input type="text" name="utilizator_nume"><br>
		Parola:<input type="password" name="utilizator_parola"><br><br>
		  
		<input type="submit" id="login" value="Log in"" >
		<input type="submit" value="Register" formaction="inregistrareClient/inregistrare.jsp"> 
	</form>
	</div>
</section>	
