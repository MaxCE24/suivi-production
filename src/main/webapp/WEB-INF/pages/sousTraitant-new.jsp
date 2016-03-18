<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns:jsp="http://java.sun.com/JSP/Page">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Page de création d'un sous-traitant</title>
</head>
<body>
	<h1>Page de création d'un sous-traitant</h1>
	<form:form method="POST" commandName="sousTraitant"
		action="${pageContext.request.contextPath}/sousTraitant/create.html">
		<table>
			<tbody>
				<tr>
					<td>Nom:</td>
					<td><form:input path="nom" /></td>
					<td><form:errors path="nom" cssStyle="color: red;" /></td>
				</tr>
				<tr>
					<td>Prénom:</td>
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
					<td>Numéro de téléphone:</td>
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
					<td>Equipe:</td>
					<td><form:select path="equipe.id" items="${equipes}"
							itemValue="id" itemLabel="nom" /></td>
					<td><form:errors path="equipe.id" cssStyle="color: red;" /></td>
				</tr>
				<tr>
					<td>Profil:</td>
					<td><form:select path="profil.id" items="${profils}"
							itemValue="id" itemLabel="libelle" /></td>
					<td><form:errors path="profil.id" cssStyle="color: red;" /></td>
				</tr>
				<tr>
					<td>Société:</td>
					<td><form:select path="societe.id" items="${societes}"
							itemValue="id" itemLabel="raisonSociale" /></td>
					<td><form:errors path="societe.id" cssStyle="color: red;" /></td>
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