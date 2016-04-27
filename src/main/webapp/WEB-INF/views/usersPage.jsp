<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" />


<link href="<c:url value="/resources/custom/css/default.css"/>"
	rel="stylesheet" />

<link href="<c:url value="/resources/custom/css/custom-design.css"/>"
	rel="stylesheet" />


<title>UPPT | Elèves</title>
</head>
<body>


	<!--  HEADER INCLUSION  -->


	<div>
		<%@ include file="header.jsp"%>
	</div>

	<br>

	<div class="container">
		<div class="row">
			<div class="col-lg-offset-3 col-lg-6">
				<div class="panel panel-default">
					<ul class="list-group">
						<c:forEach items="${listUsers}" var="item">

							<li class="list-group-item">
								<!-- DISPOSITION -->
								<table class="table-user-infos">
									<tr>
										<!-- PHOTO -->
										<td><img class="img-thumbnail" alt=""
											src="resources/img/default-picture-s90.png"></td>

										<!-- INFOS -->
										<td>
											<h5>
												<a href="${pageContext.request.contextPath}/profile/${item.firstName}.${item.lastName}/${item.id}">${item.firstName}&nbsp;${item.lastName}</a>
											</h5>
											<p>
												${item.type}
												<c:if test="${!empty item.profession}">
												&nbsp;&bull;&nbsp;${item.profession}
												</c:if>
												<br>
												<c:if test="${!empty item.city}">${item.city}</c:if>
												<c:if test="${!empty item.country}">&nbsp;&bull;&nbsp;${item.country}<br>
												</c:if>
												<!-- Inclusion du bouton approprié -->
												<c:set var="item" value="${item}"></c:set>
												<%@ include file="forms/generic-friendAction-button.jsp"%>
											</p>



										</td>
									</tr>
								</table>


							</li>

						</c:forEach>
					</ul>

					<!-- Si vide -->
					<c:if test="${empty listUsers}">
						<div class="panel-body">
							<h4 align="center">Aucun utilisateur trouvé!</h4>
						</div>
					</c:if>
				</div>


			</div>
		</div>
	</div>


	<!--  FOOTER INCLUSION  -->
	<hr>
	<div class="container">
		<footer class="row">
		<div class="col-lg-12">
			<%@ include file="footer.jsp"%>
		</div>
		</footer>
	</div>
</body>
</html>