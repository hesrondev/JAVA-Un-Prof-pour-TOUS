<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<link href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" />
	
<link href="<c:url value="/resources/custom/css/default.css"/>"
	rel="stylesheet" />

<link href="<c:url value="/resources/custom/css/custom-design.css"/>"
	rel="stylesheet" />

<title>UPPT | Guide</title>


</head>
<body>

	<!--  HEADER INCLUSION  -->


	<div>
		<%@ include file="header.jsp"%>
	</div>

	<div class="jumbotron">
		<div class="container" align="center">
			<h3>Bienvenue sur Un Prof Pour Tous</h3>
			<p>Le site de référence pour trouver votre prochain cours!</p>
			<p>
		</div>

	</div>
	
		<div class="jumbotron">
			<div class="container" align="center">
				<h3>Premiers pas</h3>
				<p>Après vous être inscrit sur le site UPPT en ayant complété le formulaire d'inscription
					(lien en haut à droite de la page d'accueil), vous accédez à la page de compléments d'informations.<br/>
					Il ne vous est pas imposé de remplir le formulaire qui vous est proposé ( vous pouvez passer
					 l'étape en abs du formulaire). Toutefois, nous vous recommandons vivement de la compléter afin que les autres
					  utilisateurs puissent vous connaître d'avantage.<br/>
					Félicitations, vous êtes maintenant inscrit et accédez à votre profil !
					</p>
			</div>
		</div>
		
				<div class="jumbotron">
			<div class="container" align="center">
				<h3>Mon profil</h3>
				<p>Votre profil est constitué d'une section gauche vous présentant les informations principales
				de votre profil saisies lors de votre inscription<br/>
				La section principale met à votre disposition quatre onglets dont vous ne pourrez bientôt plus vous passer ...
					</p>
			</div>
		</div>
		
		<div class="jumbotron">
			<div class="container" align="center">
				<h3>Mon planning</h3>
				<p>C'est ici que vous pourrez programmer vos cours et avoir une vue d'ensemble sur tous vos
				 cours programmés<br/>
				 Votre planning est un véritable plus qui vous permet une meilleure gestion de votre temps,
				  mais il vous permet aussi de rapidement vous rappeler les différents détails concernant un 
				   cours : quels sont les devoirs à rendre ? Quels sont les sujets à aborder ? </br>
				  Tous ces détails auront préalablement été enregistrés dans le champ 'Commentaire' du formulaire de création de cours.				
					</p>
			</div>
		</div>
		
		<div class="jumbotron">
			<div class="container" align="center">
				<h3>Mes élèves OU Mes Professeurs</h3>
				<p>Selon que vous soyez inscrit sur UPPT en tant que professeur particulier ou élève, vous
				retrouverez ici la liste de tous vos élèves ou, respectivement, professeurs.			
					</p>
			</div>
		</div>
		
		<div class="jumbotron">
			<div class="container" align="center">
				<h3>Mes Annonces</h3>
				<p>Cet onglet vous permet de pouvoir visualiser toutes les annonces que vous avez postées.
					</p>
			</div>
		</div>
		
		<div class="jumbotron">
			<div class="container" align="center">
				<h3>Mes Publications</h3>
				<p>Cet onglet vous offre une fonctionnalité qui vous sera très utiles.<br/>
					Il permet de poster des publications : messages qui vous permettront de
					 faire parvenir à tous vos contacts des informations (ce qui est beaucoup plus 
					 simple et rapide que d'envoyer des textos à chacun de vos contact n'est-ce pas ?).
					 Une absence prévue dans quelques jours ? Un conseil à donner à vos élèves en vue d'un 
					 prochain examen ? Vos contacts auront simplement à consulter vos publications afin d'être informés. <br/>
					 La liste de toutes vos publications se trouvent également sur cet onglet et s'affichent par date dans l'ordre 
					 décroissant (la publication la plus récente en haut).		
					</p>
			</div>
		</div>
		
		<div class="jumbotron">
			<div class="container" align="center">
				<h3>Mes amis</h3>
				<p>	Vous retrouverez ici tous vos amis : vos amis sont vos contacts "professeurs" si 
				vous êtes vous même inscrit en tant que professeur et vos contacts "élèves" dans le cas contraire.	
					</p>
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