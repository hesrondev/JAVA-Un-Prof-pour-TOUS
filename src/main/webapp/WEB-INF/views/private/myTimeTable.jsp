<!-- PLANNING -->

<c:if test="${currentUser.type == 'PROFESSOR'}">

	<div class="panel panel-default">
		<div class="panel-heading">
			<h4>
				Mon planning <small>(programmation des prochains cours)</small>
			</h4>
		</div>

		<div class="panel-body">
			<p>
				<a class="btn btn-xs btn-warning"
					href="${pageContext.request.contextPath}/profile/planning/add-event">
					<span class="glyphicon glyphicon-plus"></span>&nbsp;Programmer un
					cours
				</a>
			</p>
		</div>

		<table class="table table-striped">
			<tr>
				<th>Intitulé du Cours</th>
				<th>Eleve</th>
				<th>Ville</th>
				<th>Date</th>
				<th>Commentaire</th>
				<th>Action</th>
			</tr>


			<c:forEach items="${currentUser.planning.courses}" var="item">

				<tr>
					<td>${item.title}</td>
					<td>${item.studentName}</td>
					<td>${item.city}</td>
					<td>${item.toStringDate()}</td>
					<td>${item.comment}</td>
					<td>
						<div>
							<a class="btn btn-xs btn-default" href="#"> <span
								class="glyphicon glyphicon-trash"></span>&nbsp;Archiver le cours
							</a>
						</div>
					</td>

				</tr>
			</c:forEach>

		</table>

		<!-- Si la table est vide l'afficher -->
		<c:if test="${empty currentUser.planning.courses}">
			<div class="panel-footer">
				<p align="center">
					Vous n'avez programmé aucun cours. Appuyez sur <a
						href="${pageContext.request.contextPath}/profile/planning/add-event">programmer
						un cours</a> pour ajouter votre prochain cours.
				</p>
			</div>
		</c:if>

	</div>
</c:if>