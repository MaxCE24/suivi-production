<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Liste des profils</title>
</head>
<body>
	<h1>Liste des profils</h1>
	<table style="text-align: center;" border="1px" cellpadding="0"
		cellspacing="0">
		<thead>
			<tr>


				<th width="25px">Libell�</th>

				<th width="50px">actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="profil" items="${profilList}">
				<tr>


					<td>${profil.libelle}</td>

					<td><a
						href="${pageContext.request.contextPath}/profil/edit/${profil.id}.html">Modifier</a><br />
						<a
						href="${pageContext.request.contextPath}/profil/delete/${profil.id}.html">Supprimer</a><br />
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="${pageContext.request.contextPath}/">Page d'accueil</a>
</body>
</html>