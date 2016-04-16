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
			<p>Soyez visibles auprès de nos visiteurs</p>
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
		<h2>Consulter plus de *** profils de professeurs et élèves</h2>
		<a href="#">Voirs plus</a>

	</div>


	<br>
	<hr>

	<!--  Dernières annonces -->

	<div>
		<h2>Dernières annonces</h2>
		<p></p>
	</div>

	<br>
	<hr>

	<!-- Recherches populaires -->

	<div>
		<h2>Recherches populaires</h2>

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