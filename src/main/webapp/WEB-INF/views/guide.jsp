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
			<p>Le site de r�f�rence pour trouver votre prochain cours!</p>
			<p>
		</div>

	</div>
	
		<div class="jumbotron">
			<div class="container" align="center">
				<h3>Premiers pas</h3>
				<p>Apr�s vous �tre inscrit sur le site UPPT en ayant compl�t� le formulaire d'inscription
					(lien en haut � droite de la page d'accueil), vous acc�dez � la page de compl�ments d'informations.<br/>
					Il ne vous est pas impos� de remplir le formulaire qui vous est propos� ( vous pouvez passer
					 l'�tape en abs du formulaire). Toutefois, nous vous recommandons vivement de la compl�ter afin que les autres
					  utilisateurs puissent vous conna�tre d'avantage.<br/>
					F�licitations, vous �tes maintenant inscrit et acc�dez � votre profil !
					</p>
			</div>
		</div>
		
				<div class="jumbotron">
			<div class="container" align="center">
				<h3>Mon profil</h3>
				<p>Votre profil est constitu� d'une section gauche vous pr�sentant les informations principales
				de votre profil saisies lors de votre inscription<br/>
				La section principale met � votre disposition quatre onglets dont vous ne pourrez bient�t plus vous passer ...
					</p>
			</div>
		</div>
		
		<div class="jumbotron">
			<div class="container" align="center">
				<h3>Mon planning</h3>
				<p>C'est ici que vous pourrez programmer vos cours et avoir une vue d'ensemble sur tous vos
				 cours programm�s<br/>
				 Votre planning est un v�ritable plus qui vous permet une meilleure gestion de votre temps,
				  mais il vous permet aussi de rapidement vous rappeler les diff�rents d�tails concernant un 
				   cours : quels sont les devoirs � rendre ? Quels sont les sujets � aborder ? </br>
				  Tous ces d�tails auront pr�alablement �t� enregistr�s dans le champ 'Commentaire' du formulaire de cr�ation de cours.				
					</p>
			</div>
		</div>
		
		<div class="jumbotron">
			<div class="container" align="center">
				<h3>Mes �l�ves OU Mes Professeurs</h3>
				<p>Selon que vous soyez inscrit sur UPPT en tant que professeur particulier ou �l�ve, vous
				retrouverez ici la liste de tous vos �l�ves ou, respectivement, professeurs.			
					</p>
			</div>
		</div>
		
		<div class="jumbotron">
			<div class="container" align="center">
				<h3>Mes Annonces</h3>
				<p>Cet onglet vous permet de pouvoir visualiser toutes les annonces que vous avez post�es.
					</p>
			</div>
		</div>
		
		<div class="jumbotron">
			<div class="container" align="center">
				<h3>Mes Publications</h3>
				<p>Cet onglet vous offre une fonctionnalit� qui vous sera tr�s utiles.<br/>
					Il permet de poster des publications : messages qui vous permettront de
					 faire parvenir � tous vos contacts des informations (ce qui est beaucoup plus 
					 simple et rapide que d'envoyer des textos � chacun de vos contact n'est-ce pas ?).
					 Une absence pr�vue dans quelques jours ? Un conseil � donner � vos �l�ves en vue d'un 
					 prochain examen ? Vos contacts auront simplement � consulter vos publications afin d'�tre inform�s. <br/>
					 La liste de toutes vos publications se trouvent �galement sur cet onglet et s'affichent par date dans l'ordre 
					 d�croissant (la publication la plus r�cente en haut).		
					</p>
			</div>
		</div>
		
		<div class="jumbotron">
			<div class="container" align="center">
				<h3>Mes amis</h3>
				<p>	Vous retrouverez ici tous vos amis : vos amis sont vos contacts "professeurs" si 
				vous �tes vous m�me inscrit en tant que professeur et vos contacts "�l�ves" dans le cas contraire.	
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