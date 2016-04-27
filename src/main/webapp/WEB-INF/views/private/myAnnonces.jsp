<!-- Panel de la liste des annonces postées -->



<div class="panel panel-default">
	<div class="panel-heading">
		<h4>Mes annonces</h4>
	</div>

	<c:if test="${empty currentUser.annonces}">
		<div class="panel-body">
			<p align="center">Vous n'avez publié aucune annonce pour
				l'instant.</p>
		</div>
	</c:if>

	<ul class="list-group">

		<c:forEach items="${currentUser.annonces}" var="item">

			<li class="list-group-item">
			
				<!-- titre -->
				<h4>${item.title}&nbsp;&nbsp;<small><a class="" href="#"><span class="glyphicon glyphicon-pencil"></span></a></small></h4>
				
				<!-- description -->
				<p>
					${item.description}<br>
					<span class="badge">${item.location}</span>&nbsp;&nbsp;<span class="badge">${item.subject}</span>&nbsp;&nbsp;
					<span class="badge">${item.level}</span>&nbsp;&nbsp;<span class="badge">${item.toStringDate()}</span>&nbsp;&nbsp;
					<span class="badge">${item.costPerHour}&nbsp;euros/h</span><br><br>
					<a class="btn btn-sm btn-primary" href="#">${item.applicationsCount()}&nbsp;candidatures</a>
				</p>
				<!-- tags -->
			
			</li>
		</c:forEach>

	</ul>


	<!-- Boucle -->
</div>