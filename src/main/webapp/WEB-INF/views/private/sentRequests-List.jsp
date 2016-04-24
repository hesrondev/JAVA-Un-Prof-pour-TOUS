<!-- Panel de la liste des demandes d'amis -->



<div class="panel panel-default">
	<div class="panel-heading">
		<h4>Demandes envoyées</h4>
	</div>

	<c:if test="${currentUser.sentFriendRequestsCount() == 0}">
		<div class="panel-body">
			<p align="center">Vous n'avez actuellement aucune demande d'ami
				en attente de validation.</p>
		</div>
	</c:if>

	<ul class="list-group">

		<c:forEach items="${currentUser.friendRequests}" var="item">
			<c:if test="${item.sent}">

				<li class="list-group-item"><a href="#">${item.receiverName}</a>

					<!-- BOUTON ANNULER -->

					<div class='pull-right'>
						<c:set var="action" value="cancel"></c:set>
						<c:set var="requestID" value="${item.id}"></c:set>
						<c:set var="senderID" value="${item.senderID}"></c:set>
						<c:set var="receiverID" value="${item.senderID}"></c:set>
						<%@ include file="../forms/generic-request-hidden-form.jsp"%>
					</div>
				</li>
				<!-- FIN DE LA LISE -->
			</c:if>
		</c:forEach>

	</ul>


	<!-- Boucle -->
</div>