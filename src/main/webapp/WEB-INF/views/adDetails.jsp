<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" />

<link href="<c:url value="/resources/custom/css/default.css"/>"
	rel="stylesheet" />
	


<title>UPPT | <c:if test="${!empty annonce}">${annonce.title}</c:if></title>

</head>

<body>


	<!--  HEADER INCLUSION  -->


	<div>
		<%@ include file="header.jsp"%>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<c:if test="${!empty annonce}">

					<!-- En tête de l'annonce -->

					<section class="panel panel-default">
					<div class="panel-body">
						<div class="row">


							<div class="col-lg-8">
								<h2>${annonce.title}</h2>
								<p>
									<span class="glyphicon glyphicon-user"></span> <a
										href="${pageContext.request.contextPath}/profile/${item.user.id}">
										${annonce.user.lastName} ${annonce.user.firstName}</a>&nbsp;&nbsp;&nbsp;<span
										class="glyphicon glyphicon-marker"></span>
									${annonce.location}&nbsp;&nbsp;&nbsp;<span
										class="glyphicon glyphicon-time"></span>
									${annonce.toStringDate()}
								</p>

								<!-- Labels -->
								<p>
									<a class="btn btn-xs btn-default"
										href="${pageContext.request.contextPath}/annonces/recherche?subject=${annonce.subject}&location=">
										<span class="glyphicon glyphicon-tags"></span>
										&nbsp;${annonce.subject}

									</a> &nbsp;&nbsp; <a class="btn btn-xs btn-default"
										href="${pageContext.request.contextPath}/annonces/recherche?subject=&location=${annonce.location}">
										<span class="glyphicon glyphicon-tags"></span>
										&nbsp;${annonce.location}
									</a>&nbsp;&nbsp;


									<!-- Si le pays de l'utilisateur n'est pas vide -->

									<c:if test="!empty ${annonce.user.country}">

										<a class="btn btn-xs btn-pill btn-default"
											href="${pageContext.request.contextPath}/annonces/recherche?subject=&location=${annonce.location}">

											<span class="glyphicon glyphicon-tags"></span>&nbsp;${annonce.user.country}


										</a>
									</c:if>
								</p>
								<br>
								<p>
									<a class="btn btn-lg btn-warning"
										href="${pageContext.request.contextPath}/annonces/candidater/${annonce.id}">Candidater
										maintenant !</a>
								</p>
							</div>


							<!-- CANDIDATURES -->

							<div class="col-lg-offset-1 col-lg-3" align="center">
								<c:set var="listSize" value="${fn:length(annonce.applications)}"></c:set>

								<div class="">

									<c:choose>
										<c:when test="${listSize == 0}">
											<h4>
												<c:out value="${listSize}" />
												Candidature
											</h4>
											<p>Soyez le premier à candidater!</p>
										</c:when>
										<c:when test="${listSize == 1}">
											<h4>
												<c:out value="${listSize}" />
												Candidature
											</h4>
											<p>Comparez vous aux autres candidats</p>
										</c:when>

										<c:otherwise>
											<h4>
												<c:out value="${listSize}" />
												Candidatures
											</h4>
											<p>Comparez vous aux autres candidats</p>
										</c:otherwise>
									</c:choose>

									<!-- Si pas connecté -->

									<c:if test="${empty currentUser}">

										<p>Accédez au profil des autres candidats.</p>
										<p>
											<a class="btn btn-info btn-sm"
												href="${pageContext.request.contextPath}/inscription">Je
												veux créer un compte</a>
										</p>

										<p>
											<a href="${pageContext.request.contextPath}/login"><strong>J'ai
													déjà un compte</strong></a>
										</p>
									</c:if>
								</div>
							</div>


						</div>
					</div>
					</section>


					<!--  Suite des détails de l'annonce -->

					<section class="panel panel-default">
					<div class="panel-body">
						<div class="row">

							<div class="col-lg-9">

								<div class="row">
									<div class="col-lg-12">
										<div class="page-header">
											<h4>Informations sur l'annonce</h4>
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-lg-8">
										<table class="table table-condensed">
											<tr>
												<td>Matière</td>
												<td>Rémunération de base</td>
												<td>Niveau</td>
											</tr>
											<tr>
												<td><strong>${annonce.subject}</strong></td>
												<td><strong>${annonce.costPerHour}&nbsp;€/h</strong></td>
												<td><strong>${annonce.level}</strong></td>
											</tr>
										</table>
									</div>
								</div>

								<div class="row">
									<div class="col-lg-12">

										<!-- DESCRIPTION -->
										<div class="page-header">
											<h4>Description</h4>
										</div>

										<p>${annonce.description}</p>
										<br>

										<!-- Si contact disponible -->
										<c:if test="${annonce.showPhoneNumber}">
											<div class="page-header">
												<h4>Contact</h4>
											</div>
											<p>
												<span class="glyphicon glyphicon-envelope"></span>&nbsp;&nbsp;${currentUser.email}<br>
												<span class="glyphicon glyphicon-earphone"></span>&nbsp;&nbsp;${annonce.user.phoneNumber}
											</p>
										</c:if>

										<p>
											<a class="btn btn-warning"
												href="${pageContext.request.contextPath}/annonces/candidater/${annonce.id}">Candidater
												maintenant !</a>
										</p>


									</div>



								</div>



							</div>

							<!-- PLUS D'OFFRES //// PANEL GAUChe -->

							<div class="col-lg-3">

								<div class="panel panel-default">
									<div class="panel-heading">
										<h3 class="panel-title">Offres similaires</h3>
									</div>
									<table class="table table-striped table-condensed">

										<tbody>

											<c:forEach items="${annonces}" var="item">
												<tr>
													<td>
														<p>
															<a
																href="${pageContext.request.contextPath}/annonces/${item.id}">${item.title}</a>
															<br> <span class="glyphicon glyphicon-map-marker"></span>
															${item.location}&nbsp;&nbsp;&nbsp;<span
																class="glyphicon glyphicon-time"></span>
															${annonce.toStringDate()}
														</p>
													</td>
												</tr>
											</c:forEach>

										</tbody>
									</table>


									<!-- Recherche les annonces similaires -->
									<div class="panel-footer" align="center">

										<a class="btn btn-default"
											href="${pageContext.request.contextPath}/annonces/recherche?subject=${annonce.subject}&location=${annonce.location}">Voir
											les offres similaires</a>
									</div>
								</div>

							</div>


						</div>
					</div>
					</section>
				</c:if>
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
</body>
</html>