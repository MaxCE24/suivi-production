<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Page de modification d'une équipe</title>
</head>
<body>
	<h1>Page de modification d'une équipe</h1>
	<form:form method="POST" commandName="equipe"
		action="${pageContext.request.contextPath}/equipe/edit/${equipe.id}.html">
		<table>
			<tbody>

				<tr>
					<td>Nom d'équipe:</td>
					<td><form:input path="nom" /></td>
					<td><form:errors path="nom" cssStyle="color: red;" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Modifier" /></td>
					<td></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</form:form>
	<a href="${pageContext.request.contextPath}/">Page d'accueil</a>
</body>
</html>