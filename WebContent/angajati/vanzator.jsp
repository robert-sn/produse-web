
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="DbUtils.*" %>
    <%@page import="produse.Comanda" %>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
h2 {
  text-align: center;
}

table caption {
	padding: .5em 0;
}

@media screen and (max-width: 767px) {
  table caption {
    border-bottom: 1px solid #ddd;
  }
}

.p {
  text-align: center;
  padding-top: 140px;
  font-size: 14px;
}
</style>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>


<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
		List<Comanda> comenzi = new ArrayList<>(DbSelect.selectComanda("In asteptare"));
%>
<h1>Vanzare</h1>

<div class="container">
	<strong><%=session.getAttribute("utilizator_nume") %></strong>
	<%@include file="/butoane/logout.jsp" %>

</div>
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
              			<option value="In asteptare" ><%=comenzi.get(i).getStatus_comanda() %></option>
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