<!-- Panel de la liste des publications postées -->



<div class="panel panel-default">
	<div class="panel-heading">
		<h4>Mes publications</h4>
	</div>

	<c:if test="${empty currentUser.publications}">
		<div class="panel-body">
			<p align="center">Cet utilisateur n'a posté aucune publication pour
				le moment.</p>
		</div>
	</c:if>

	<ul class="list-group">

		<c:forEach items="${currentUser.publications}" var="item">

			<li class="list-group-item">
				
				<!-- description -->
				<p>
					${item.description}<br>
				</p>
				<!-- tags -->
			
			</li>
		</c:forEach>

	</ul>


	<!-- Boucle -->
</div>