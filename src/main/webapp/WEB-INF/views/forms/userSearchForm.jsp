<div>
	<!-- Formulaire de recherche d'un utilisateur -->

	<form:form modelAttribute="userBean" method="GET"
		action="${pageContext.request.contextPath}/${urlStatus}/search" class="form-inline">

		<div class="form-group">
			<form:input path="fullName" value="${name}"
				placeholder="${userStatus}" class="form-control input-sm" />
			<input type="submit" class="btn btn-default btn-sm"
				value="Rechercher" />
		</div>
	</form:form>
</div>