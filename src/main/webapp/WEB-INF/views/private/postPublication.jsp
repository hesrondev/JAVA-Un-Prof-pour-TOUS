

	<hr>
	<div class="container">

		<!-- Bloc formulaire de publication  -->
		<!--  On passe l'ID de l'utilisateur en paramètre -->

		<div class="row">
			<div class="col-lg-6">

				<h3>Ajout d'une publication</h3>
				<c:out
					value="Veuillez renseigner le champ ci-dessous puis clicker sur le bouton 'Publier' ppour poster une publication."></c:out>


				<!--  Formulaire -->

				<form:form modelAttribute="publiBean" method="POST"
					action="${pageContext.request.contextPath}/profile/publications">

					<!-- Erreur FORM -->
					<br>

					<c:if test="${!empty notConnectedStatus}">
						<div class="alert span5 alert-danger">
							<div>
								<c:out value="${notConnectedStatus}"></c:out>
								<p>
									<a href="${pageContext.request.contextPath}/inscription"><strong>S'inscrire</strong></a> ou
									<a href="${pageContext.request.contextPath}/login"><strong>Se
										connecter</strong></a>
								</p>
							</div>
						</div>
					</c:if>


					<c:if test="${!empty formStatus}">
						<div class="alert span5 alert-danger">
							<h3>Saisie invalide!</h3>
							<c:out value="${formStatus}" />
						</div>
					</c:if>

					<br>
					<legend>Publication</legend>

					<div class="form-group">
						<form:textarea id="publi_description" name="description"
							path="description" placeholder="Ecrivez ici le message que vous 
							souhaitez publier" rows="4" class="form-control input-sm" />
					</div>					

					<div class="form-group">
						<input type="submit" value="Publier"
							class="btn btn-default pull-right input-sm" />
					</div>

				</form:form>

			</div>
		</div>
	</div>
	<br>
	<br>