
<div>

	<!-- Formulaire de recherche d'une annonce -->

	<form:form modelAttribute="adBean" method="POST"
		action="${pageContext.request.contextPath}/annonces">

		<fieldset>

			<table class="form">
				<thead>
					<tr>
						<th><form:label path="subject">Matière</form:label></th>
						<th><form:label path="location">Lieu</form:label></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><form:input id="ad_subject" name="subject" path="subject"
								placeholder="ex: Maths" /></td>
						<td><form:input id="ad_location" name="location"
								path="location" placeholder="ex: Paris" /></td>
						<td><input type="submit" value="Rechercher" /></td>
					</tr>
				</tbody>
			</table>
		</fieldset>
	</form:form>
	<br>
</div>