<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns:jsp="http://java.sun.com/JSP/Page">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Page de création d'une astreinte</title>
</head>
<body>
	<h1>Page de création d'astreinte</h1>
	<form:form method="POST" commandName="astreinte"
		action="${pageContext.request.contextPath}/astreinte/create.html">
		<table>
			<tbody>
				<tr>
					<td>Référence astreinte:</td>
					<td><form:input path="reference" /></td>
					<td><form:errors path="reference" cssStyle="color: red;" /></td>
				</tr>
				<tr>
					<td>Date d'astreinte:</td>
					<td><form:input type="date" path="date" /></td>
					<td><form:errors path="date" cssStyle="color: red;" /></td>
				</tr>
				<tr>

					<td>Nombre d'heures d'astreinte:</td>
					<td><form:input path="nombreHeures" /></td>
					<td><form:errors path="nombreHeures" cssStyle="color: red;" /></td>
				</tr>

				<tr>
					<td>Type d'astreinte:</td>
					<td><form:select path="type">
							<form:option value=""> --SELECT--</form:option>
							<form:option value="Sur site"> Sur site</form:option>
							<form:option value="Téléphonique"> Téléphonique</form:option>
						</form:select></td>
					<td><form:errors path="type" cssStyle="color: red;" /></td>
				</tr>

				<tr>
					<td>Collaborateur:</td>
					<td><form:select path="collaborateur.id"
							items="${collaborateurs}" itemValue="id" itemLabel="nomComplet" /></td>
					<td><form:errors path="collaborateur.id"
							cssStyle="color: red;" /></td>
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