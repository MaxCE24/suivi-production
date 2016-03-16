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
		<a href="${pageContext.request.contextPath}/astreinte/create.html">Créer
			une nouvelle astreinte</a><br /> <a
			href="${pageContext.request.contextPath}/astreinte/list.html">Consulter
			les astreintes</a><br />
	</p>

	<p>
		<a href="${pageContext.request.contextPath}/collaborateur/create.html">Créer
			un nouveau collaborateur</a><br /> <a
			href="${pageContext.request.contextPath}/collaborateur/list.html">Consulter
			les collaborateurs</a><br />
	</p>

</body>
</html>