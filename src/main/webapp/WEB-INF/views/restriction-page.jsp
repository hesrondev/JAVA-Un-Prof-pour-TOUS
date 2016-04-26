<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" />
<!-- INCLURE UN CSS PERSO ICI -->


<title>UPPT | Restriction</title>
</head>
<body>


	<!--  HEADER INCLUSION  -->


	<div>
		<%@ include file="header.jsp"%>
	</div>

		
	<div class="container">
		<div class="row">
			<div class="col-lg-12" align="center">
				<h3>Vous devez être connecté pour ${statusMessage}!</h3>
				<p>Choisissez une action pour continuer.</p>
					<div>
						<a href="${pageContext.request.contextPath}/inscription">S'inscrire</a>
					</div>
					<div>
						<a href="${pageContext.request.contextPath}/login">Se
							connecter</a>
					</div>
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

</body>
</html>