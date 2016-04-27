
<!-- Formulaire pour l'ajout d'un cours au planning -->



<div>
	<form:form modelAttribute="courseEventBean" method="POST"
		action="${pageContext.request.contextPath}/profile/planning/add-event">

		<h3 class="page-header">Ajouter un cours à votre planning</h3>
		<p>
			<c:out
				value="Renseignez les informations concernant le cours puis enregistrer les modifications."></c:out>
			<br> Tous les champs sont obligatoires! <br>
		</p>

		<c:if test="${!empty errorStatus}">
			<div class="alert span5 alert-danger">
				<h3>Saisie invalide!</h3>
				<c:out value="${errorStatus}" />
			</div>
		</c:if>
		<br>


		<div class="form-group">
			<form:label path="title">Nom du cours</form:label>
			<form:input path="title" class="form-control" />
		</div>

		<div class="form-group">
			<form:label path="studentName">Nom de l'élève (ou du professeur)</form:label>
			<form:input path="studentName" class="form-control" />
		</div>

		<div class="form-group">
			<form:label path="city">Ville</form:label>
			<form:input path="city" class="form-control" />
		</div>

		<legend>Début du cours</legend>

		<div class="form-group">

			<div class="row">
				<div class="col-lg-2">
					<form:label path="startDay">Jour</form:label>
					<form:select path="startDay" class="form-control">
						<c:forEach begin="1" end="31" var="val">
							<form:option value="${val}">
								<c:out value="${val}"></c:out>
							</form:option>
						</c:forEach>
					</form:select>
				</div>
				<div class="col-lg-3">
					<form:label path="startMonth">Mois</form:label>
					<form:select path="startMonth" class="form-control">
						<form:options items="${formMaps.months}" />
					</form:select>
				</div>
				<div class="col-lg-3">
					<form:label path="startYear">Année</form:label>
					<form:select path="startYear" class="form-control">
						<c:forEach begin="2016" end="2030" var="val">
							<form:option value="${val}">
								<c:out value="${val}"></c:out>
							</form:option>
						</c:forEach>
					</form:select>
				</div>
				<!-- Heure -->
				<div class="col-lg-2">
					<form:label path="startHour">Heure</form:label>
					<form:select path="startHour" class="form-control">
						<c:forEach begin="1" end="24" var="val">
							<form:option value="${val}">
								<c:out value="${val}"></c:out>
							</form:option>
						</c:forEach>
					</form:select>
				</div>
				<!-- Minutes -->
				<div class="col-lg-2">
					<form:label path="startMinutes">Minutes</form:label>
					<form:select path="startMinutes" class="form-control">
						<c:forEach begin="0" end="59" var="val">
							<form:option value="${val}">
								<c:out value="${val}"></c:out>
							</form:option>
						</c:forEach>
					</form:select>
				</div>
			</div>
		</div>
		<!-- FIN startDATE -->

		<legend>Fin du cours</legend>

		<!-- End Date -->
		<div class="form-group">

			<div class="row">
				<div class="col-lg-2">
					<form:label path="endDay">Jour</form:label>
					<form:select path="endDay" class="form-control">
						<c:forEach begin="1" end="31" var="val">
							<form:option value="${val}">
								<c:out value="${val}"></c:out>
							</form:option>
						</c:forEach>
					</form:select>
				</div>
				<div class="col-lg-3">
					<form:label path="endMonth">Mois</form:label>

					<form:select path="endMonth" class="form-control">
						<form:options items="${formMaps.months}" />
					</form:select>
				</div>
				<div class="col-lg-3">
					<form:label path="endYear">Année</form:label>
					<form:select path="endYear" class="form-control">
						<c:forEach begin="2016" end="2030" var="val">
							<form:option value="${val}">
								<c:out value="${val}"></c:out>
							</form:option>
						</c:forEach>
					</form:select>
				</div>
				<!-- Heure -->
				<div class="col-lg-2">
					<form:label path="endHour">Heure</form:label>
					<form:select path="endHour" class="form-control">
						<c:forEach begin="1" end="24" var="val">
							<form:option value="${val}">
								<c:out value="${val}"></c:out>
							</form:option>
						</c:forEach>
					</form:select>
				</div>
				<!-- Minutes -->
				<div class="col-lg-2">
					<form:label path="endMinutes">Minutes</form:label>
					<form:select path="endMinutes" class="form-control">
						<c:forEach begin="0" end="59" var="val">
							<form:option value="${val}">
								<c:out value="${val}"></c:out>
							</form:option>
						</c:forEach>
					</form:select>
				</div>
			</div>
		</div>


		<div class="form-group">
			<form:label path="comment">Un commentaire sur le cours?</form:label>
			<form:textarea path="comment" rows="6" class="form-control" />
		</div>


		<div class="form-group">
			<input type="submit" value="Ajouter le cours"
				class="btn btn-primary btn-block" />
		</div>

	</form:form>

</div>