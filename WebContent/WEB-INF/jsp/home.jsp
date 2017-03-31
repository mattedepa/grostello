<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.cap.model.*"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rubrica</title>

</head>

<body>
	<p class="logout">
		Ciao
		${username}
		<a href="${pageContext.request.contextPath}/logout">logout</a>
	</p>
	<form:form method="post" action="eliminaAccount">
		<input type="submit" value="elimina account" />
	</form:form>

	<div class="home">
		<table class="home">
			<tr>
				<td>NOME</td>
				<td>COGNOME</td>
				<td>CELLULARE</td>
			</tr>

			<c:forEach items="${rubrica}" var="contatto">
				<tr>

					<td>${contatto.nome}</td>

					<td>${contatto.cognome}</td>

					<td>${contatto.cellulare}</td>

					<td>
						<form:form method="post" action="dettagli" modelAttribute="idDelContatto">
							<form:hidden path="idContatto" value="${contatto.idContatto}" /> 
							<input type="submit" value="dettagli" />
						</form:form>
					</td>

					<td>
						<form:form method="post" action="elimina" modelAttribute="idDelContatto">
							<form:hidden path="idContatto" value="${contatto.idContatto}" /> 
							<input type="submit" value="elimina" />
						</form:form>
					</td>

					<td>
						<form:form method="post" action="modifica" modelAttribute="idDelContatto">
							<form:hidden path="idContatto" value="${contatto.idContatto}" /> 
							<input type="submit" value="modifica" />
						</form:form>
					</td>

				</tr>

			</c:forEach>

		</table>

		<a href="${pageContext.request.contextPath}/aggiungi">aggiungi
			contatto</a>

	</div>

</body>


</html>