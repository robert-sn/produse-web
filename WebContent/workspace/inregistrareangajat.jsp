<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="produse.*" %>
<%@ page import="java.util.*" %>
<%@ page import="dao.*" %>
<%@ page import="dao.impl.RolDaoImpl" %>
<%@ page import="org.apache.ibatis.*" %>
<%@ page import="org.apache.ibatis.io.*" %>

<jsp:useBean id="angajatNou" scope="session" class="produse.Utilizator"/>
<% 
	RolDaoImpl roldao = new RolDaoImpl();
	List<Rol> rol = new ArrayList<>(roldao.selectRol()); 
%>

<div class="container">
	<h2>Formular inregistrare angajat</h2>

	<div class="row" style="margin: 20px 3px;">
		<form  action="/produse_web/workspace/finalizareinregistrare.jsp">
			<div class="form-group">
				<label for="utilizator_nume">Utilizator:</label>
				<input class="form-control" type="text" name="utilizator_nume" value="<jsp:getProperty property="utilizator_nume" name="angajatNou"/>"> <br>
				
				<label for="utilizator_nume">Parola:</label>
				<input class="form-control" type="password" name="utilizator_parola" value="<jsp:getProperty property="utilizator_parola" name="angajatNou"/>"> <br>
				
				<label for="utilizator_nume">Departament:</label>
				<select class="custom-select" name="rol_id">
					<%for(Rol r : rol){ %>
						<option value="<%=r.getRol_id() %>"><%= r.getRol_nume() %></option>						
					<% } %>		
				</select>
				<input style="width: 50%; margin-top: 10px;" class="form-control btn btn-primary" type="submit">
			</div>
		</form>
	</div>
	
</div>
