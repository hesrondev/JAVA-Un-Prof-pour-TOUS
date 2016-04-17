
<div>
	<br>
	<!-- Formulaire de recherche d'une annonce -->

	<form:form modelAttribute="adBean" method="GET"
		action="${pageContext.request.contextPath}/annonces/recherche">

		<table>

			<tr>
				<td><form:label path="subject">Matière</form:label></td>
				<td><form:label path="location">Lieu</form:label></td>
			</tr>
			<tr>
			<td><form:input id="ad_subject" name="subject" path="subject"
				value="${subject}" placeholder="ex: Maths, Physique, ..." /></td>
				
				<td><form:input id="ad_location" name="location" value="${location}"
				path="location" placeholder="ex: Paris, Lyon, Marseille, ..." /></td>
				<td><input type="submit" class="button" value="Rechercher" /></td>
			</tr>
		</table>

	</form:form>
	<br>
</div>