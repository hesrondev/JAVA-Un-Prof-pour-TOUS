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


<title>UPPT | ${!empty currentUser ? currentUser.firstName : Profile}</title>
</head>
<body>

	<!--  HEADER INCLUSION  -->



	<header class="">
	<div class="">
		<%@ include file="../header.jsp"%>
	</div>
	</header>
	<br>

	<div class="container">
		<div class="row">


			<!-- SECTION GAUCHE INFOS PROFIL-->

			<div class="col-lg-3">

				<!-- LIGNE NOM + photo profil -->

				<div class="row">
					<div class="col-lg-12">

						<a href="#"> <img src="resources/img/default-picture.jpg"
							class="img-thumbnail"></a>
						<h3>${currentUser.firstName}&nbsp;${currentUser.lastName}</h3>

						<!-- Inclusion du bouton approprié -->
						<div class="">

							<c:set var="item" value="${currentUser}"></c:set>
							<%@ include file="../forms/generic-friendAction-button.jsp"%>

						</div>
					</div>
				</div>
				<hr>

				<!-- Infos User -->
				<div class="row">
					<div class="col-lg-12">
						<p>
							<span class="glyphicon glyphicon-education"></span>&nbsp;&nbsp;${currentUser.type}<br>
							<span class="glyphicon glyphicon-briefcase"></span>&nbsp;

							<!-- Champ profession -->
							<c:choose>
								<c:when
									test="${empty currentUser.profession && empty currentUser.gradeLevel}">
									<c:out value="Non renseigné"></c:out>
								</c:when>
								<c:otherwise>
							${currentUser.profession}
							</c:otherwise>
							</c:choose>
							<!-- Si le niveau est renseigné -->
							<c:if test="${!empty currentUser.gradeLevel}">&nbsp;&bull;&nbsp;${currentUser.gradeLevel}</c:if>

							<br> <span class="glyphicon glyphicon-map-marker"></span>&nbsp;

							<!-- Champ ville pays -->
							<c:choose>
								<c:when
									test="${empty currentUser.city && empty currentUser.country}">
									<c:out value="Non renseigné"></c:out>
									<br>
								</c:when>
								<c:otherwise>
									${currentUser.city}&nbsp;&bull;&nbsp;${currentUser.country}<br>
								</c:otherwise>
							</c:choose>


							<span class="glyphicon glyphicon-envelope"></span>&nbsp;&nbsp;${currentUser.email}<br>

							<!-- Champ télephone -->
							<span class="glyphicon glyphicon-earphone"></span>&nbsp;

							<c:choose>
								<c:when
									test="${empty currentUser.city && empty currentUser.country}">
									<c:out value="Non renseigné"></c:out>
									<br>
								</c:when>
								<c:otherwise>
									${currentUser.phoneNumber}<br>
								</c:otherwise>
							</c:choose>

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
								<p>Amis</p>
							</div>

							<div class="col-lg-4">
								<h3>
									<a href="#"> ${currentUser.publicationsCount()} </a>
								</h3>
								<p>Publications</p>
							</div>

							<div class="col-lg-4">
								<h3>
									<a href="#"> ${currentUser.notificationsCount()} </a>
								</h3>
								<p>Notifications</p>
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


			<div class="col-lg-9">


				<!-- LIGNE ENTETE NAV TAB -->
				<div class="row">
					<div class="col-lg-12">
						<div class="container-fluid">

							<ul class="nav nav-tabs">
								<li role="presentation" class="active"><a data-toggle="tab"
									href="#A"><span class="glyphicon glyphicon-calendar"></span>&nbsp;&nbsp;Mon
										planning</a></li>

								<li role="presentation"><a data-toggle="tab" href="#B"><span
										class="glyphicon glyphicon-education"></span>&nbsp;&nbsp;<c:choose>
											<c:when test="${currentUser.isStudent()}">
												<c:out value="Mes professeurs"></c:out>
											</c:when>
											<c:otherwise>
												<c:out value="Mes élèves"></c:out>
											</c:otherwise>
										</c:choose></a></li>

								<li role="presentation"><a data-toggle="tab" href="#C"><span
										class="glyphicon glyphicon-bullhorn"></span>&nbsp;&nbsp;Annonces
										<c:out value="&"></c:out> Publications</a></li>

								<li role="presentation"><a data-toggle="tab" href="#D"><span
										class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;Mes amis</a></li>
							</ul>
						</div>
					</div>
				</div>


				<!-- FIN DE LA NAV TAB -->

				<br>

				<!-- CORPS DE LA NAV TAB -->
				<!-- TAB CONTENTS -->

				<div class="tab-content">

					<!-- Mon emploi du temps -->
					<!-- Afficher si professeur -->

					<!-- Mes profs / Eleves -->

					<c:choose>
						<c:when test="${currentUser.isStudent()}">
							<div id="B" class="tab-pane fade in active">
								<div class="row">
									<div class="col-lg-12">

										<%@ include file="myProfessors-Board.jsp"%>
									</div>

								</div>
							</div>
						</c:when>
						<c:otherwise>

							<div id="A" class="tab-pane fade in active">
								<div class="row">
									<div class="col-lg-12">

										<%@ include file="myTimeTable.jsp"%>

									</div>
								</div>
							</div>

							<div id="B" class="tab-pane fade">
								<div class="row">
									<div class="col-lg-12">

										<%@ include file="myStudents-Board.jsp"%>
									</div>

								</div>
							</div>
						</c:otherwise>

					</c:choose>


					<!-- Mes annonces -->
					<div id="C" class="tab-pane fade">
						<div class="row">
							<div class="col-lg-12">

								<%@ include file="myAnnonces.jsp"%>
							</div>
						</div>
					</div>


					<!-- Ma liste d'amis / Requetes Envoyées + Reçues -->

					<div id="D" class="tab-pane fade">

						<div class="row">
							<div class="col-lg-12">

								<%@ include file="myFriends-List.jsp"%>
							</div>

						</div>

						<!-- Mes demandes en ami received/sent -->

						<div class="row">
							<div class="col-lg-6">
								<%@ include file="receivedRequests-List.jsp"%>
							</div>

							<div class="col-lg-6">
								<%@ include file="sentRequests-List.jsp"%>
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
			<%@ include file="../footer.jsp"%>
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