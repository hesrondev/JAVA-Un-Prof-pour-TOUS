
<div>

	<!-- Formulaire de recherche d'une annonce -->

	<form:form modelAttribute="adBean" method="POST"
		action="${pageContext.request.contextPath}/annonces">

	

		<form:label path="subject">Matière</form:label>
			<form:input id="ad_subject" name="subject" path="subject"
					placeholder="ex: Maths" />
								
		<form:label path="location">Lieu</form:label>
			<form:input id="ad_location" name="location"
					path="location" placeholder="ex: Paris" />
					
		<input type="submit" class="button" value="Rechercher" />
			
		
	</form:form>
	<br>
</div>