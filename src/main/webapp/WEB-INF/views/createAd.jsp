<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" />
<!-- INCLURE UN CSS PERSO ICI -->

<title>UPPT | Publier une annonce</title>
</head>
<body>


	<!--  HEADER INCLUSION  -->


	<div class="container">
		<header class="row">
		<div class="col-lg-12">
			<%@ include file="header.jsp"%>
		</div>
		</header>
	</div>

	<hr>
	<div class="container">

		<!-- Bloc formulaire d'annonce  -->
		<!--  On passe l'ID de l'utilisateur en paramètre -->

		<div class="row">
			<div class="col-lg-6">

				<h3>Publication d'une annonce</h3>
				<c:out
					value="Veuillez renseigner dans le formulaire ci-dessous les informations relatives à votre annonce."></c:out>


				<!--  Formulaire -->

				<form:form modelAttribute="adBean" method="POST"
					action="${pageContext.request.contextPath}/annonces/create">

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
					<legend>Informations générales</legend>

					<div class="form-group">
						<div class="form-group">
							<form:label path="title">Titre de l'annonce</form:label>

							<form:input id="ad_title" name="title" path="title"
								placeholder="Saisir le titre de l'annonce" class="form-control" />
						</div>

						<!-- LIEU -->

						<div class="form-group">
							<form:label path="location">Lieu</form:label>
							<form:select path="location" class="form-control">
								<form:option value="paris">Paris</form:option>
								<form:option value="massy">Massy</form:option>
								<form:option value="versailles">Versailles</form:option>

								<!-- MAP KEY-VALUE A PARCOURIR !!! -->

							</form:select>
						</div>
					</div>

					<!-- Spécifications de la matière -->
					<br>
					<legend>A propos de la matière</legend>

					<div class="form-group">

						<div class="form-group">
							<form:label path="subject">Matière</form:label>
							<form:select path="subject" class="form-control">
								<form:option value="litterature">Français - Littérature</form:option>
								<form:option value="SES">Sciences économiques et sociales</form:option>

								<!-- MAP KEY-VALUE A PARCOURIR !!! -->
							</form:select>
						</div>


						<div class="form-group">
							<form:label path="level">Niveau scolaire</form:label>
							<form:select path="level" class="form-control">
								<form:option value="primaire">Primaire</form:option>
								<form:option value="college">Collège</form:option>
								<form:option value="lycee">Lycée</form:option>
								<form:option value="universite">Université</form:option>
							</form:select>
						</div>

						<div class="form-group">
							<form:label path="costPerHour">Tarif</form:label>

							<div class="input-group">
								<form:input id="ad_costPerHour" name="costPerHour"
									path="costPerHour" class="form-control"
									style="text-align:right" />
								<span class="input-group-addon">€/h</span>
							</div>
						</div>

					</div>

					<br>
					<legend>Détails de votre annonce</legend>

					<div class="form-group">
						<form:textarea id="ad_description" name="description"
							path="description" placeholder="Détails de l'annonce" rows="6"
							class="form-control" />
					</div>

					<div class="form-group">

						<form:label path="showPhoneNumber">
							<form:checkbox id="ad_showPhone" name="showPhone"
								path="showPhoneNumber" />
							<c:out value="Afficher le numéro de téléphone?"></c:out>
						</form:label>

					</div>

					<div class="form-group">
						<input type="submit" value="Publier l'annonce"
							class="btn btn-default pull-right input-lg" />
					</div>

				</form:form>

			</div>
		</div>
	</div>
	<br>
	<br>

	<!--  FOOTER INCLUSION  -->

	<div class="jumbotron">
		<div class="container">
			<footer class="row">
			<div class="col-lg-12">
				<%@ include file="footer.jsp"%>
			</div>
			</footer>
		</div>
	</div>




</body>
</html>