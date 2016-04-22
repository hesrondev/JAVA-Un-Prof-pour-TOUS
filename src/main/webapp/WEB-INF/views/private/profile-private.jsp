<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" />
<!-- INCLURE UN CSS PERSO ICI -->



<title>UPPT | ${!empty currentUser ? currentUser.firstName : Profile}</title>
</head>
<body>

	<!--  HEADER INCLUSION  -->


	<div class="container">
		<header class="row">
		<div class="col-lg-12">
			<%@ include file="../header.jsp"%>
		</div>
		</header>
	</div>
	<hr>


	<div class="container">
		<div class="row">


			<!-- SECTION GAUCHE INFOS PROFIL-->

			<div class="col-lg-offset-1 col-lg-3">

				<!-- LIGNE NOM + photo profil -->

				<div class="row">
					<div class="col-lg-12">

						<a href="#"> <img src="resources/img/default-picture.jpg"
							class="img-thumbnail"></a>
						<h3>${currentUser.firstName}&nbsp;${currentUser.lastName}</h3>
					</div>
				</div>
				<hr>

				<!-- Infos User -->
				<div class="row">
					<div class="col-lg-12">
						<p>
							<span class="glyphicon glyphicon-education"></span>&nbsp;&nbsp;${currentUser.type}<br>
							<span class="glyphicon glyphicon-briefcase"></span>&nbsp;&nbsp;${currentUser.profession}
							<c:if test="${!empty currentUser.gradeLevel}">
						- ${currentUser.gradeLevel}</c:if>
							<br> <span class="glyphicon glyphicon-map-marker"></span>&nbsp;&nbsp;${currentUser.city}
							- ${currentUser.country}<br> <span
								class="glyphicon glyphicon-envelope"></span>&nbsp;&nbsp;${currentUser.email}<br>
							<span class="glyphicon glyphicon-earphone"></span>&nbsp;&nbsp;${currentUser.phoneNumber}<br>

							<c:if test="${!empty currentUser.birthDate}">
								<span class="glyphicon glyphicon-star-empty"></span>&nbsp;&nbsp;&nbsp;${currentUser.toStringBirthDate()}
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
									<a href="#"> ${currentUser.friendsCount()} </a>
								</h3>
								<p>amis</p>
							</div>

							<div class="col-lg-4">
								<h3>
									<a href="#"> ${currentUser.publicationsCount()} </a>
								</h3>
								<p>publications</p>
							</div>

							<div class="col-lg-4">
								<h3>
									<a href="#"> ${currentUser.notificationsCount()} </a>
								</h3>
								<p>notifications</p>
							</div>

						</div>


					</div>
				</div>

				<hr>
				<!-- REQUETES RECUES -->

				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">

							<div class="list-group">
								<a href="#" class="list-group-item list-group-item-warning">Demandes
									reçues&nbsp;&nbsp;&nbsp;<span class="badge">${currentUser.receivedFriendRequestsCount()}</span>
								</a> <a href="#" class="list-group-item list-group-item-info">Demandes
									envoyées&nbsp;&nbsp;&nbsp;<span class="badge">${currentUser.sentFriendRequestsCount()}</span>
								</a> <a href="#" class="list-group-item list-group-item-danger">Candidatures
									d'annonces&nbsp;&nbsp;&nbsp;<span class="badge">${currentUser.allAnnonceApplicationsCount()}</span>
								</a>

							</div>
						</div>


					</div>
				</div>

				<hr>

				<div class="row">
					<div class="col-lg-12">

						<p>
							<a class="btn btn-sm btn-default"
								href="${pageContext.request.contextPath}/profile/edit"> <span
								class="glyphicon glyphicon-pencil"></span>&nbsp;&nbsp;Editer
								profil
							</a>
						</p>
					</div>
				</div>

			</div>








			<!-- SECTION DROITE -->


			<div class="col-lg-8">


				<!-- LIGNE ENTETE NAV TAB -->
				<div class="row">
					<div class="col-lg-12">
						<div class="container-fluid">

							<ul class="nav nav-tabs">
								<li role="presentation" class="active"><a href="#"><span
										class="glyphicon glyphicon-calendar"></span>&nbsp;Mon planning</a></li>
								<li role="presentation"><a href="#"><span
										class="glyphicon glyphicon-education"></span>&nbsp; <c:choose>
											<c:when test="${currentUser.isStudent()}">
												<c:out value="Mes professeurs"></c:out>
											</c:when>
											<c:otherwise>
												<c:out value="Mes élèves"></c:out>
											</c:otherwise>
										</c:choose></a></li>

								<li role="presentation"><a href="#"><span
										class="glyphicon glyphicon-bullhorn"></span>&nbsp;Annonces <c:out
											value="&"></c:out> Publications</a></li>

								<li role="presentation"><a href="#"><span
										class="glyphicon glyphicon-user"></span>&nbsp;Mes amis</li>

								<li>
									<!-- Ajouter -->
									<form class="navbar-form navbar-right">
										<button type="submit" class="btn btn-xs btn-default">
											<span class="glyphicon glyphicon-plus"></span>&nbsp;Ajouter
											contact
										</button>
									</form>
								</li>

							</ul>
						</div>
					</div>
				</div>
				<!-- FIN DE LA NAV TAB -->

				<br>

				<!-- CORPS DE LA NAV TAB -->
				<!-- Afficher ce contenu de manière dynamique
					voir la possibilité avec JS -->
				
				<div class="row">
					<div class="col-lg-12">
						<%@ include file="myProfessors-Board.jsp" %>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<%@ include file="myStudents-Board.jsp" %>
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
			<%@ include file="../footer.jsp"%>
		</div>
		</footer>
	</div>

</body>
</html>