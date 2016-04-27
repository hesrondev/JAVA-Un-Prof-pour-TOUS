<!-- Panel de la liste des publications postées -->

<div class="row">
	<div class="col-lg-offset-1 col-lg-9">

		<c:forEach items="${currentUser.publications}" var="item">

			<div class="panel panel-default">

				<c:if test="${empty user.publications}">
					<div class="panel-body">
						<p align="center">Cet utilisateur n'a posté aucune publication
							pour le moment.</p>
					</div>
				</c:if>

				<ul class="list-group">

					<li class="list-group-item">
						<!-- description -->
						<p>
							${item.description}<br>
						</p> <!-- tags -->

					</li>


				</ul>
			</div>
		</c:forEach>

	</div>
</div>