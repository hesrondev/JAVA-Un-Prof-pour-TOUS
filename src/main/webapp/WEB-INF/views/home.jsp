<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!--
<link href="<c:url value="/resources/templated-transit/css/style.css" />"
	rel="stylesheet" type="text/css">
<link href="/resources/theme-default/bootstrap/css/bootstrap.css" rel="stylesheet"> -->

<title>UPPT | Accueil</title>
</head>
<body>
	<div id="bloc_page">

		<!--  HEADER INCLUSION  -->

		<div id="">
			<%@ include file="header.jsp"%>
		</div>

		<div id="home_menu">
			<nav>
			<ul>
				<li><a href="${pageContext.request.contextPath}/home.html">Accueil</a></li>
				<li><a href="${pageContext.request.contextPath}/professors.html">Professeurs</a></li>
				<li><a href="${pageContext.request.contextPath}/students.html">Elèves</a></li>
				<li><a href="${pageContext.request.contextPath}/guide.html">Guide</a></li>
			</ul>
			</nav>
		</div>

		<!-- Recherche d'annonce -->

		<div id="">
			<%@ include file="adSearchForm.jsp"%>
		</div>
		
		<br>
		
		<div align="center">
			<a href="${pageContext.request.contextPath}/ad/create.html"><strong>Publier une annonce</strong></a>
		</div>

		<!--  Dernières annonces -->

		<div>
			<strong>> Les dernières annonces d'élèves sur le site</strong> <a
				href="#">+ voir plus...</a> <br> 
				
			
			<strong>> Les
				dernières annonces de professeurs sur le site</strong> <a href="#">+ voir
				plus...</a>
		</div>

		<!--  FOOTER INCLUSION  -->
		<div class="footer">
			<%@ include file="footer.jsp"%>
		</div>

	</div>
</body>
</html>