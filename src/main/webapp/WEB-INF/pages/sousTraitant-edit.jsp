<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Page de modification du sous-traitant</title>
</head>
<body>
	<h1>Page de modification du sous-traitant</h1>
	<form:form method="POST" commandName="sousTraitant"
		action="${pageContext.request.contextPath}/sousTraitant/edit/${sousTraitant.id}.html">
		<table>
			<tbody>
				<tr>
					<td>Nom:</td>
					<td><form:input path="nom" /></td>
					<td><form:errors path="nom" cssStyle="color: red;" /></td>
				</tr>
				<tr>
					<td>Pr�nom:</td>
					<td><form:input path="prenom" /></td>
					<td><form:errors path="prenom" cssStyle="color: red;" /></td>
				</tr>
				<tr>
					<td>Sexe:</td>
					<td><form:select path="sexe">
							<form:option value="Homme"> Homme</form:option>
							<form:option value="Femme"> Femme</form:option>
						</form:select></td>
					<td><form:errors path="sexe" cssStyle="color: red;" /></td>
				</tr>
				<tr>
					<td>Num�ro de t�l�phone:</td>
					<td><form:input path="numeroDeTelephone" /></td>
					<td><form:errors path="numeroDeTelephone"
							cssStyle="color: red;" /></td>
				</tr>
				<tr>
					<td>Date de recrutement:</td>
					<td><form:input type="date" path="dateRecrutement" /></td>
					<td><form:errors path="dateRecrutement" cssStyle="color: red;" /></td>
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