

<!-- Formulaire de recherche d'une annonce -->


<div>
		<form:form modelAttribute="adBean" method="GET"
			action="${pageContext.request.contextPath}/annonces/recherche"
			class="well">


			<div class="row">
				<div class="col-lg-2">
					<form:label path="subject">Matière</form:label>
				</div>
				<div class="col-lg-offset-4 col-lg-2">
					<form:label path="location">Lieu</form:label>
				</div>
			</div>


			<div class="row">
				<div class="col-lg-6">
					<form:input id="ad_subject" name="subject" path="subject"
						value="${subject}" placeholder="ex: Maths, Physique, ..."
						class="form-control input-lg" />

				</div>
				<div class="col-lg-4">
					<form:input id="ad_location" name="location" value="${location}"
						path="location" placeholder="ex: Paris, Lyon, Marseille, ..."
						class="form-control input-lg" />
				</div>
				<div class="col-lg-2">
					<input type="submit" value="Rechercher"
						class="btn btn-primary btn-lg" />
				</div>
			</div>
		</form:form>
</div>
