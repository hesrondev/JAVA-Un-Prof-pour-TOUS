<!-- TABLEAU DE PROFESSEURS -->


<div class="panel panel-default">
	<div class="panel-heading">
		<h4>
			Mes professeurs <small>(intitulé du tableau)</small>
		</h4>
	</div>
	
	<div class="panel-body">
		<p>Quelques commentaires sur le tableau</p>
	</div>
	
	<table class="table table-striped">	
		<tr>
			<th>Nom</th>
			<th>Prénom</th>
			<th>Matière</th>
			<th>Ville</th>
			<th>Action</th>
		</tr>
		<tr>
			<td>Tony</td>
			<td>Karenthur</td>
			<td>Histoire-Géo</td>
			<td>Paris</td>
			<td>
				<div>
					<!-- Formulaire caché du bouton supprimer -->
					<c:set var="action" value="delete-professor"></c:set>
					<c:set var="userID" value="${currentUser.id}"></c:set> <!-- ATTENTION CHANGER LA VALEUR -->
					<%@ include file="../forms/generic-userAction-hidden-form.jsp" %>
				</div>
			</td>
		</tr>

	</table>
</div>