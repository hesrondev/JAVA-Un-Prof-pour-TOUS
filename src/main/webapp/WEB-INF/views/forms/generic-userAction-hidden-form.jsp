<!-- FORMULAIRE CACHE SUPPRESSION D'UN ELEVE OU D'UN PROFESSEUR 
	IL FAUT DEFINIR UNE VARIABLE userID avant d'inclure ce formulaire-->


<form:form
	action="${pageContext.request.contextPath}/user/action-processing/${action}"
	method="POST" commandName="userBean">
	
	<form:hidden path="userID" value="${userID}" />
	
	<!-- Pour supprimer un élève -->
	<c:if test="${action == 'delete-professor'}">
		<input type="submit" value="Supprimer" class="btn btn-danger btn-xs"/>
	</c:if>
	
	<!-- Supprimer un professeur -->
	<c:if test="${action == 'delete-student'}">
		<input type="submit" value="Supprimer" class="btn btn-danger btn-xs"/>
	</c:if>
	
	
</form:form>