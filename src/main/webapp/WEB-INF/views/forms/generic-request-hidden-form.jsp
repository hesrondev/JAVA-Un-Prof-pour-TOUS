<!-- FORMULAIRE CACHE 
	 VARIABLE ${action} OBLIGATOIRE avec les valeurs: 'add' - 'cancel' - 'accept' - 'refuse' ou 'delete'
	 
	 IL EST NECESSAIRE DE DEFINIR LES VARIABLES AVANT D'inclure le formulaire
	  -->

<form:form
	action="${pageContext.request.contextPath}/profile/request-processing/${action}"
	method="POST" commandName="requestBean">
	<form:hidden path="id" value="${requestID}" />
	<form:hidden path="senderID" value="${senderID}" />
	<form:hidden path="receiverID" value="${receiverID}" />
	<form:hidden path="action" value="${action}" />
	
	<c:if test="${action == 'add'}">
		<button type="submit" class="btn btn-default btn-xs">
		<span class="glyphicon glyphicon-plus"></span>&nbsp;&nbsp;Ajouter contact</button>
	</c:if>
	
	<c:if test="${action == 'cancel'}">
		<button type="submit" class="btn btn-default btn-xs">
		<span class="glyphicon glyphicon-remove"></span>&nbsp;&nbsp;Annuler la demande</button>
	</c:if>
	
	<c:if test="${action == 'refuse'}">
		<button type="submit" class="btn btn-danger btn-xs">
		<span class="glyphicon glyphicon-remove"></span>&nbsp;&nbsp;Refuser</button>
	</c:if>
	
	<c:if test="${action == 'accept'}">
		<button type="submit" class="btn btn-success btn-xs">
		<span class="glyphicon glyphicon-ok"></span>&nbsp;&nbsp;Accepter</button>
	</c:if>
	
	<c:if test="${action == 'delete'}">
		<button type="submit" class="btn btn-default btn-xs">
		<span class="glyphicon glyphicon-trash"></span>&nbsp;&nbsp;Retirer de la liste</button>
	</c:if>
	
</form:form>