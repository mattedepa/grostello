<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.cap.model.*"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.LinkedList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifica elemento</title>
<style>
<
jsp
:include
 
page
="css
.css
"/
>
</style>
</head>

<body>
	<a href="<%=request.getContextPath()%>/home"> torna a lista
		contatti </a>
	<div class="login">
		<form:form method="post" action="modificaElem" modelAttribute="formModificaElem">
	<form:label path="nuovoValore">${formModificaElem.nomeAltro}:</form:label>
	<c:choose>
				<c:when test="${formModificaElem.nomeAltro == 'cellulare'}">

					<form:input path="nuovoValore" onkeyup="controlloCellulare(this)" />
				</c:when>
				<c:otherwise>

					<form:input path="nuovoValore" onkeyup="controlloInserimento(this)" />
				</c:otherwise>

	</c:choose>
			<form:hidden path="idContatto"	value="${formModificaElem.idContatto}" />
			<form:hidden path="nomeAltro" value="${formModificaElem.nomeAltro}" />
			<form:hidden path="altroOcontatto" value="${formModificaElem.altroOcontatto}" />
			<input id='sbm' type="submit" value="Modifica" />
		</form:form>

	</div>
</body>



</html>