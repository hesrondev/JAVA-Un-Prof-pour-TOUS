<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" />

	
<link href="<c:url value="/resources/custom/css/default.css"/>"
	rel="stylesheet" />

<link href="<c:url value="/resources/custom/css/flaty.css"/>"
	rel="stylesheet" />
	
<link href="<c:url value="/resources/custom/css/custom-design.css"/>"
	rel="stylesheet" />


<title>UPPT | A Propos</title>


</head>
<body>

	<!--  HEADER INCLUSION  -->

	<%@ include file="header.jsp"%>

	<div class="jumbotron">
		<div class="container" align="center">
			<h3>A qui s'adresse UPPT</h3>
			<p>Vous rechercher à vous perfectionner dans un domaine ? Vous rencontrez des difficultés scolaires ?
			 Peut importe votre âge et votre parcours, n'importe qui peut s'inscrire en tant qu'élève UPPT et 
			 rechercher des professeurs particuliers qui pourront lui apporter leur aide.<br/>
			 Au contraire vous avez des compétences dans un domaine particulier et pensez pouvoir en faire profiter les élèves UPPT ?
			 Inscrivez vous en tant que professeurs et répondez aux annonces publiées par les élèves ou publiez vos propre annonces afin
			  de proposer vos services. <br/>
			</p>
		</div>
	 </div>
	 
	 <div class="jumbotron">
		<div class="container" align="center">
			<h3>Pourquoi UPPT et pas un autre site ?</h3>
			<p>UPPT est unique car il permet à tout le monde de s'inscrire selon ses attentes, mais pas seulement.<br/>
				UPPT vous propose des fonctionnalités telles que la gestion de votre planning, la possibilité de poster 
				des publications et plus encore.<br/>
				Ces fonctionnalités font d'UPPT un outil indispensable et extrêmement pratique.
			</p>
		</div>
	 </div>
	   
	   <!--  FOOTER INCLUSION  -->

	<div class="container">
		<footer class="row">
		<div class="col-lg-12">
			<%@ include file="footer.jsp"%>
		</div>
		</footer>
	</div>

 
<!-- Formulaire envoi de mail -->
<!-- 
<center>
<form action="mailto:uppt.contact@gmail.com?subject=Envoie de mail à partir de UPPT/contact" name="envoi" method=POST enctype="text/plain">
<table border="0"><tr><td>
<b>Nom : </b><input name="nom"size=50 maxlength=50><br>
<b>Prenom : </b><input name="PRENOM"size=50 maxlength=50><br>
<b>Adresse e-mail </b><input name="e-mail"size=50 maxlength=50><br>
<textarea name="message" cols="60" rows="5"></textarea>
</td></tr></table><br>
Votre avis sur le site
<input type="radio" name="avis" value="tres bien">
Tr&egrave;s Bien - &nbsp;
<input type="radio" name="avis" value="bien">
Bien - &nbsp;
<input type="radio" name="avis" value="moyen">
Moyen - &nbsp;
<input type="radio" name="avis" value="Pas bien">
Pas bien<br>
<input type="submit" value="Envoyer" name="Envoyer">
<input type="reset" name="Submit" value="Effacer">
</form>
<hr>
</center>
-->

	<!-- INCLUSION JS -->
		
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>

		<!-- Latest compiled and minified JavaScript -->
		<script
			src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

</body>
</html>