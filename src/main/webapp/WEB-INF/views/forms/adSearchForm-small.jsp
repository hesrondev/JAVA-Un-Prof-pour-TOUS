

<!-- Formulaire de recherche d'une annonce -->


<div>
	<form:form modelAttribute="adBean" method="GET"
		action="${pageContext.request.contextPath}/annonces/recherche">


		<div class="row">
			<div class="col-lg-2">
				<form:label path="subject">Matière</form:label>
			</div>
			<div class="col-lg-offset-3 col-lg-2">
				<form:label path="location">Lieu</form:label>
			</div>
		</div>

		<div class="row">
			<div class="col-lg-5">
				<form:input id="ad_subject" name="subject" path="subject"
					value="${subject}" placeholder="ex: Maths, Physique, ..."
					class="form-control" />

			</div>
			<div class="col-lg-5">
				<form:input id="ad_location" name="location" value="${location}"
					path="location" placeholder="ex: Paris, Lyon, Marseille, ..."
					class="form-control" />
			</div>
			<div class="col-lg-2">
				<input type="submit" value="Rechercher"
					class="btn btn-warning" />
			</div>
		</div>
	</form:form>
</div>
