<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!--
<link href="<c:url value="/resources/templated-transit/css/style.css" />"
	rel="stylesheet" type="text/css"> -->

<title>UPPT | Accueil</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Varela"
	rel="stylesheet" />
<link
	href="<c:url value="/resources/templated-plaindisplay/default.css"/>"
	rel="stylesheet" type="text/css" media="all" />
<link
	href="<c:url value="/resources/templated-plaindisplay/fonts.css" />"
	rel="stylesheet" type="text/css" media="all" />

</head>
<body>
	<div id="bloc_page">

		<!--  HEADER INCLUSION  -->

		
			<%@ include file="header.jsp"%>
		
		<!-- banni�re -->
		<div id="banner">
			<div class="container">
				<div class="title">
					<h2>Banni�re UPPT</h2>
				</div>
			</div>
		</div>
		<!-- Menu -->
		<div id="extra" class="container">
			<div class="title">
				<h2>Bienvenue sur Un Prof Pour Tous</h2>
				<span class="byline">O� voulez-vous vous rendre?</span>
			</div>
			<div id="three-column">
				<div class="boxA">
					<div class="box">
						<span class="fa fa-cloud-download"></span>
						<p>
							<a href="${pageContext.request.contextPath}/annonces.html">Nos annonces</a>
						</p>
					</div>
				</div>
				<div class="boxB">
					<div class="box">
						<span class="fa fa-user"></span>
						<p>
							<a href="${pageContext.request.contextPath}/professors.html">Nos professeurs</a>
						</p>
					</div>
				</div>
				<div class="boxC">
					<div class="box">
						<span class="fa fa-user"></span>
						<p>
							<a href="${pageContext.request.contextPath}/students.html">Nos el�ves</a>
						</p>
					</div>
				</div>
				<div class="boxD">
					<div class="box">
						<span class="fa fa-cogs"></span>
						<p>
							<a href="${pageContext.request.contextPath}/guide.html">Le guide UPPT</a>
						</p>
					</div>
				</div>
			</div>
			<!--  <ul class="actions">
			<li><a href="#" class="button">Etiam posuere</a></li>
		</ul> -->
		</div>

		<!-- Recherche d'annonce -->
		<div id="featured" >
			<div class="container">
				<div class="title">
					<h2>Annonces</h2>
				</div>
				<%@ include file="adSearchForm.jsp"%>
				<a href="#">Recherche avanc�e</a>
				<br><br>
				
				<div align="center">
					<a href="${pageContext.request.contextPath}/annonces/create.html"><strong>Publier
							une annonce</strong></a>
				</div>
				
			</div>
		</div>
		

		<!--  Derni�res annonces -->
		<div id="page" class="container">
			<div class="title">
				<h2>Derni�res annonces</h2>
				<p>
					<strong>> Les derni�res annonces d'�l�ves sur le site</strong> <a
						href="#">+ voir plus...</a> <br> <strong>> Les
						derni�res annonces de professeurs sur le site</strong> <a href="#">+
						voir plus...</a>
				</p>
			</div>


			<!--  FOOTER INCLUSION  -->
			<div id="copyright" class="container">
				<div class="footer">
					<%@ include file="footer.jsp"%>
				</div>
			</div>

		</div>
	</div>
</body>
</html>