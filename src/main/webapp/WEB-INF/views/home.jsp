<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>UPPT | Accueil</title>

<meta name="keywords" content="" />
<meta name="description" content="" />

</head>
<body>

	<!--  HEADER INCLUSION  -->

	<div>
		<%@ include file="header.jsp"%>
	</div>

	<!-- Formulaire Recherche d'annonce -->

	<div>
		<h2>Trouver votre prochain cours</h2>
		
		<%@ include file="forms/adSearchForm.jsp"%>
		<a href="#">Recherche avancée</a>

	</div>

	<br>
	<hr>


	<!-- Déposer une annonce -->

	<div>
		<div>
			<h2>Déposer votre annonce</h2>
			<p>Soyez visible auprès des visiteurs</p>
		</div>
		<div>
			<a href="${pageContext.request.contextPath}/annonces/create.html"><strong>Publier
					une annonce</strong></a>
		</div>
	</div>
	<br>
	<hr>

	<!-- Nos professeurs & elèves -->

	<div>
		<h2>Consulter plus de ${usersCount} profils de professeurs et élèves</h2> 
		
		<table>
			<c:forEach items="${latestUsers}" var="item">
				<tr>
					<td><a href="${pageContext.request.contextPath}/profile/${item.firstName}.${item.lastName}/${item.id}">${item.firstName} ${item.lastName}</a> <br> ${item.type}</td>
				</tr>
			</c:forEach>
		</table>
		<p>
			<a href="${pageContext.request.contextPath}/professors">Voir plus de professeurs</a><br>
			<a href="${pageContext.request.contextPath}/students">Voir plus d'élèves</a>
		</p>

	</div>


	<br>
	<hr>

	<!--  Dernières annonces -->

	<div>
		<h2>Dernières annonces</h2>
		
		<table>
			<c:forEach items="${latestAnnonces}" var="item">
				<tr>
					<td>
						<!-- Table inside a column -->
						<table>
							<tr>
								<td><a href="${pageContext.request.contextPath}/annonces/${item.id}"></a>${item.title}</td>
							</tr>
							<tr>
								<td>${item.location} &#8226 ${item.toStringDate()}</td>
							</tr>
						</table>
					</td>
				</tr>
			</c:forEach>
		</table>
		
		<p><a href="${pageContext.request.contextPath}/annonces">Voir plus d'annonces</a></p>
	</div>

	<br>
	<hr>

	<!-- Recherches populaires -->

	<div>
		<h2>Recherches populaires</h2>
		
		<table>
			<tr>
				<th>Matières</th>
				<th>Lieux</th>
			</tr>
			<tr>
				<td>
					<c:forEach items="${subjectFilters}" var="item" varStatus="loop">
						<a href="${pageContext.request.contextPath}/annonces/recherche?subject=${item.value}&location=">${item.value}
						<c:if test="${loop.index < fn:length(subjectFilters) - 1}"> &#8226 </c:if></a>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${locationFilters}" var="item">
						<a href="${pageContext.request.contextPath}/annonces/recherche?subject=&location=${item.value}">${item.value} 
						<c:if test="${loop.index < fn:length(subjectFilters) - 1}"> &#8226 </c:if></a>
					</c:forEach>
				</td>
			</tr>
		
		</table>
	</div>

	<br>
	<hr>
	<br>

	<!--  FOOTER INCLUSION  -->

	<div>
		<%@ include file="footer.jsp"%>
	</div>

</body>
</html>