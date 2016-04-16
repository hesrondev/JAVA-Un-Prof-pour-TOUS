<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- 

<link href="http://fonts.googleapis.com/css?family=Varela"
	rel="stylesheet" />
<link
	href="<c:url value="/resources/templated-plaindisplay/default.css"/>"
	rel="stylesheet" type="text/css" media="all" />
<link
	href="<c:url value="/resources/templated-plaindisplay/fonts.css" />"
	rel="stylesheet" type="text/css" media="all" />
 -->
 
<title>UPPT | Canditater</title>
</head>
<body>
	<!-- Déclaration des variables -->

	<c:choose>
		<c:when test="${empty user}">

			<c:set var="userFirstName" value=""></c:set>
			<c:set var="userLastName" value=""></c:set>
			<c:set var="userEmail" value=""></c:set>
			<!--<c:set var="userPhoneNumber" value=""></c:set>-->

		</c:when>
		<c:otherwise>

			<c:set var="userFirstName" value="${user.firstName}"></c:set>
			<c:set var="userLastName" value="${user.lastName}"></c:set>
			<c:set var="userEmail" value="${user.email}"></c:set>
			<!--<c:set var="userPhoneNumer" value="${user.phoneNumber}"></c:set>-->

		</c:otherwise>
	</c:choose>


	<!--  HEADER INCLUSION  -->
	<div class="header">
		<%@ include file="header.jsp"%>
	</div>

	<br>
	<!-- Titre de l'annonce -->
	<div>
		<c:if test="${!empty annonce}">
			<h1>${annonce.title}</h1>
		</c:if>
		<p>Votre candidature va être envoyée à l'annonceur. Ce dernier,
			s'il le souhaite, vous contactera après avoir reçu votre candidature.</p>

		<!-- Si pas connecté, on propose l'inscription -->
		<c:if test="${empty user}">
			<p>Pas encore inscrit? Inscrivez-vous</p>
		</c:if>
	</div>

	<!-- Formulaire, Remplissage automatique si connecté -->
	<div>
		<h2>Renseignez vos coordonnées</h2>
		<p>Les champs (*) sont obligatoires</p>

		<br>
		
		<%@ include file="forms/annonceApplicationForm.jsp"%>

	</div>
	
	<br>
	<br>

	<!--  FOOTER INCLUSION  -->
	<div id="copyright" class="container">
			<%@ include file="footer.jsp"%>
	</div>
</body>
</html>