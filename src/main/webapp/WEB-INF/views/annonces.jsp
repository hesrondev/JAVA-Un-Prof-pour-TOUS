<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" />
	
<link href="<c:url value="/resources/bootstrap/css/bootstrap-theme.min.css"/>"
	rel="stylesheet" />	

<!-- INCLURE UN CSS PERSO ICI -->

<title>UPPT | Students Page</title>
</head>
<body>

	<!--  HEADER INCLUSION  -->


	<div class="container">
		<header class="row">
		<div class="col-lg-12">
			<%@ include file="header.jsp"%>
		</div>
		</header>
	</div>
	<hr>

	<div class="container">
		<div class="row">
			<div class="col-lg-offset-1 col-lg-10">
				<c:choose>

					<c:when test="${!empty listAnnonces}">
						<h2>
							<strong>${fn:length(listAnnonces)}</strong>

							<c:choose>
								<c:when test="${fn:length(listAnnonces) > 1}">
									<c:out value="Annonces sur le site"></c:out>
								</c:when>
								<c:otherwise>
									<c:out value="Annonce sur le site"></c:out>
								</c:otherwise>

							</c:choose>
							<c:if test="${!empty subject}">: ${subject}</c:if>
							<c:if test="${!empty location }"> à ${location}</c:if>
						</h2>
					</c:when>
					<c:otherwise>
						<h2>Aucune annonce ne correspond à critères de recherche</h2>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>


	<!-- Formulaire de recherche  -->
	<div class="jumbotron">
		<div class="container">
			<div class="row">
				<div class="col-lg-offset-1 col-lg-7">
					<%@ include file="forms/adSearchForm-small.jsp"%>
				</div>
			</div>
		</div>
	</div>

	<!-- RESULTATS DE LA RECHERCHE -->

	<div class="container">
		<div class="row">
			<div class="col-lg-12">


				<!-- PREMIERE LIGNE -->
				<div class="row">
					<div class="col-lg-offset-1 col-lg-2">
						<h5>
							<strong>Filtres:</strong>
						</h5>
					</div>
				</div>


				<!--  -->
				<div class="row">

					<!-- ELEMENTS DU FILTRE -->
					<div class="col-lg-offset-1 col-lg-2">

						<!-- Par Statut du postant -->

						<c:if test="${!empty statusFilters}">
							<div class="row">
								<div class="col-lg-12">

									<table>
										<tr>
											<th>- Statut</th>
										</tr>

										<c:forEach items="${statusFilters}" var="item">
											<tr>
												<td><a
													href="${pageContext.request.contextPath}/annonces/status=${item.value}">${item.value}
														&nbsp;&nbsp;&nbsp;<span class="badge">${item.counter}</span>
												</a></td>
											</tr>
										</c:forEach>

									</table>
								</div>
							</div>
						</c:if>


						<!-- Par niveau scolaire -->
						<br>
						<c:if test="${!empty levelFilters}">
							<div class="row">
								<div class="col-lg-12">

									<table>
										<tr>
											<th>- Niveau scolaire</th>
										</tr>

										<c:forEach items="${levelFilters}" var="item">
											<tr>
												<td><a
													href="${pageContext.request.contextPath}/annonces/status=${item.value}">${item.value}
														&nbsp;&nbsp;&nbsp;<span class="badge">${item.counter}</span>
												</a></td>
											</tr>
										</c:forEach>

									</table>
								</div>
							</div>
						</c:if>

						<!-- Par matière scolaire -->
						<br>
						<c:if test="${!empty subjectFilters}">
							<div class="row">
								<div class="col-lg-12">

									<table>
										<tr>
											<th>- Matières</th>
										</tr>

										<c:forEach items="${subjectFilters}" var="item">
											<tr>
												<td><a
													href="${pageContext.request.contextPath}/annonces/status=${item.value}">${item.value}
														&nbsp;&nbsp;&nbsp;<span class="badge">${item.counter}</span>
												</a></td>
											</tr>
										</c:forEach>

									</table>
								</div>
							</div>
						</c:if>


						<!-- Par Emplacement -->
						<br>
						<c:if test="${!empty locationFilters}">
							<div class="row">
								<div class="col-lg-12">

									<table>
										<tr>
											<th>- Lieux</th>
										</tr>

										<c:forEach items="${locationFilters}" var="item">
											<tr>
												<td><a
													href="${pageContext.request.contextPath}/annonces/status=${item.value}">${item.value}
														&nbsp;&nbsp;&nbsp;<span class="badge">${item.counter}</span>
												</a></td>
											</tr>
										</c:forEach>

									</table>
								</div>
							</div>
						</c:if>
					</div>


					<!--  Tableau d'annonces  -->



					<c:if test="${!empty listAnnonces}">
						<div class="col-lg-8">
							<c:forEach items="${listAnnonces}" var="item">
								<div class="row">
									<div class="col-lg-12">



										<!-- TITRE -->
										<div class="row">
											<div class="col-lg-12">
												<h2>
													<a
														href="${pageContext.request.contextPath}/annonces/${item.id}">${item.title}</a>
												</h2>
											</div>
										</div>

										<!-- 2EME LIGNE DESCRIPTION ET DETAILS -->
										<div class="row">

											<!-- Colonne description -->
											<div class="col-lg-6">
												<p>${item.description}</p>
											</div>
											<!-- Colonne détails -->
											<div class="col-lg-4">
												<p>
													Lieu: ${item.location}<br>Matière(s): ${item.subject}<br>
													Tarif: ${item.costPerHour} €/h<br>Publiée le
													${item.toStringDate()}
												</p>
											</div>
											<div class="col-lg-2">
												<a
													href="${pageContext.request.contextPath}/profile/${item.user.id}"><strong>${item.user.firstName}
														${item.user.lastName}</strong></a>
											</div>
										</div>



									</div>

								</div>
								<hr>
							</c:forEach>

							<!-- PAGINATION -->
							<div class="row">
								<div class="col-lg-12">
									<ul class="pagination">
										<li><a href="#">&laquo;</a></li>
										<li><a href="#">1</a></li>
										<li><a href="#">2</a></li>
										<li><a href="#">3</a></li>
										<li><a href="#">&raquo;</a></li>
									</ul>
								</div>
							</div>

						</div>

					</c:if>

				</div>
			</div>

		</div>

		<!-- PUBLIER UNE ANNONCE -->
		<div class="row">
			<div class="col-lg-offset-3 col-lg-8 well">
				<h3>Publiez votre annonce dès maintenant!</h3>
				<p>Cliquez sur le bouton et soyez visibles auprès des visiteurs</p>
				<div>
					<a href="${pageContext.request.contextPath}/annonces/create.html"
						class="btn btn-warning btn-lg">Publier une annonce</a>
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