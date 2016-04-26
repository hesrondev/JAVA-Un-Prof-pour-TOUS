<div>
	<!-- Formulaire de recherche d'un utilisateur -->

	<form:form modelAttribute="userBean" method="GET"
		action="${pageContext.request.contextPath}/user/search" class="form-inline">
		
		<div class="input-group">
			<form:input path="fullName" placeholder="Rechercher" style="text-align:right"
				class="form-control input-sm" />
			<span class="input-group-btn">
				<button type="submit" class="btn btn-default btn-sm">
					<span class="glyphicon glyphicon-search"></span>&nbsp;
				</button>
			</span>
		</div>
		
	</form:form>
</div>