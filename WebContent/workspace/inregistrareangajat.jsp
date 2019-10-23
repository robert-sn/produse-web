<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="produse.*" %>
    <%@ page import="java.util.*" %>
    <%@ page import="dao.*" %>
    <%@ page import="dao.impl.RolDaoImpl" %>
    <%@ page import="org.apache.ibatis.*" %>
    <%@ page import="org.apache.ibatis.io.*" %>
    
    <jsp:useBean id="angajatNou" scope="session" class="produse.Utilizator"/>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>Formular inregistrare angajat</h2>
	
<br>
<br>
<div class="container">
	<strong><%=session.getAttribute("utilizator_nume") %></strong>
	
	<%@include file="/butoane/logout.jsp" %>

</div>

<div class="container"></div>

<% 
	RolDaoImpl roldao = new RolDaoImpl();
	List<Rol> rol = new ArrayList<>(roldao.selectRol()); 
%>
	<form action="/produse_web/workspace/finalizareinregistrare.jsp">
		Utilizator:<input type="text" name="utilizator_nume" value="<jsp:getProperty property="utilizator_nume" name="angajatNou"/>"> <br>
		Parola:<input type="password" name="utilizator_parola" value="<jsp:getProperty property="utilizator_parola" name="angajatNou"/>"> <br>
		Departament:<select name="rol_id">
						<%for(Rol r : rol){ %>
							<option value="<%=r.getRol_id() %>"><%= r.getRol_nume() %></option>						
						<% } %>		
					</select>
						<br><br> 
	
		<input type="submit">
	
	</form>
</div>
</body>
</html>