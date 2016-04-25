


<!-- Formulaire pour les informations complémentaires -->



<!-- Formulaire de connexion -->


<div>
	<form:form modelAttribute="userInfosBean" method="POST"
		action="${pageContext.request.contextPath}/profile/completeUserInfos">

		<h3>Completez votre profil</h3>
		<c:out
			value="Compl�ter votre profil en renseignant les informations demand�es ci-dessous
		nous aidera vous proposer des offres adapt�es � vos attentes. Ces informations ne sont pas obligatoires."></c:out>
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
				<form:options items="${formMaps.jobsMap}" />
			</form:select>
		</div>

		<!-- Ann�es d'exp�riences SI COMPTE PROF A METTRE -->

		<c:if test="${currentUser.type == 'PROFESSOR'}">

			<div class="form-group">
				<form:label path="experience">Exp�rience</form:label>
				<form:select path="experience" class="form-control">
					<form:option value="">--Nombre d'ann�es d'exp�rience--</form:option>
					<form:options items="${formMaps.experiencesMap}" />
				</form:select>
			</div>

		</c:if>


		<legend>Votre emplacement</legend>

		<div class="form-group">
			<form:label path="departement">D�partement</form:label>
			<form:select path="departement" class="form-control">
				<form:option value="">--Choisir son d�partement--</form:option>
				<form:options items="${formMaps.departementsMap}" />
			</form:select>
		</div>

		<div class="form-group">
			<form:label path="city">Ville</form:label>
			<form:select path="city" class="form-control">
				<form:option value="">--Choisir sa Ville--</form:option>
				<form:options items="${formMaps.citiesMap}" />
			</form:select>
		</div>

		<div class="form-group">
			<form:label path="country">Pays</form:label>
			<form:select path="country" class="form-control">
				<form:option value="">--Choisir son pays--</form:option>
				<form:options items="${formMaps.countriesMap}" />
			</form:select>
		</div>

		<legend>A propos de vous?</legend>

		<div class="form-group">

			<div class="row">
				<div class="col-lg-3">
					<form:label path="birthDay">Jour de naissance</form:label>
					<form:select path="birthDay" class="form-control">
						<c:forEach begin="1" end="31" var="val">
							<form:option value="${val}">
								<c:out value="${val}"></c:out>
							</form:option>
						</c:forEach>
					</form:select>
				</div>
				<div class="col-lg-5">
					<form:label path="birthMonth">Mois de naissance</form:label>

					<form:select path="birthMonth" class="form-control">
						<c:forEach begin="1" end="12" var="val">
							<form:option value="${val}">
								<c:out value="${val}"></c:out>
							</form:option>
						</c:forEach>
					</form:select>
				</div>
				<div class="col-lg-4">
					<form:label path="birthYear">Ann�e de naissance</form:label>
					<form:select path="birthYear" class="form-control">
						<c:forEach begin="1930" end="2016" var="val">
							<form:option value="${val}">
								<c:out value="${val}"></c:out>
							</form:option>
						</c:forEach>
					</form:select>
				</div>

			</div>
		</div>

		<div class="form-group">
			<form:label path="phoneNumber">T�l�phone</form:label>
			<form:input path="phoneNumber" class="form-control" />
		</div>

		<div class="form-group">
			<form:label path="aboutMe">D�crivez-vous en quelques mots</form:label>
			<form:textarea path="aboutMe" rows="6" class="form-control" />
		</div>


		<div class="form-group">
			<input type="submit" value="Enregistrer les informations"
				class="btn btn-primary btn-block" />
		</div>
		<br>
		<div class="form-group">
			<a href="${pageContext.request.contextPath}/profile">Passer cette
				étape</a>
		</div>

	</form:form>

</div>