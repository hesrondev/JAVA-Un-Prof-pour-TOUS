<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link href="<c:url value="/resources/theme-default/css/header.css" />" rel="stylesheet" type="text/css">
	
	<title>UPPT | Accueil</title>
</head>
<body>

<!--  HEADER INCLUSION  -->

<%@ include file="header.jsp"%>

	<h1>Bienvenue sur Un Prof Pour Tous</h1>

	<div>
		<ul>
			<li>
				<h2>Liste des autres pages</h2>
			</li>
			<li><a href="${pageContext.request.contextPath}/professors.html">Gestionnaire de professeurs</a></li>
			<li><a href="${pageContext.request.contextPath}/students.html">Gestionnaire d'élèves</a></li>
		</ul>
	</div>

</body>
</html>