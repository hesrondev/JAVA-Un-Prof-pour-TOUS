<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="http://fonts.googleapis.com/css?family=Varela"
	rel="stylesheet" />
<link
	href="<c:url value="/resources/templated-plaindisplay/default.css"/>"
	rel="stylesheet" type="text/css" media="all" />
<link
	href="<c:url value="/resources/templated-plaindisplay/fonts.css" />"
	rel="stylesheet" type="text/css" media="all" />
<title>UPPT | Students Page</title>
</head>
<body>
	<div id="bloc_page">

		<!--  HEADER INCLUSION  -->
		<div class="header">
			<%@ include file="header.jsp"%>
		</div>
		<br><br>
		<div class="container">

			<c:if test="${!empty listAnnonces}">
				<h2>
					<strong>${fn:length(listAnnonces)}</strong> Annonce<c:if test="${fn:length(listAnnonces) > 1}">s</c:if> sur le site 
					<c:if test="${!empty subject}">: ${subject}</c:if>
					<c:if test="${!empty location }"> à ${location}</c:if> 
				</h2>
			</c:if>


			<!-- Formulaire de recherche  -->
			<div>
				<%@ include file="adSearchForm.jsp"%>
			</div>

			<!--  Tableau d'annonces des élèves  -->

			<c:if test="${!empty listAnnonces}">

				<table class=".table-wrapper">
					<!-- Colonne filtre ******** -->

					<tr>
						<td valign="top">
							<table>
								<tr>
									<td><strong>Filtres:</strong></td>
								</tr>
								<!-- Par Statut du postant -->
								
								<c:if test="${!empty statusFilters}">
								<tr>
									<td><ul>
											<li>- Statut												
												<ul>
													<c:forEach items="${statusFilters}" var="item">
														<li><a href="${pageContext.request.contextPath}/annonces/status=${item.value}">${item.value} (${item.counter})</a></li>
													</c:forEach>
												</ul>
											</li>
										</ul></td>
								</tr>
								</c:if>
								
								<!-- Par niveau -->
								<c:if test="${!empty levelFilters}">
								<tr>
									<td><ul>
											<li>- Niveau scolaire
												<ul>
													<c:forEach items="${levelFilters}" var="item">
													<li><a href="${pageContext.request.contextPath}/annonces/level=${item.value}">${item.value} (${item.counter})</a></li>
													</c:forEach>
												</ul>
											</li>
										</ul></td>
								</tr>
								</c:if>
								
								<!-- Par matières -->
								<c:if test="${!empty subjectFilters}">
								<tr>
									<td><ul>
											<li>- Matières
												<ul>
													<c:forEach items="${subjectFilters}" var="item">
													<li><a href="${pageContext.request.contextPath}/annonces/subject=${item.value}">${item.value} (${item.counter})</a></li>
													</c:forEach>
												</ul>
											</li>
										</ul></td>
								</tr>
								</c:if>
								

								<!-- Par Lieu -->
								<c:if test="${!empty locationFilters}">
								<tr>
									<td><ul>
											<li>- Lieu
												<ul>
													<c:forEach items="${locationFilters}" var="item">
													<li><a href="${pageContext.request.contextPath}/annonces/location=${item.value}">${item.value} (${item.counter})</a></li>
													</c:forEach>
												</ul>
											</li>
										</ul></td>
								</tr>
								</c:if>
							</table>
						</td>


						<!-- Colonne LISTE RESULTATS -->
						<td>
							<table>
								<c:forEach items="${listAnnonces}" var="item">
									<!-- Element de la liste -->
									<tr>
										<td>
											<table>
												<!-- 1st line -->
												<tr>
													<td>
														<strong><a href="${pageContext.request.contextPath}/annonces/${item.id}">${item.title}</a></strong>
													</td>
												</tr>

												<!-- 2nd line -->
												<tr>
													<!-- Description de l'annonce -->
													<td valign="top" width="450">${item.description}</td>
													<!-- Infos -->
													<td rowspan="2" valign="top">
														<p>
															Lieu: ${item.location}<br>Matière(s):
															${item.subject}<br> Tarif: ${item.costPerHour} €/h<br>Par:
															<a href="${pageContext.request.contextPath}/profile/${item.user.id}">${item.user.firstName} ${item.user.lastName}</a>
															<br>Date de publication
														</p>
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</c:forEach>
							</table>

						</td>

					</tr>

				</table>


			</c:if>
		</div>
		<!--  FOOTER INCLUSION  -->
		<div class="footer">
			<%@ include file="footer.jsp"%>
		</div>

	</div>
</body>
</html>