


<!-- Formulaire pour les informations complémentaires -->



<!-- Formulaire de connexion -->


<div>
	<form:form modelAttribute="userInfosBean" method="POST"
		action="${pageContext.request.contextPath}/profile/completeUserInfos">

		<h3>Completez votre profil</h3>
		<c:out
			value="Compléter votre profil en renseignant les informations demandées ci-dessous
		nous aidera vous proposer des offres adaptées à vos attentes. Ces informations ne sont pas obligatoires."></c:out>
		<br>


		<c:if test="${!empty errorStatus}">
			<div class="alert span5 alert-danger">
				<h3>Saisie invalide!</h3>
				<c:out value="${errorStatus}" />
			</div>
		</c:if>
		<br>

		<!-- Si prof, profession -->
		<!-- Si élève, niveau scolaire -->
		<!-- Matière enseignée -->
		<!-- Matière souhaitée -->
		<!-- Formulaire de valeur à valider/annule, ajouter chaque valeur dans la suite -->
		<!-- Proposer un tableau de valeurs à cocher et récup OPTIONNEL-->

		<legend>A propos de votre profession</legend>

		<div class="form-group">
			<form:label path="profession">Profession</form:label>
			<form:select path="profession" class="form-control">
				<form:option value="">--Choisir sa profession--</form:option>
				<form:option value="eleve">Etudiant</form:option>
				<form:option value="prof_college">Professeur de Collège</form:option>
				<form:option value="prof_lycee">Professeur de Lycée</form:option>
				<form:option value="prof_univ">Professeur d'Université�</form:option>
				<form:option value="ingenieur_agronome">Ingénieur agronome</form:option>

				<!-- MAP KEY-VALUE A PARCOURIR !!! -->
			</form:select>
		</div>

		<!-- Année d'expériences SI COMPTE PROF A METTRE -->

		<c:if test="${currentUser.type == 'PROFESSOR'}">

			<div class="form-group">
				<form:label path="experience">Expérience</form:label>
				<div class="input-group">
					<form:select path="experience" class="form-control">
						<c:forEach begin="" end="100" var="val">
							<form:option value="${val}">
								<c:out value="${val}"></c:out>
							</form:option>
						</c:forEach>
					</form:select>
					<span class="input-group-addon">an</span>
				</div>
			</div>

		</c:if>


		<legend>Votre emplacement</legend>

		<div class="form-group">
			<form:label path="city">Ville</form:label>
			<form:select path="city" class="form-control">
				<form:option value="paris">Paris</form:option>
				<form:option value="massy">Massy</form:option>
				<form:option value="versailles">Versailles</form:option>

				<!-- MAP KEY-VALUE A PARCOURIR !!! -->

			</form:select>
		</div>

		<div class="form-group">
			<form:label path="country">Pays</form:label>
			<form:select path="country" class="form-control">
				<form:option value="france">France</form:option>
				<form:option value="belgique">Belgique</form:option>
				<form:option value="congo">Congo</form:option>

				<!-- MAP KEY-VALUE A PARCOURIR !!! -->

			</form:select>
		</div>

		<legend>A propos de vous?</legend>

		<div class="form-group">
			<form:label path="birthDate">Date de naissance</form:label>
			<form:input type="date" path="birthDate" class="form-control" />
		</div>

		<div class="form-group">
			<form:label path="phoneNumber">Téléphone</form:label>
			<form:input path="phoneNumber" class="form-control" />
		</div>

		<div class="form-group">
			<form:label path="aboutMe">Décrivez-vous en quelques mots</form:label>
			<form:textarea path="aboutMe" rows="6" class="form-control" />
		</div>


		<div class="form-group">
			<input type="submit" value="Enregistrer les informations"
				class="btn btn-primary btn-block" />
		</div>
		<br>
		<div class="form-group">
			<a href="${pageContext.request.contextPath}/profile">Passer
				cette étape</a>
		</div>

	</form:form>

</div>