<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" />
	
	
<!-- INCLURE UN CSS PERSO ICI -->

<link href="<c:url value="/resources/custom/css/default.css"/>"
	rel="stylesheet" />

<link href="<c:url value="/resources/custom/css/custom-design.css"/>"
	rel="stylesheet" />


<title>UPPT | Ajouter un cours</title>
</head>
<body>


	<!--  HEADER INCLUSION  -->


	<div class="">
		<%@ include file="../header.jsp"%>
	</div>

	<!-- Formulaire -->

	<div class="container">
		<div class="row">
			<div class="col-lg-offset-3 col-lg-6">
				<%@ include file="../forms/courseEvent-form.jsp"%>
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
			<%@ include file="../footer.jsp"%>
		</div>
		</footer>
	</div>
	
			<!-- INCLUSION JS -->

		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>


		<!-- Latest compiled and minified JavaScript -->
		<script
			src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
	
</body>
</html>