
<%@page import="produse.Utilizator"%>
<section id="logonsection" style="float: none; padding: 20px; width: 100%; background-color: lightblue;
	background-image:url('https://i.pinimg.com/474x/22/a7/d9/22a7d900e789f94176d15ac206ffcbe6.jpg'); 
	background-repeat: no-repeat;
  	background-size: cover;
  	height: 100%;">

<div class="row">
	<div class="col-1">
		<span style= "color:red; font-size: 20px;">
			<strong><%=session.getAttribute("utilizator_nume") %></strong>
		</span>
	</div>
	<div class="col-1">
	<%
		Utilizator utilizator = (Utilizator) session.getAttribute("utilizator");
		if (utilizator != null && utilizator.getRol_id() == 5){ 
	%>
	
		<form action="/produse_web/angajati/coscumparaturi.jsp">
			<input style="border-radius:5px; background-color:#84c2d1;" type="submit" value="Cos">
		</form>		
	
	<%}%>
	</div>
	<div class="col-1">
		<%@include file="/butoane/logout.jsp" %>
	</div>
</div>

</section>
