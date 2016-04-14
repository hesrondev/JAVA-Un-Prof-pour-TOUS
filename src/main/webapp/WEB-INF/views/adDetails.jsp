<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="http://fonts.googleapis.com/css?family=Varela"
	rel="stylesheet" />
<link
	href="<c:url value="/resources/templated-plaindisplay/default.css"/>"
	rel="stylesheet" type="text/css" media="all" />
<link
	href="<c:url value="/resources/templated-plaindisplay/fonts.css" />"
	rel="stylesheet" type="text/css" media="all" />
<title>UPPT | <c:if test="${!empty annonce}">${annonce.title}</c:if></title>
</head>
<body>

	<!--  HEADER INCLUSION  -->
	<div class="header">
		<%@ include file="header.jsp"%>
	</div>

	<!-- En tête de l'annonce -->
	<br><br>
	<div>
		<c:if test="${!empty annonce}">
		
		<div>
			<h2>${annonce.title}</h2>
			<p>Par <a href="${pageContext.request.contextPath}/profile/${item.user.id}">${annonce.user.lastName} ${annonce.user.firstName}</a> &#8226 ${annonce.location} &#8226 Date</p>
		</div>
		
		<!--  Contact de l'annonceur -->
		<div>
			<h3>** Candidatures</h3>
			<p>Comparez vous aux autres candidats</p>
			<p><strong><a href="${pageContext.request.contextPath}/annonces/candidater/${annonce.id}">Candidater à l'annonce</a></strong></p>
		</div>
		
		<!--  Suite des détails de l'annonce -->
		<div>
			<hr>
			<p>Matière: ${annonce.subject}<br>
			Niveau: ${annonce.level}<br>
			Tarif: ${annonce.costPerHour} euros par heure<br>
			Contact: **Téléphone** ou Laissez un message à l'annonceur en candidatant à l'annonce.</p>
			<hr><br>
			<h3>Description</h3>
			<p>${annonce.description}</p>
			<br><br>
			<p><strong><a href="${pageContext.request.contextPath}/annonces/candidater/${annonce.id}">Candidater</a></strong></p>
			<p><strong><a href="#">Sauvegarder l'annonce</a></strong></p>
			
		</div>
		
		</c:if>	
	</div>
	
	<!--  A ranger à droite de l'écran -->
	<hr>
	<div>
		<h3>Offres similaires</h3>
		<br>
		<ul>
			<c:forEach items="${annonces}" var="item">
				<li>
					<strong><a href="${pageContext.request.contextPath}/annonces/${item.id}">${item.title}</a></strong><br>
					${item.location} &#8226 Date**
				</li>	
			</c:forEach>
	
		</ul>
		
		<!-- Recherche les annonces similaires -->
		<p><strong><a href="${pageContext.request.contextPath}/annonces/recherche?subject=${annonce.subject}&location=${annonce.location}">Voir les offres similaires</a></strong></p>
		
	</div>
	<br><br>
	
	<!--  FOOTER INCLUSION  -->
			<div id="copyright" class="container">
				<div class="footer">
					<%@ include file="footer.jsp"%>
				</div>
			</div>
</body>
</html>