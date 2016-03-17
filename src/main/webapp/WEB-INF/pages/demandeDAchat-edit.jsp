<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Page de modification de la demande d'achat</title>
</head>
<body>
	<h1>Page de modification de la demande d'achat</h1>
	<form:form method="POST" commandName="demandeDAchat"
		action="${pageContext.request.contextPath}/demandeDAchat/edit/${demandeDAchat.id}.html">
		<table>
			<tbody>
				<tr>
					<td>Numéro demande:</td>
					<td><form:input type="number" min="1" path="numero" /></td>
					<td><form:errors path="numero" cssStyle="color: red;" /></td>
				</tr>
				<tr>
					<td>Date demande:</td>
					<td><form:input type="date" path="date" /></td>
					<td><form:errors path="date" cssStyle="color: red;" /></td>
				</tr>
				<tr>

					<td>Description:</td>
					<td><form:input path="description" /></td>
					<td><form:errors path="description" cssStyle="color: red;" /></td>
				</tr>

				<tr>
					<td>Statut:</td>
					<td><form:select path="statut">
							<form:option value=""> --SELECT--</form:option>
							<form:option value="En attente de validation"> En attente de validation</form:option>
							<form:option value="Rejetée"> Rejetée</form:option>
							<form:option value="Sauvegardée"> Sauvegardée</form:option>
							<form:option value="Validée"> Validée</form:option>
						</form:select></td>
					<td><form:errors path="statut" cssStyle="color: red;" /></td>
				</tr>

				<tr>
					<td>Numéro de bon de commande:</td>
					<td><form:input type="number" min="1"
							path="numeroDeBonDeCommande" /></td>
					<td><form:errors path="numeroDeBonDeCommande"
							cssStyle="color: red;" /></td>
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