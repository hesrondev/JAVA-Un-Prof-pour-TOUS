<!-- TABLEAU DES ELEVES -->


<div class="panel panel-default">
	<div class="panel-heading">
		<h4>
			Mes �l�ves <small>(intitul� du tableau)</small>
		</h4>
	</div>

	<div class="panel-body">
		<p>Quelques commentaires sur le tableau</p>
	</div>

	<table class="table table-striped">	
		<tr>
			<th>Nom</th>
			<th>Pr�nom</th>
			<th>Mati�re</th>
			<th>Niveau</th>
			<th>Ville</th>
			<th>Action</th>
		</tr>
		<tr>
			<td>Tony</td>
			<td>Karenthur</td>
			<td>Histoire-G�o</td>
			<td>3e</td>
			<td>Paris</td>
			<td>
				<div>
					<!-- Formulaire cach� du bouton supprimer -->
					<c:set var="action" value="delete-student"></c:set>
					<c:set var="userID" value="${currentUser.id}"></c:set> <!-- ATTENTION CHANGER LA VALEUR -->
					<%@ include file="../forms/generic-userAction-hidden-form.jsp" %>
				</div>
			</td>
		</tr>

	</table>
</div>