<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" />

<link href="<c:url value="/resources/custom/css/custom-design.css"/>"
	rel="stylesheet" />
	
<link href="<c:url value="/resources/custom/css/flaty.css"/>"
	rel="stylesheet" />
	
	
<!-- INCLURE UN CSS PERSO ICI -->

<title>UPPT | Accueil</title>


</head>
<body>

	<!--  HEADER INCLUSION  -->

	<%@ include file="header.jsp"%>

	<!-- Formulaire Recherche d'annonce -->

	<div class="jumbotron">
		<div class="container">
			<div class="row">
				<div class="col-lg-offset-4 col-lg-6">
					<h3>Trouver votre prochain cours</h3>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-offset-1 col-lg-10">
					<%@ include file="forms/adSearchForm.jsp"%>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-offset-5 col-lg-4">
					<a href="#">Recherche avancée</a>
				</div>
			</div>
		</div>
	</div>


	<div class="jumbotron">
		<div class="container">

			<h3>Déposer votre annonce</h3>
			<p>
				<c:out value="Soyez visible auprès des visiteurs"></c:out>
			</p>
			<p>
				<a class="btn btn-info"
					href="${pageContext.request.contextPath}/annonces/create.html"><span
					class="glyphicon glyphicon glyphicon-hand-right"></span> Publier
					une annonce</a>
			</p>
		</div>

	</div>

	<!-- Nos professeurs & elèves -->

	<div class="jumbotron">
		<div class="container">
			<section class="row">
			<div class="col-lg-12">

				<div class="row">
					<div class="col-lg-8">
						<h3>Consulter plus de ${usersCount} profils de professeurs et
							élèves</h3>
					</div>
				</div>
				<br>
				<div class="row">

					<c:forEach items="${latestUsers}" var="item">
						<div class="col-lg-2">
							<div align="center">
								<img class="img-thumbnail" alt=""
									src="resources/img/default-picture-s64.png"><br> <a
									href="${pageContext.request.contextPath}/profile/${item.firstName}.${item.lastName}/${item.id}">${item.firstName}
									${item.lastName}</a> <br> ${item.type}<br>
									Membre depuis ${item.duration()}
							</div>
						</div>
					</c:forEach>
				</div>

				<br>

				<div class="row">
					<div class="col-lg-2">
						<a href="${pageContext.request.contextPath}/professors">Voir
							plus de professeurs</a>
					</div>

					<div class="col-lg-2">
						<a href="${pageContext.request.contextPath}/students">Voir
							plus d'élèves</a>
					</div>
				</div>
			</div>
			</section>
		</div>
	</div>



	<!--  Dernières annonces -->

	<div class="jumbotron">
		<div class="container">
			<section class="row">
			<div class="col-lg-12">
				<div class="row">
					<div class="col-lg-6">
						<h3>Dernières annonces</h3>
					</div>
				</div>
				<div class="row">
					<c:forEach items="${latestAnnonces}" var="item">
						<div class="col-lg-2">
							<!-- Table inside a column -->
							<table>
								<tr>
									<td><a
										href="${pageContext.request.contextPath}/annonces/${item.id}">${item.title}</a></td>
								</tr>
								<tr>
									<td>${item.location}&#8226${item.toStringDate()}</td>
								</tr>
							</table>
						</div>
					</c:forEach>
				</div>
				<div class="row">
					<div class="col-lg-4">
						<br> <a href="${pageContext.request.contextPath}/annonces">Voir
							plus d'annonces</a>
					</div>
				</div>
				<br>
				<hr>
			</div>
			</section>
		</div>
	</div>



	<!-- Recherches populaires -->

	<div class="jumbotron">
		<div class="container">
			<section class="row">
			<div class="col-lg-12">
				<div class="row">
					<div class="col-lg-6">
						<h3>Recherches populaires</h3>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<div class="row">
							<div class="col-lg-4">
								<h4>Matières</h4>
							</div>
							<div class="col-lg-4">
								<h4>Lieux</h4>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-4">
								<div class="row">
									<div class="col-lg-1">
										<c:forEach items="${subjectFilters}" var="item"
											varStatus="loop">
											<a class="label label-info"
												href="${pageContext.request.contextPath}/annonces/recherche?subject=${item.value}&location=">${item.value}
												<c:if test="${loop.index < fn:length(subjectFilters) - 1}"> &#8226 </c:if>
											</a>
										</c:forEach>
									</div>
								</div>
							</div>
							<div class="col-lg-4">
								<div class="row">
									<div class="col-lg-1">
										<c:forEach items="${locationFilters}" var="item">
											<a class="label label-info"
												href="${pageContext.request.contextPath}/annonces/recherche?subject=&location=${item.value}">${item.value}
												<c:if test="${loop.index < fn:length(subjectFilters) - 1}"> &#8226 </c:if>
											</a>
										</c:forEach>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			</section>
		</div>
	</div>

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