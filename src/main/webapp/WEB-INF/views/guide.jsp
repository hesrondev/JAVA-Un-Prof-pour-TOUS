<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<link href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" />
	
<link href="<c:url value="/resources/custom/css/default.css"/>"
	rel="stylesheet" />

<link href="<c:url value="/resources/custom/css/custom-design.css"/>"
	rel="stylesheet" />

<title>UPPT | Guide</title>


</head>
<body>

	<!--  HEADER INCLUSION  -->


	<div>
		<%@ include file="header.jsp"%>
	</div>

	<div class="jumbotron">
		<div class="container" align="center">
			<h3>Bienvenue sur Un Prof Pour Tous</h3>
			<p>Le site de référence pour trouver votre prochain cours!</p>
			<p>
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