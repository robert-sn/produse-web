
<body>
<header>
	<section >
	<%if (session.getAttribute("utilizator_nume") == null){ %>	
		<%@ include file="/butoane/login.jsp" %>	
	<%}else{ %>	
		<%@ include file="/commons/logon.jsp" %>		
	<%} %>
	</section>
</header>
