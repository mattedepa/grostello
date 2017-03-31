<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.cap.model.*" %>
    <%@ page import="java.util.LinkedList" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Aggiungi campo</title>
<style>
	<jsp:include page="css.css"/>
</style>
<script type="text/javascript">
	<jsp:include page="js.js"/>
</script>
</head>


<body>
<a href="<%=request.getContextPath() %>/home"> torna a lista contatti </a>
<br>

<div class="login2">
		<h3>Aggiungi un campo</h3>
		<form:form method="post" action="aggiungiCampo" modelAttribute="idDelContatto">
		<table id="tabella" class="login">
	<tr> 
		<td> 
			<p>nome campo: </p>
		</td> 
		<td>
			<p>valore campo: </p>
		</td>

	</tr>
	<tr> 
		<td> 
			<form:input path="nuovoNome" onkeyup="controlloInserimento(this)" />
		</td> 
		<td>
			<form:input path="nuovoValore" onkeyup="controlloInserimento(this)" />
		</td>
	</tr>


</table>
<br>	
	<input type = "hidden" name = "id_contatto" value = "<%= request.getParameter("id_contatto") %>"/>
		<form:hidden path="idContatto" value="${idDelContatto.idContatto}" /> 
		<input id='sbm' type='submit' value='Submit'>
		</form:form>

</div>	

</body>



</html>