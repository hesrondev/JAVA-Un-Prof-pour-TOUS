
<div>

	<!-- Formulaire de recherche d'une annonce -->

	<form:form modelAttribute="adBean" method="POST"
		action="${pageContext.request.contextPath}/annonces">

		<table>
			<tr>
				<td><form:label path="subject">Matière</form:label></td>
				<td><form:label path="location">Lieu</form:label></td>
			</tr>
			<tr>
				<td><form:input id="ad_subject" name="subject" path="subject"
						placeholder="ex: Cours de maths" /></td>

				<td><form:input id="ad_location" name="location"
						path="location" placeholder="ex: Paris" /></td>
				<td><input type="submit" value="Rechercher" /></td>
			</tr>
		</table>
	</form:form>
	<br>
</div>