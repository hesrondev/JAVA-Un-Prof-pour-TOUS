
<div align="center">
	
	<!-- Formulaire de recherche d'une annonce -->
	
	<h3>Rechercher une annonce</h3>
	<form method="GET" action="${pageContext.request.contextPath}/searchAnnonce">
		<input id="Content" type="text" name="content" placeholder="Mots-clés (ex: cours de maths)"/>
		<input id="location" type="text" name="location" placeholder="Lieu (ex: Paris)"/>
		<input type="submit" value="Rechercher"/>
	</form>
	<br>
	<a href="#">Recherche avancée</a>
</div>