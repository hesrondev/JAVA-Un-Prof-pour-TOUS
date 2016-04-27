<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">


<link href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" />
	
<link href="<c:url value="/resources/custom/css/default.css"/>"
	rel="stylesheet" />

<link href="<c:url value="/resources/custom/css/custom-design.css"/>"
	rel="stylesheet" />

<title>UPPT | Canditater</title>
</head>
<body>
	<!-- Déclaration des variables -->

	<c:choose>
		<c:when test="${empty currentUser}">

			<c:set var="userFirstName" value=""></c:set>
			<c:set var="userLastName" value=""></c:set>
			<c:set var="userEmail" value=""></c:set>
			<c:set var="userPhoneNumber" value=""></c:set>

		</c:when>
		<c:otherwise>

			<c:set var="userFirstName" value="${currentUser.firstName}"></c:set>
			<c:set var="userLastName" value="${currentUser.lastName}"></c:set>
			<c:set var="userEmail" value="${currentUser.email}"></c:set>
			<c:set var="userPhoneNumer" value="${currentUser.phoneNumber}"></c:set>

		</c:otherwise>
	</c:choose>


	<!--  HEADER INCLUSION  -->

	<div>
		<%@ include file="header.jsp"%>
	</div>

	<hr>
	<div class="container">
		<div class="row">

			<div class="col-lg-8">
				<!-- Titre de l'annonce -->
				<h3 class="text-uppercase">Annonce ${annonce.title}</h3>
				<c:out
					value="Votre annonce sera envoyé à l'annonceur. En envoyant votre candidature
						vous acceptez que l'annonceur vous contacte par mail ou par téléphone."></c:out>
			</div>
			<!-- Si pas connecté, on propose l'inscription -->
			<c:if test="${empty currentUser}">
				<div class="col-lg-4">
					<div class="well">
						<h4 align="center">Espace compte</h4>
						<div class="btn-group btn-group-justified btn-sm">
							<a class="btn btn-warning"
								href="${pageContext.request.contextPath}/inscription">Inscrivez-vous!</a>
							<a class="btn btn-default btn-sm"
								href="${pageContext.request.contextPath}/login">Connectez-vous!</a>
						</div>
					</div>
				</div>
			</c:if>
		</div>
		<br>
		<div class="row">
			<div class="col-lg-6">
				<!-- FORMULAIRE -->
				<!-- Formulaire, Remplissage automatique si connecté -->
				<div>
					<div>
						<%@ include file="forms/annonceApplicationForm.jsp"%>
					</div>
				</div>

			</div>
		</div>
	</div>


	<br>
	<br>
	<hr>
	<!--  FOOTER INCLUSION  -->

	<div class="container">
		<footer class="row">
		<div class="col-lg-12">
			<%@ include file="footer.jsp"%>
		</div>
		</footer>
	</div>

</body>
</html>