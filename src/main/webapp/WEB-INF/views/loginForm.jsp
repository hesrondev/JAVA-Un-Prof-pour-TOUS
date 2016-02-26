<div align="center">
	<!-- Formulaire de connexion -->
	<form:form modelAttribute="loginBean" method="POST"
		action="${pageContext.request.contextPath}/login">
		<table width="350" id="tableForm">

			<tr>
				<td><c:out value="${loginStatus}"></c:out></td>
			</tr>

			<tr>
				<td><form:label path="email">Adresse e-mail</form:label></td>
			</tr>
			<tr>
				<td><form:input id="email" name="email" path="email" /></td>
			</tr>

			<tr>
				<td><form:label path="password">Mot de passe</form:label></td>
			</tr>
			<tr>
				<td><form:password id="password" name="password" path="password" /></td>
			</tr>
			<tr>
			<td> <form:checkbox path="rememberMe"/><form:label path="rememberMe"> Se souvenir de moi</form:label></td>
			</tr>
			<tr>
				<td><input type="submit" value="CONNEXION" /></td>
			</tr>
			<tr>
				<td><a href="#">Mot de passe perdu?</a></td>
			</tr>
		</table>
	</form:form>
</div>