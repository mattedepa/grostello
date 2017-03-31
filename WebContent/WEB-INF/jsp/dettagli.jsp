<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.cap.model.*" %>
    <%@ page import="java.util.List" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dettagli</title>
<style>
	<jsp:include page="css.css"/>
</style>
</head>

<body>
<a href="<%=request.getContextPath() %>/home">torna a lista contatti</a>
<div class="login">
<table class="login">

	<tr>
	<td>
	nome:
	</td>
	<td>
	${contatto.nome}
	</td>
	</tr>
	<tr>
	<td>
	cognome:
	</td>
	<td>
	${contatto.cognome}
	</td>
	</tr>
	<tr>
	<td>
	cellulare:
	</td>
	<td>
	${contatto.cellulare}
	</td>
	</tr>
	
	<c:forEach items="${contatto.altriDati}" var="dati">
	
		
		<tr>	
		<td>	
		${dati.nome_campo}:
		</td>
		<td>		
		${dati.valore_campo}
		</td>
		</tr>		
	</c:forEach>

</table>
</div>
</body>



</html>