<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="http://fonts.googleapis.com/css?family=Varela"
	rel="stylesheet" />
<link
	href="<c:url value="/resources/templated-plaindisplay/default.css"/>"
	rel="stylesheet" type="text/css" media="all" />
<link
	href="<c:url value="/resources/templated-plaindisplay/fonts.css" />"
	rel="stylesheet" type="text/css" media="all" />
<title>UPPT | Publier une annonce</title>
</head>
<body>

	<!--  HEADER INCLUSION  -->

	<div id="">
		<%@ include file="header.jsp"%>
	</div>

	<div class="container">

		<!-- Bloc formulaire d'annonce  -->
		<!--  On passe l'ID de l'utilisateur en paramètre -->
		<div>
			<br>
			<h3>Indiquez les informations de l'annonce à publier</h3>

			<!--  Condition pour user ID, si vide alors userID = 0  -->

			<c:set var="userID" value="${!empty user ? user.id : 0}" />

			<!--  Formulaire -->

			<form:form modelAttribute="adBean" method="POST"
				action="${pageContext.request.contextPath}/annonces/create/${userID}">

				<table class="form">
					<tr>
						<td><c:out value="${formStatus}"></c:out></td>
					</tr>
					<tr>
						<td>
							<br>
							<h3>Informations générales</h3>
							<hr><br>
						</td>
					</tr>
					<tr>
						<td><form:label path="title">Titre de l'annonce</form:label></td>
					</tr>
					<tr>
						<td><form:input id="ad_title" name="title" path="title"
								placeholder="Saisir le titre de l'annonce" /></td>
					</tr>
					
					
					<!-- LIEU -->
					<tr>
						<td><form:label path="location">Lieu</form:label></td>
					</tr>
					<tr>
						<td>
							<form:select path="location">
								<form:option value="paris">Paris</form:option>
								<form:option value="massy">Massy</form:option>
								<form:option value="versailles">Versailles</form:option>
								
								<!-- MAP KEY-VALUE A PARCOURIR !!! -->
								
							</form:select>
						</td>
					</tr>
					
					
					<!-- Spécifications de la matière -->
					
					<tr>
						<td>
							<br>
							<h3> A propos de la matière</h3>
							<hr><br>
						</td>
					</tr>
					<tr>
						<td><form:label path="subject">Matière</form:label></td>
					</tr>

					<tr>
						<td>
							<form:select path="subject">
								<form:option value="litterature">Français - Littérature</form:option>
								<form:option value="SES">Sciences économiques et sociales</form:option>
								
								<!-- MAP KEY-VALUE A PARCOURIR !!! -->
								
							</form:select>
						</td>
					</tr>

					<tr>
						<td><form:label path="level">Niveau scolaire</form:label></td>
					</tr>

					<tr>
						<td>
							<form:select path="level">
								<form:option value="primaire">Primaire</form:option>
								<form:option value="college">Collège</form:option>
								<form:option value="lycee">Lycée</form:option>
								<form:option value="universite">Université</form:option>
							</form:select>
						</td>
					</tr>

					<tr>
						<td><form:label path="costPerHour">Tarif (€/h)</form:label></td>
					</tr>

					<tr>
						<td><form:input id="ad_costPerHour" name="costPerHour"
								path="costPerHour" placeholder="ex: Maths" /></td>
					</tr>
					

					<tr>
						<td>
							<br>
							<h3>Détails votre annonce</h3>
							<hr>
						</td>
					</tr>
					<tr>
						<td><form:textarea id="ad_description" name="description"
								path="description" placeholder="Détails de l'annonce" /></td>
					</tr>

					<tr>
						<td><input type="submit" value="Publier" /></td>
					</tr>

				</table>

			</form:form>

		</div>

	</div>

	<!--  FOOTER INCLUSION  -->
	<div class="footer">
		<%@ include file="footer.jsp"%>
	</div>

</body>
</html>