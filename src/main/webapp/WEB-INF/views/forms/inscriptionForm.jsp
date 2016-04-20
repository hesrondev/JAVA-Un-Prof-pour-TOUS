<div class="row">
	<div class="col-lg-6">
		<form:form action="${pageContext.request.contextPath}/inscription"
			method="POST" commandName="inscriptionBean">

			<br>
			<legend>Formulaire d'inscription</legend>

			<c:if test="${!empty userStatus}">
				<div class="alert span5 alert-danger">
					<h3>Formulaire invalide!</h3>
					<c:out value="${userStatus}" />
				</div>
			</c:if>

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
			</div>
			<div class="form-group">
				<form:label path="rePassword">
					<spring:message text="Retapez le de passe" />
				</form:label>
				<form:password path="rePassword" class="form-control" />
			</div>

			<div class="form-group">

				<form:label path="status">
					<spring:message text="Type de compte? " />
				</form:label>

				<form:select path="status" class="form-control">
					<form:option value="student">Compte Elève</form:option>
					<form:option value="professor">Compte Professeur Particulier</form:option>
				</form:select>
			</div>

			<div class="form-group">
				<input class="btn btn-primary" type="submit" value="INSCRIPTION" />
			</div>
		</form:form>
	</div>
</div>