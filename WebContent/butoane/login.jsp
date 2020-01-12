<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<section id="loginsection" style="float: none; padding: 20px; width: 100%; 
	background-image:url('https://i.pinimg.com/474x/22/a7/d9/22a7d900e789f94176d15ac206ffcbe6.jpg'); 
	background-repeat: no-repeat;
  	background-size: cover;
  	height: 100%;">

	<div class="container">
	<form action="/produse_web/Login" method="post" >
		
		<label for="username" style= "color:red">Utilizator:</label>
		<input style="background-color:#F37B2B;" id="username" type="text" name="utilizator_nume" placeholder="Username"><br>
		
		<label for="password" style= "color:red">Parola:</label>
		<input style= "background-color:#F37B2B; margin-left: 20px;" id="password" type="password" name="utilizator_parola" placeholder="Password"><br><br>
		  
		<input style="border-radius:5px; background-color:#84c2d1;" type="submit" id="login" value="Log in" >
		<input style="border-radius:5px; background-color:#84c2d1;" type="submit" value="Register" formaction="inregistrareClient/inregistrare.jsp"> 
	</form>
	</div>
</section>	
