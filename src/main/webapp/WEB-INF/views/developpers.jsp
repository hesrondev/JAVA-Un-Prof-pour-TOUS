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


<title>UPPT | Développeurs</title>


</head>
<body>

	<!--  HEADER INCLUSION  -->

	<%@ include file="header.jsp"%>

	<div class="jumbotron">
		<div class="container" align="center">
			<h3>Louange Bizi Bandoki</h3>
			<p>Etudiant à Ingésup Paris en Expert 1 (Bac + 4)<br/> 
			</p>
		</div>
	 </div>
	 
	 <div class="jumbotron">
		<div class="container" align="center">
			<h3>Souad Belmehdi</h3>
			<p>Egalement étudiante à Ingésup Paris en Expert 1 (Bac + 4).
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