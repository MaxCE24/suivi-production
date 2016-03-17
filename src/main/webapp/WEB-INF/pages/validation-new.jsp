<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns:jsp="http://java.sun.com/JSP/Page">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Page de validation d'une demande d'achat</title>
</head>
<body>
	<h1>Page de validation d'une demande d'achat</h1>
	<form:form method="POST" commandName="validation"
		action="${pageContext.request.contextPath}/validation/create.html">
		<table>
			<tbody>
				<tr>
					<td>Valideur:</td>
					<td><form:select path="valideur.id" items="${collaborateurs}"
							itemValue="id" itemLabel="nomComplet" /></td>
					<td><form:errors path="valideur.id" cssStyle="color: red;" /></td>
				</tr>

				<tr>
					<td>Demande d'achat:</td>
					<td><form:select path="demandeDAchat.id"
							items="${demandesDAchat}" itemValue="id" itemLabel="numero" /></td>
					<td><form:errors path="demandeDAchat.id"
							cssStyle="color: red;" /></td>
				</tr>

				<tr>
					<td>Date de validation:</td>
					<td><form:input type="date" path="date" /></td>
					<td><form:errors path="date" cssStyle="color: red;" /></td>
				</tr>

				<tr>
					<td><input type="submit" value="Ajouter" /></td>
					<td></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</form:form>
	<a href="${pageContext.request.contextPath}/">Page d'acceuil</a>
</body>
</html>