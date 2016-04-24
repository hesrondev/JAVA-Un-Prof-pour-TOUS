<!-- Conditions pour savoir quel bouton afficher
     Sur un profil 
     
     // Créer la variable ITEM et lui donner la valeur du user visité -->


<c:choose>

	<c:when
		test="${item.id == currentUser.id || currentUser.hasBeenRequestedByFriend(item.id) > -1}">

		<!-- CAS OU JE NE PEUX RIEN FAIRE --> No action needed!
	</c:when>
	<c:when test="${currentUser.getFriend(item.id) != null}">

		<!--  CAS OU JE PEUX SUPPRIMER -->
		<!-- BOUTON SUPPRIMER -->
		<div>
			<c:set var="action" value="delete"></c:set>
			<c:set var="requestID" value="${0}"></c:set>
			<c:set var="senderID" value="${currentUser.id}"></c:set>
			<c:set var="receiverID" value="${item.id}"></c:set>
			<%@ include file="../forms/generic-request-hidden-form.jsp"%>
		</div>

	</c:when>

	<c:when test="${currentUser.hasRequestedFriend(item.id) > -1}">

		<!-- BOUTON ANNULER -->
		<!-- CAS OU JE PEUX ANNULER -->
		<div>
			<c:set var="action" value="cancel"></c:set>
			<c:set var="requestID"
				value="${currentUser.hasRequestedFriend(item.id)}"></c:set>
			<c:set var="senderID" value="${currentUser.id}"></c:set>
			<c:set var="receiverID" value="${item.id}"></c:set>
			<%@ include file="../forms/generic-request-hidden-form.jsp"%>
		</div>

	</c:when>


	<c:otherwise>

		<!-- CAS OU JE PEUX AJOUTER -->
		<!-- BOUTON AJOUTER -->
		<div>
			<c:set var="action" value="add"></c:set>
			<c:set var="requestID" value="${0}"></c:set>
			<c:set var="senderID" value="${currentUser.id}"></c:set>
			<c:set var="receiverID" value="${item.id}"></c:set>
			<%@ include file="../forms/generic-request-hidden-form.jsp"%>
		</div>

	</c:otherwise>
</c:choose>