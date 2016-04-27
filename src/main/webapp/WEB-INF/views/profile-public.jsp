<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" />
	
<link href="<c:url value="/resources/custom/css/default.css"/>"
	rel="stylesheet" />

<link href="<c:url value="/resources/custom/css/custom-design.css"/>"
	rel="stylesheet" />


<title>UPPT | ${!empty user ? user.firstName : Profile}</title>
</head>
<body>

	<!--  HEADER INCLUSION  -->


	<div>
		<%@ include file="header.jsp"%>
	</div>

	<div class="container">
		<div class="row">


			<!-- SECTION GAUCHE INFOS PROFIL-->

			<div class="col-lg-3">

				<!-- LIGNE NOM + photo profil -->

				<div class="row">
					<div class="col-lg-12">

						<a href="#"> <img src="../resources/img/default-picture.jpg"
							class="img-thumbnail"></a>
						<h3>${user.firstName}&nbsp;${user.lastName}</h3>

						<!-- Inclusion du bouton approprié -->
						<div class="">

							<c:set var="item" value="${user}"></c:set>
							<%@ include file="forms/generic-friendAction-button.jsp"%>

						</div>
					</div>
				</div>
				<hr>

				<!-- Infos User -->
				<div class="row">
					<div class="col-lg-12">
						<p>
							<span class="glyphicon glyphicon-education"></span>&nbsp;&nbsp;${user.type}<br>
							<span class="glyphicon glyphicon-briefcase"></span>&nbsp;

							<!-- Champ profession -->
							<c:choose>
								<c:when test="${empty user.profession && empty user.gradeLevel}">
									<c:out value="Non renseigné"></c:out>
								</c:when>
								<c:otherwise>
							${user.profession}
							</c:otherwise>
							</c:choose>
							<!-- Si le niveau est renseigné -->
							<c:if test="${!empty user.gradeLevel}">&nbsp;&bull;&nbsp;${user.gradeLevel}</c:if>

							<br> <span class="glyphicon glyphicon-map-marker"></span>&nbsp;

							<!-- Champ ville pays -->
							<c:choose>
								<c:when test="${empty user.city && empty user.country}">
									<c:out value="Non renseigné"></c:out><br>
								</c:when>
								<c:otherwise>
									${user.city}&nbsp;&bull;&nbsp;${user.country}<br>
								</c:otherwise>
							</c:choose>


							<span class="glyphicon glyphicon-envelope"></span>&nbsp;&nbsp;${user.email}<br>
							
							<!-- Champ télephone -->
							<span class="glyphicon glyphicon-earphone"></span>&nbsp;
							
							<c:choose>
								<c:when test="${empty user.city && empty user.country}">
									<c:out value="Non renseigné"></c:out><br>
								</c:when>
								<c:otherwise>
									${user.phoneNumber}<br>	
								</c:otherwise>
							</c:choose>

							<c:if test="${!empty user.birthDate}">
								<span class="glyphicon glyphicon-star-empty"></span>&nbsp;&nbsp;&nbsp;${user.toStringBirthDate()}
							</c:if>
						</p>
					</div>
				</div>
				<hr>

				<!-- Statistiques -->

				<div class="row" align="center">
					<div class="col-lg-12">
						<div class="row">
							<div class="col-lg-4">
								<h3>
									<a href="#"> ${user.friendsCount()} </a>
								</h3>
								<p>Amis</p>
							</div>

							<div class="col-lg-4">
								<h3>
									<a href="#"> ${user.publicationsCount()} </a>
								</h3>
								<p>Publications</p>
							</div>

							<div class="col-lg-4">
								<h3>
									<a href="#"> ${user.publicationsCount()} </a>
								</h3>
								<p>Annonces</p>
							</div>

						</div>


					</div>
				</div>
			</div>








			<!-- SECTION DROITE -->


			<div class="col-lg-9">
				<!-- LIGNE ENTETE NAV TAB -->
				<div class="row">
					<div class="col-lg-12">
						<div class="container-fluid">

							<ul class="nav nav-tabs">

								<li class="active" role="presentation"><a data-toggle="tab" href="#C"><span
										class="glyphicon glyphicon-bullhorn"></span>&nbsp;&nbsp;Annonces
										<c:out value="&"></c:out> Publications</a></li>

								<li role="presentation"><a data-toggle="tab" href="#D"><span
										class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;Amis</a></li>
							</ul>
						</div>
					</div>
				</div>


				<!-- FIN DE LA NAV TAB -->

				<br>

				<!-- CORPS DE LA NAV TAB -->
				<!-- TAB CONTENTS -->

				<div class="tab-content">

					<!-- Mes annonces -->
					<div id="C" class="tab-pane fade in active">
						<div class="row">
							<div class="col-lg-12">

								<%@ include file="publicAnnonces.jsp"%>
							</div>
						</div>
					</div>


					<!-- Liste d'amis -->

					<div id="D" class="tab-pane fade">

						<div class="row">
							<div class="col-lg-12">

								<%@ include file="public-friend-List.jsp"%>
							</div>
						</div>
					</div>



				</div>
				<!-- FIN DIV TABCONTENT -->

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



	<!-- INCLUSION JS -->

	<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="/resources/js/jquery.js"></script>


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>

	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet"
		href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

	<!-- Optional theme -->
	<link rel="stylesheet"
		href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

	<!-- Latest compiled and minified JavaScript -->
	<script
		src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>


</body>
</html>