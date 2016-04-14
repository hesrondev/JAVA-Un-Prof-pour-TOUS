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

		<form:form modelAttribute="annonceApplicationBean" method="POST"
			action="${pageContext.request.contextPath}/annonces/candidater/${annonce.id}">

			<table>
				<!-- FIRSTNAME -->
				<tr>
					<td><form:label path="firstName">Prénom: *</form:label></td>
				</tr>
				<tr>
					<td> <form:input id="ad_app_firstName" name="firstName" path="firstName"
							value="${userFirstName}" /></td>
				</tr>
				
				<!-- LASTNAME -->
				<tr>
					<td><form:label path="lastName">Nom: *</form:label></td>
				</tr>
				<tr>
					<td> <form:input id="ad_app_lastName" name="lastName" path="lastName"
							value="${userLastName}" /></td>
				</tr>
				
				<!-- EMAIL -->
				<tr>
					<td><form:label path="email">Email: *</form:label></td>
				</tr>
				<tr>
					<td> <form:input id="ad_app_email" name="email" path="email"
							value="${userEmail}" /></td>
				</tr>
				
				<!-- PHONE 
				<tr>
					<td><form:label path="phoneNumber">Téléphone:</form:label></td>
				</tr>
				<tr>
					<td> <form:input id="ad_app_phone" name="phoneNumber" path="phoneNumber"
							value="${userPhoneNumber}" /></td>
				</tr>-->
				
				<!-- MESSAGE -->
				<tr>
					<td><form:label path="message">Message facultatif:</form:label></td>
				</tr>
				<tr>
					<td> <form:textarea id="ad_app_message" name="message" path="message"/></td>
				</tr>
				
				<tr>
					<td><input type="submit" class="button" value="Candidater" /></td>
				</tr>
			</table>

		</form:form>
		<br>

	</div>

	<br>
	<br>

	<!--  FOOTER INCLUSION  -->
	<div id="copyright" class="container">
		<div class="footer">
			<%@ include file="footer.jsp"%>
		</div>
	</div>
</body>
</html>