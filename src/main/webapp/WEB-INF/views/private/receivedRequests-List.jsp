<!-- Panel de la liste des demandes d'amis -->



<div class="panel panel-default">
	<div class="panel-heading">
		<h4>Demandes d'amis</h4>
	</div>

	<c:if test="${currentUser.receivedFriendRequestsCount() == 0}">
		<div class="panel-body">
			<p align="center">Vous n'avez reçu aucune demande en ami.</p>
		</div>
	</c:if>

	<ul class="list-group">

		<c:forEach items="${currentUser.friendRequests}" var="item">
			<c:if test="${item.received}">

				<li class="list-group-item">

					<div class="row">
						<div class="col-lg-6">
							<!-- Photo de profil 90*90 -->
							<!-- Infos sur la personne -->

							<table class="">
								<tr>
									<td><a href="#"> <img
											src="resources/img/default-picture-s45.png"
											class="img-thumbnail"></a></td>
									<td>
										<p>
											<a href="#">${item.senderName}</a><br> <small><c:out
													value="${item.user.type}"></c:out></small>
										</p>
									</td>
								</tr>

							</table>


						</div>

						<div class="col-lg-6">

						<div class="pull-right">
							<!-- BOUTON ACCEPT -->
							<c:set var="action" value="accept"></c:set>
							<c:set var="requestID" value="${item.id}"></c:set>
							<c:set var="senderID" value="${item.senderID}"></c:set>
							<c:set var="receiverID" value="${item.senderID}"></c:set>
							<%@ include file="../forms/generic-request-hidden-form.jsp"%>
						</div>
						
						<div class="pull-right">

							<!-- BOUTON REFUSE -->
							<c:set var="action" value="refuse"></c:set>
							<c:set var="requestID" value="${item.id}"></c:set>
							<c:set var="senderID" value="${item.senderID}"></c:set>
							<c:set var="receiverID" value="${item.senderID}"></c:set>
							<%@ include file="../forms/generic-request-hidden-form.jsp"%>
						</div>

					</div>
				</li>
				<!-- FIN DE LA LISE -->
			</c:if>
		</c:forEach>

	</ul>


	<!-- Boucle -->
</div>