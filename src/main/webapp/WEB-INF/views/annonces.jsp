<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link
	href="<c:url value="/resources/templated-transit/css/style.css" />"
	rel="stylesheet" type="text/css">
<title>UPPT | Students Page</title>
</head>
<body>

	<!--  HEADER INCLUSION  -->
	<div class="header">
		<%@ include file="header.jsp"%>
	</div>

	<!-- Paragraphe -->
	
	<c:if test="${!empty listAnnonces}">
		<p>
			<strong>${fn:length(listAnnonces)}</strong> ANNONCES SUR LE SITE
		</p>
	</c:if>


	<!-- Formulaire de recherche  -->
	<div>
		<%@ include file="adSearchForm.jsp"%>
	</div>

	<!--  Tableau d'annonces des élèves  -->

	<c:if test="${!empty listAnnonces}">

		<table cellpadding="20">
			<!-- Colonne filtre ******** -->

			<tr>
				<td valign="top"><strong>Filtres:</strong></td>




				<!-- Colonne LISTE RESULTATS -->
				<td>
					<table class="tg">
						<c:forEach items="${listAnnonces}" var="item">
							<!-- 1st line -->
							<tr>
								<td><strong>${item.title}</strong></td>
							</tr>
							<!-- 2nd line -->
							<tr>
								<!-- Détails de l'annonce -->
								<td valign="top" width="400">
									<p>${item.description}</p>
								</td>
								<!--  -->
								<td valign="top">
									<p>
										Lieu: ${item.location}<br> Type: ${item.subject}<br>
										Tarif: ${item.costPerHour} €/h<br> Date de publication
									</p>
								</td>
							</tr>
							<!-- 3rd line -->
							<tr>
								<td>${item.subject}</td>
							</tr>
							<!-- 4th line -->
							<tr>
								<td><a
									href="<c:url value='/contact/user/${item.user.id}' />">Contacter
										l'annonceur</a> Sauvergarder l'annonce</td>
							</tr>
						</c:forEach>
					</table>
				</td>

			</tr>

		</table>


	</c:if>



	<!--  FOOTER INCLUSION  -->
	<div class="footer">
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>