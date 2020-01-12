<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="DbUtils.*" %>
<%@page import="produse.Comanda" %>
<%@page import="java.util.*" %>

<!DOCTYPE html>
<html>
<%@ include file="/commons/head.jsp" %>
<body>

<%
		List<Comanda> comenzi = new ArrayList<>(DbSelect.selectComanda("In asteptare"));
%>

<%@ include file="/commons/header.jsp" %>

<h1 class="text-center">Vanzare</h1>

<div class="container">
  <div class="row">
    <div class="col-xs-12">
      <div class="table-responsive">
        <table class="table table-bordered table-hover">
          <thead>
            <tr>
              <th>Nume utilizator</th>
              <th>Data Comada</th>
              <th>Suma</th>
              <th>Modalitate plata</th>
              <th>Status</th>
            </tr>
          </thead>
          <tbody>
           <form action="/produse_web/StatusChange" method="post">
          <%
			for(int i=0; i<comenzi.size();i++){
		%>
            <tr>
            	
              <td><%=comenzi.get(i).getUtilizator_nume() %></td>
              <td><%=comenzi.get(i).getData() %>
              <td><%=comenzi.get(i).getSuma() %></td>
              <td><%=comenzi.get(i).getModalitate_plata() %></td>
              <td><select name="status_comanda">
	              		<% if (!comenzi.get(i).getStatus_comanda().isEmpty()) { %>
           				<option value="In asteptare" ><%=comenzi.get(i).getStatus_comanda() %></option>
	           			<% } %>
              			<option value="Aprobat">Aprobat</option>
              			<option value="Anulat">Anulat </option>
              		</select>              
             </td>
             
              <td>
              	<input type="hidden" name="comanda_id" value="<%=comenzi.get(i).getComanda_id() %>">
              	<input class="bg-success" type="submit" value="Trimite" >
              	
              </td>
              
              
            </tr>
          <%
			}
		  %>
		  </form>
          </tbody>
        </table>
      </div><!--end of .table-responsive-->
    </div>
  </div>
</div>
</body>
</html>