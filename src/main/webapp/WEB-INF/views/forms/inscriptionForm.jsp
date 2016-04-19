<div class="row">

	<form:form action="${pageContext.request.contextPath}/inscription"
		method="POST" commandName="inscriptionBean" class="col-lg-6">

		<legend>Inscription</legend>

		<div class="form-group">
			<c:out value="${userStatus}" />
		</div>


		<div class="form-group">
			<div class="row">
				<div class="col-lg-6">
					<form:label path="firstName">
						<spring:message text="Prénom" />
					</form:label>
				</div>
				<div class="col-lg-6">
					<form:label path="lastName">
						<spring:message text="Nom" />
					</form:label>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-6">
					<form:input path="firstName" class="form-control" />
				</div>
				<div class="col-lg-6">
					<form:input path="lastName" class="form-control" />
				</div>
			</div>

		</div>

		<div class="form-group">
		
			<form:label path="email">
				<spring:message text="Email" />
			</form:label>
			<form:input path="email" class="form-control" />
		</div>

		<div class="form-group">

			<form:label path="password">
				<spring:message text="Mot de passe" />
			</form:label>
			<form:password path="password" class="form-control" />
			<form:label path="rePassword">
				<spring:message text="Retapez le de passe" />
			</form:label>
			<form:password path="rePassword" class="form-control" />

		</div>

		<div class="form-group">

			<form:label path="status">
				<spring:message text="Votre statut : " />
			</form:label>

			<form:select path="status" class="form-control">
				<form:option value="student">Elève</form:option>
				<form:option value="professor">Professeur</form:option>
			</form:select>
		</div>

		<div class="form-group">
			<input class="btn btn-primary" type="submit" value="INSCRIPTION" />
		</div>
	</form:form>
</div>