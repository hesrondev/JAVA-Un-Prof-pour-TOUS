<!-- Panel de la liste des annonces postÃ©es -->





<c:if test="${empty currentUser.annonces}">
	<div class="panel-body">
		<p align="center">Vous n'avez publié aucune annonce pour
			l'instant.<br><br>
			
			<a class="btn btn-xs btn-warning"
				href="${pageContext.request.contextPath}/annonces/create.html">
				<span class="glyphicon glyphicon-plus"></span>&nbsp;Publiez une annonce maintenant!
			</a>	
		</p>
	</div>
</c:if>


<c:forEach items="${currentUser.annonces}" var="item">
	<div class="panel panel-default">
		<div class="panel-body">

			<!-- titre -->
			<h4>${item.title}&nbsp;&nbsp;<small><a class="" href="#"><span
						class="glyphicon glyphicon-pencil"></span></a></small>
			</h4>

			<!-- description -->
			<p>
				${item.description}<br> <span class="badge">${item.location}</span>&nbsp;&nbsp;<span
					class="badge">${item.subject}</span>&nbsp;&nbsp; <span
					class="badge">${item.level}</span>&nbsp;&nbsp;<span class="badge">${item.toStringDate()}</span>&nbsp;&nbsp;
				<span class="badge">${item.costPerHour}&nbsp;euros/h</span><br>
				<br> <a class="btn btn-sm btn-primary" href="#">${item.applicationsCount()}&nbsp;candidatures</a>
			</p>
			<!-- tags -->
		</div>
	</div>

</c:forEach>
