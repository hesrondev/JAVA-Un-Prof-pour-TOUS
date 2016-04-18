<!-- FORMULAIRE CACHE 
	 VARIABLE ${action} OBLIGATOIRE avec les valeurs: 'add' - 'cancel' - 'accept' ou 'refuse'
	 
	 IL EST NECESSAIRE DE DEFINIR LES VARIABLES AVANT D'inclure le formulaire
	  -->



<form:form
	action="${pageContext.request.contextPath}/profile/request-processing/${action}"
	method="POST" commandName="requestBean">
	<form:hidden path="id" value="${requestID}" />
	<form:hidden path="senderID" value="${senderID}" />
	<form:hidden path="receiverID" value="${receiverID}" />
	<form:hidden path="response" value="${action}" />
	
	<c:if test="${action == 'add'}">
		<input type="submit" value="AJOUTER" />
	</c:if>
	
	<c:if test="${action == 'cancel'}">
		<input type="submit" value="ANNULER" />
	</c:if>
	
	<c:if test="${action == 'refuse'}">
		<input type="submit" value="REFUSER" />
	</c:if>
	
	<c:if test="${action == 'accept'}">
		<input type="submit" value="ACCEPTER" />
	</c:if>
</form:form>