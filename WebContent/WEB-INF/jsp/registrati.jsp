<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.cap.model.*"%>
<%@ page import="java.util.LinkedList"%>
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
	<a href="<%=request.getContextPath() %>/home"> torna a login</a>
	<br> 
	<div class="login">
		<h3>INSERISCI I DATI</h3>
		<form:form method="post" action="registrati" modelAttribute="FormAggiungiUtente">
			<table id="tabella" class="login">
				<tr>
					<td>
						<form:label path="username">Username</form:label>:
					</td>
					<td><form:input path="username" onkeyup="controlloInserimento(this)"/> </td>

				</tr>
				<tr>
					<td>
						<form:label path="password">Password</form:label>:
					</td>
					<td><form:input path="password" onkeyup="controlloInserimento(this)"/> </td>
				</tr>
				
			</table>
			<br>
			
			<input id='sbm' type='submit' value='Submit'>
		</form:form>
		</div>
</body>



</html>