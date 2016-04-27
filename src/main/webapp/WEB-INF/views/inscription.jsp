<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" />
	
<link href="<c:url value="/resources/custom/css/default.css"/>"
	rel="stylesheet" />

<link href="<c:url value="/resources/custom/css/custom-design.css"/>"
	rel="stylesheet" />

<title>Page d'inscription</title>
</head>
<body>

	<!--  HEADER INCLUSION  -->


	<div>
		<%@ include file="header.jsp"%>
	</div>
	
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div>
					<%@ include file="forms/inscriptionForm.jsp"%>
				</div>
			</div>
		</div>
	</div>


	<!--  FOOTER INCLUSION  -->
	<br>
	<br>
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