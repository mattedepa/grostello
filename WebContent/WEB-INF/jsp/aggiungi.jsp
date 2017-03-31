<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Aggiungi contatto</title>
<style>
	<jsp:include page="css.css"/>
</style>
<script type="text/javascript">
	<jsp:include page="js.js"/>
</script>
</head>


<body>
	<a href="<%=request.getContextPath() %>/home"> torna a lista contatti </a>
	<br> aggiungi un contatto

	<div class="login">
		<h3>INSERISCI I DATI</h3>
		<form:form method="post" action="aggiungi" modelAttribute="formNuovoUtente">
			<table id="tabella"class="login">
				<tr>
					<td><form:label path="nome">Nome</form:label></td>
					<td><form:input path="nome" /></td>
				</tr>
				<tr>
					<td><form:label path="cognome">Cognome</form:label></td>
					<td><form:input path="cognome" /></td>
				</tr>
				<tr>
					<td><form:label path="cellulare">Cellulare</form:label></td>
					<td><form:input path="cellulare" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit" /></td>
				</tr>
			</table>
		</form:form>
		</div>
</body>



</html>