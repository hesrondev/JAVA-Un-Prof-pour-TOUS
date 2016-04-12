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
		
		<div class="container">

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

				<table class=".table-wrapper">
					<!-- Colonne filtre ******** -->

					<tr>
						<td valign="top">
							<table>
								<tr>
									<td><strong>Filtres:</strong></td>
								</tr>
								<!-- Par Statut du postant -->
								<tr>
									<td><ul>
											<li>- Statut
												<ul>
													<li><a href="${pageContext.request.contextPath}/annonces/status=PROFESSOR">Professeurs (*)</a></li>
													<li><a href="${pageContext.request.contextPath}/annonces/status=STUDENT">Elèves (*)</a></li>
												</ul>
											</li>
										</ul></td>
								</tr>
								
								<!-- Par niveau -->
								<tr>
									<td><ul>
											<li>- Niveau scolaire
												<ul>
													<li><a href="${pageContext.request.contextPath}/annonces/level=primaire">Primaire (*)</a></li>
													<li><a href="${pageContext.request.contextPath}/annonces/level=college">Collège (*)</a></li>
													<li><a href="${pageContext.request.contextPath}/annonces/level=lycee">Lycée (*)</a></li>
													<li><a href="${pageContext.request.contextPath}/annonces/level=universite">Université (*)</a></li>
												</ul>
											</li>
										</ul></td>
								</tr>
								
								<!-- Par matières -->
								<tr>
									<td><ul>
											<li>- Matières
												<ul>
													<li><a href="${pageContext.request.contextPath}/annonces/subject=SCIENCES">Sciences (*)</a></li>
												</ul>
											</li>
										</ul></td>
								</tr>
								

								<!-- Par Lieu -->
								<tr>
									<td><ul>
											<li>- Lieu
												<ul>
													<li><a href="${pageContext.request.contextPath}/annonces/location=paris">Paris (*)</a></li>
												</ul>
											</li>
										</ul></td>
								</tr>
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
													<td><strong><a
															href="${pageContext.request.contextPath}/annonces/${item.id}">${item.title}</a></strong></td>
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
															${item.user.id}<br>Date de publication
														</p>
													</td>
												</tr>

												<!-- 3rd line -->
												<tr>
													<td>Sauvergarder l'annonce</td>
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