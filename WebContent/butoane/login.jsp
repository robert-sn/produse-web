<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<section id="loginsection" style="float: none; padding: 20px; width: 100%; background-color: lightblue;">

	<div class="container">
	<form action="/produse_web/Login" method="post" >
		
		<label for="username">Utilizator:</label>
		<input id="username" type="text" name="utilizator_nume" placeholder="Username"><br>
		
		<label for="password">Parola:</label>
		<input id="password" type="password" name="utilizator_parola" placeholder="Password"><br><br>
		  
		<input type="submit" id="login" value="Log in" >
		<input type="submit" value="Register" formaction="inregistrareClient/inregistrare.jsp"> 
	</form>
	</div>
</section>	
