<div align="center">
	<!-- Formulaire de connexion -->


	<form:form modelAttribute="loginBean" method="POST"
		action="${pageContext.request.contextPath}/login">

		<fieldset id="connexionForm">
			
			<h3>Connexion</h3>
			
			<dl>
				<c:out value="${loginStatus}"></c:out>
			</dl>

			<dl>
				<form:label path="email">Adresse e-mail</form:label>
				<form:input id="email" name="email" path="email" />
			</dl>

			<dl>
				<form:label path="password">Mot de passe</form:label>
				<form:password id="password" name="password" path="password" />
			</dl>

			<dl>
				<form:checkbox path="rememberMe" />
				<form:label path="rememberMe"> Se souvenir de moi</form:label>
			</dl>

			<p>
				<input type="submit" value="CONNEXION"/>
			</p>
			<p>
				<a href="#">Mot de passe oublié?</a> <br>
				<a href="${pageContext.request.contextPath}/inscription.html">S'inscrire</a>
			</p>
		</fieldset>
	</form:form>



</div>