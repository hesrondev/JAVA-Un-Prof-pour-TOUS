<div>
	<form:form modelAttribute="annonceApplicationBean" method="POST"
		action="${pageContext.request.contextPath}/annonces/candidater/${annonce.id}">

		<legend>Renseignez vos coordonnées</legend>

		<c:if test="${!empty ERRORS}">
			<div class="form-group">

				<div class="alert span5 alert-danger">
					<c:out value="${ERRORS}"></c:out>
				</div>
			</div>
		</c:if>

		<!-- FIRSTNAME -->

		<div class="form-group">

			<form:label path="firstName">Prénom: *</form:label>
			<form:input id="ad_app_firstName" name="firstName" path="firstName"
				value="${userFirstName}" class="form-control input-sm" />
		</div>

		<!-- LASTNAME -->

		<div class="form-group">

			<form:label path="lastName">Nom: *</form:label>

			<form:input id="ad_app_lastName" name="lastName" path="lastName"
				value="${userLastName}" class="form-control input-sm" />
		</div>


		<!-- EMAIL -->
		<div class="form-group">

			<form:label path="email">Email: *</form:label>
			<form:input id="ad_app_email" name="email" path="email"
				value="${userEmail}" class="form-control input-sm" />
		</div>

		<div class="form-group">
			<form:label path="phoneNumber">Téléphone:</form:label>

			<form:input id="ad_app_phone" name="phoneNumber" path="phoneNumber"
				value="${userPhoneNumber}" class="form-control input-sm" />
		</div>

		<!-- MESSAGE -->

		<div class="form-group">
			<form:label path="message">Message facultatif:</form:label>

			<form:textarea id="ad_app_message" name="message" path="message"
				class="form-control input-sm" rows='4'/>
		</div>

		<div class="form-group">
			<input type="submit" value="Candidater"
				class="btn btn-default pull-right" />

		</div>

	</form:form>
</div>
