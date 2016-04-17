<div>
	<br>
	<!-- Formulaire de recherche d'un utilisateur -->

	<form:form modelAttribute="userBean" method="GET"
		action="${pageContext.request.contextPath}/${urlStatus}/search">

		<table>

			<tr>
				<td><form:label path="fullName">Nom ${userStatus}</form:label></td>
			</tr>
			<tr>
				<td><form:input id="fullName" name="fullName" path="fullName" value="${name}"/></td>
				
				<td><input type="submit" class="button" value="Rechercher" /></td>
			</tr>
		</table>

	</form:form>
	<br>
</div>