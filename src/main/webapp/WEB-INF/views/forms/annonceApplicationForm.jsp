<div>

	<form:form modelAttribute="annonceApplicationBean" method="POST"
		action="${pageContext.request.contextPath}/annonces/candidater/${annonce.id}">

		<table>
			<!-- FIRSTNAME -->
			<tr>
				<td><form:label path="firstName">Prénom: *</form:label></td>
			</tr>
			<tr>
				<td><form:input id="ad_app_firstName" name="firstName"
						path="firstName" value="${userFirstName}" /></td>
			</tr>

			<!-- LASTNAME -->
			<tr>
				<td><form:label path="lastName">Nom: *</form:label></td>
			</tr>
			<tr>
				<td><form:input id="ad_app_lastName" name="lastName"
						path="lastName" value="${userLastName}" /></td>
			</tr>

			<!-- EMAIL -->
			<tr>
				<td><form:label path="email">Email: *</form:label></td>
			</tr>
			<tr>
				<td><form:input id="ad_app_email" name="email" path="email"
						value="${userEmail}" /></td>
			</tr>

			<!-- PHONE 
				<tr>
					<td><form:label path="phoneNumber">Téléphone:</form:label></td>
				</tr>
				<tr>
					<td> <form:input id="ad_app_phone" name="phoneNumber" path="phoneNumber"
							value="${userPhoneNumber}" /></td>
				</tr>-->

			<!-- MESSAGE -->
			<tr>
				<td><form:label path="message">Message facultatif:</form:label></td>
			</tr>
			<tr>
				<td><form:textarea id="ad_app_message" name="message"
						path="message" /></td>
			</tr>

			<tr>
				<td><input type="submit" class="button" value="Candidater" /></td>
			</tr>
		</table>

	</form:form>
	<br>

</div>
