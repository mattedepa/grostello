<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.cap.model.*" %>
    <%@ page import="java.util.List" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>

<body>
<a href="<%=request.getContextPath() %>/home"> torna a lista contatti </a>
<div class="modifica">
<table  class="modifica">

	<tr>
	<td>
	nome:
	</td>
	<td>
	${contatto.nome}
	</td>
	<td>
	<form:form method="post" action="modificaElem" modelAttribute="formModificaElem">
	<form:hidden path="idContatto" value="${contatto.idContatto}" /> 
	<form:hidden path="nomeAltro" value="nome" /> 
	<form:hidden path="altroOcontatto" value="c" /> 
	<input type = "submit" value = "Modifica"/>
	</form:form>
	</td>
	</tr>
	<tr>
	<td>
	cognome:
	</td>
	<td>
	${contatto.cognome}
	</td>
	<td>
	<form:form method="post" action="modificaElem" modelAttribute="formModificaElem">
	<form:hidden path="idContatto" value="${contatto.idContatto}" /> 
	<form:hidden path="nomeAltro" value="cognome" /> 
	<form:hidden path="altroOcontatto" value="c" /> 
	<input type = "submit" value = "Modifica"/>
	</form:form>
	</td>
	</tr>
	<tr>
	<td>
	cellulare:
	</td>
	<td>
	${contatto.cellulare}
	</td>
	<td>
	<form:form method="post" action="modificaElem" modelAttribute="formModificaElem">
	<form:hidden path="idContatto" value="${contatto.idContatto}" /> 
	<form:hidden path="nomeAltro" value="cellulare" /> 
	<form:hidden path="altroOcontatto" value="c" /> 
	<input type = "submit" value = "Modifica"/>
	</form:form>
	</td>
	</tr>
	<c:forEach items="${contatto.altriDati}" var="dati">
		<tr>	
		<td>	
		${dati.nome_campo}:
		</td>
		<td>
		${dati.valore_campo}<br>		
		</td>
		<td>
		<form:form method="post" action="modificaElem" modelAttribute="formModificaElem">
		<form:hidden path="idContatto"  value = "${dati.idAltriCampi}"/>
		<form:hidden path="nomeAltro" value = "${dati.nome_campo}"/>
		<form:hidden path="altroOcontatto" value = "a"/>
		<input type = "submit" value = "Modifica"/>
		</form:form>
		</td>
		<td>
		<form:form method="post" action="eliminaCampo" modelAttribute="formModificaElem">
		<form:hidden path="idContatto" value = "${dati.idAltriCampi}"/>
		<form:hidden path="nomeAltro" value = "${dati.nome_campo}"/>
		<form:hidden path="altroOcontatto" value = "a"/>
		<input type = "submit" value = "Elimina"/>
		</form:form>
		</td>
		</tr>		
</c:forEach>
<tr>
<td>

<form:form method="post" action="aggiungiCampo" modelAttribute="idContatto">
	<form:hidden path="idContatto"  value = "${contatto.idContatto}"/>
	<input type = "submit" value = "Aggiungi campo"/>
	</form:form>

</td>
</tr>


</table>

</div>
</body>



</html>