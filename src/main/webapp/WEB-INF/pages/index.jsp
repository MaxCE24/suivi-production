<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Page d'accueil</title>
</head>
<body>
	<h1>Page d'accueil</h1>
	<p>
		Bienvenue sur "Suivi Production".<br /> <i>${message}</i><br />
	</p>
	<p>
		<a href="${pageContext.request.contextPath}/astreinte/create.html">Cr�er
			une nouvelle astreinte</a><br /> <a
			href="${pageContext.request.contextPath}/astreinte/list.html">Consulter
			les astreintes</a><br />
	</p>

	<p>
		<a href="${pageContext.request.contextPath}/collaborateur/create.html">Cr�er
			un nouveau collaborateur</a><br /> <a
			href="${pageContext.request.contextPath}/collaborateur/list.html">Consulter
			les collaborateurs</a><br />
	</p>

	<p>
		<a href="${pageContext.request.contextPath}/demandeDAchat/create.html">Cr�er
			une nouvelle demande d'achat</a><br /> <a
			href="${pageContext.request.contextPath}/demandeDAchat/list.html">Consulter
			les demandes d'achat</a><br />
	</p>

	<p>
		<a href="${pageContext.request.contextPath}/validation/create.html">Ajouter
			une validation</a><br /> <a
			href="${pageContext.request.contextPath}/validation/list.html">Consulter
			les validations</a><br />
	</p>

	<p>
		<a href="${pageContext.request.contextPath}/equipe/create.html">Ajouter
			une �quipe</a><br /> <a
			href="${pageContext.request.contextPath}/equipe/list.html">Consulter
			les �quipes</a><br />
	</p>

	<p>
		<a href="${pageContext.request.contextPath}/profil/create.html">Ajouter
			un profil</a><br /> <a
			href="${pageContext.request.contextPath}/profil/list.html">Consulter
			les profils</a><br />
	</p>

	<p>
		<a href="${pageContext.request.contextPath}/societe/create.html">Ajouter
			une soci�t�</a><br /> <a
			href="${pageContext.request.contextPath}/societe/list.html">Consulter
			les soci�t�s</a><br />
	</p>

	<p>
		<a href="${pageContext.request.contextPath}/sousTraitant/create.html">Ajouter
			un sous-traitant</a><br /> <a
			href="${pageContext.request.contextPath}/sousTraitant/list.html">Consulter
			les sous-traitants</a><br />
	</p>

</body>
</html>