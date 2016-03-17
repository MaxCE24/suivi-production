<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Liste des demandes d'achat</title>
</head>
<body>
	<h1>Liste des demandes d'achat</h1>
	<table style="text-align: center;" border="1px" cellpadding="0"
		cellspacing="0">
		<thead>
			<tr>

				<th width="150px">Num�ro</th>
				<th width="25px">Date</th>
				<th width="25px">Description</th>
				<th width="25px">Statut</th>
				<th width="25px">Num�ro de bon de commande</th>
				<th width="50px">actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="demandeDAchat" items="${demandeDAchatList}">
				<tr>

					<td>${demandeDAchat.numero}</td>
					<td>${demandeDAchat.date}</td>
					<td>${demandeDAchat.description}</td>
					<td>${demandeDAchat.statut}</td>
					<td>${demandeDAchat.numeroDeBonDeCommande}</td>
					<td><a
						href="${pageContext.request.contextPath}/demandeDAchat/edit/${demandeDAchat.id}.html">Modifier</a><br />
						<a
						href="${pageContext.request.contextPath}/demandeDAchat/delete/${demandeDAchat.id}.html">Supprimer</a><br />
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="${pageContext.request.contextPath}/">Page d'accueil</a>
</body>
</html>