<!-- Panel de la liste d'amis de l'utilisateur -->

<div class="panel panel-default">
	<div class="panel-heading">
		<h4>Amis</h4>
	</div>

	<c:if test="${empty user.myFriends}">
		<div class="panel-body">
			<p align="center">Cet utilisateur n'a pas d'ami pour le moment.
			<p>
		</div>

	</c:if>

	<ul class="list-group">

		<c:forEach items="${user.myFriends}" var="item">
			<li class="list-group-item">

				<div class="row">
					<div class="col-lg-10">
						<!-- Photo de profil 90*90 -->
						<!-- Infos sur la personne -->

						<table>
							<tr>
								<td><a href="#"> <img
										src="resources/img/default-picture-s45.png"
										class="img-thumbnail"></a></td>
								<td><a href="#">${item.firstName}&nbsp;${item.lastName}</a><br>
									<small> <c:out value="${item.type}"></c:out></small> <c:if
										test="${!empty item.profession}">&nbsp;&bull;&nbsp;<small><c:out
												value="${item.profession}"></c:out></small>
									</c:if></td>
							</tr>
						</table>


					</div>

					<div class="col-lg-2">

						<!-- Inclusion du bouton approprié -->
						<div class="">

							<c:set var="item" value="${user}"></c:set>
							<%@ include file="forms/generic-friendAction-button.jsp"%>

						</div>
					</div>

				</div>
			</li>
		</c:forEach>

	</ul>


	<!-- Boucle -->
</div>