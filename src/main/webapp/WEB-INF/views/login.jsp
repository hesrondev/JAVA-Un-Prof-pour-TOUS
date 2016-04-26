<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" />
<!-- INCLURE UN CSS PERSO ICI -->

<title>UPPT | Connexion</title>
</head>
<body>


	<!--  HEADER INCLUSION  -->


	<div>
		<%@ include file="header.jsp"%>
	</div>


	<!-- Formulaire -->

	<div class="jumbotron">
		<div class="container">
			<div class="row">
				<div class="col-lg-offset-4 col-lg-4">
					<%@ include file="forms/loginForm.jsp"%>
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