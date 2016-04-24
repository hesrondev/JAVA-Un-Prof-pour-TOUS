<!-- Panel de la liste des annonces postÃ©es -->



<div class="panel panel-default">
	<div class="panel-heading">
		<h4>Mes annonces</h4>
	</div>

	<c:if test="${empty user.annonces}">
		<div class="panel-body">
			<p align="center">Cet utilisateur n'a plublié aucune annonce pour
				l'instant.</p>
		</div>
	</c:if>

	<ul class="list-group">

		<c:forEach items="${user.annonces}" var="item">

			<li class="list-group-item">
			
				<!-- titre -->
				<h4>${item.title}</h4>
				
				<!-- description -->
				<p>
					${item.description}<br>
					<span class="badge">${item.location}</span>&nbsp;&nbsp;<span class="badge">${item.subject}</span>&nbsp;&nbsp;
					<span class="badge">${item.level}</span>&nbsp;&nbsp;<span class="badge">${item.toStringDate()}</span>&nbsp;&nbsp;
					<span class="badge">${item.costPerHour}&nbsp;euros/h</span><br><br>
					<a class="btn btn-sm btn-primary" href="#">Voir plus de détails</a>
				</p>
				<!-- tags -->
			
			</li>
		</c:forEach>

	</ul>


	<!-- Boucle -->
</div>