
<!-- Formulaire de connexion -->


<div>
	<form:form modelAttribute="loginBean" method="POST"
		action="${pageContext.request.contextPath}/login"
		class="well">

		<legend align="center">Connexion</legend>

		<c:if test="${!empty loginStatus}">
			<div class="alert span5 alert-danger">
				<h3>Saisie invalide!</h3>
				<c:out value="${loginStatus}" />
			</div>
		</c:if>

		<div class="form-group">
			<form:label path="email">Adresse e-mail</form:label>
			<form:input id="email" name="email" path="email" class="form-control" />
		</div>

		<div class="form-group">
			<form:label path="password">Mot de passe</form:label>
			<form:password id="password" name="password" path="password"
				class="form-control" />
		</div>

		<div class="form-group">
			<form:checkbox path="rememberMe" />
			<form:label path="rememberMe"> Se souvenir de moi</form:label>
		</div>

		<div class="form-group">
			<input type="submit" value="CONNEXION" class="btn btn-primary btn-block" />
		</div>

		<div class="form-group">
			<a href="#">Mot de passe oublié?</a>
		</div>

		<div class="form-group">
			<a href="${pageContext.request.contextPath}/inscription.html">S'inscrire</a>
		</div>

	</form:form>



</div>