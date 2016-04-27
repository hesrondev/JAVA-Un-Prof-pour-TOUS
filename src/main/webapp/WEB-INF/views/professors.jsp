<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" />
<!-- INCLURE UN CSS PERSO ICI -->


<title>UPPT | Professeurs</title>
</head>
<body>


	<!--  HEADER INCLUSION  -->

	<div>
		<%@ include file="header.jsp"%>
	</div>


	<div class="container">
		<div class="row">
			<div class="col-lg-offset-1 col-lg-8">
				<div>
					<h3>Liste des professeurs</h3>
					<c:if test="${!empty listProfessors}">
						<table>
							<c:forEach items="${listProfessors}" var="prof">
								<tr>
									<td>${prof.id}</td>
									<td>${prof.firstName}</td>
									<td>${prof.lastName}</td>
									<td>${prof.email}</td>
									<td>${prof.password}</td>
									<td><a href="<c:url value='/edit/${prof.id}' />">Edit</a></td>
									<td><a href="<c:url value='/remove/${prof.id}' />">Delete</a></td>
								</tr>
							</c:forEach>
						</table>
					</c:if>
				</div>

				<br> <br>

			</div>
		</div>
	</div>

	<br>
	<br>
	<hr>

	<!--  FOOTER INCLUSION  -->

	<div class="container">
		<footer class="row">
		<div class="col-lg-12">
			<%@ include file="footer.jsp"%>
		</div>
		</footer>
	</div>
	<!-- INCLUSION JS -->

		<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
		<script src="/resources/js/jquery.js"></script>
		
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>

		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet"
			href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

		<!-- Optional theme -->
		<link rel="stylesheet"
			href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

		<!-- Latest compiled and minified JavaScript -->
		<script
			src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
	
</body>
</html>