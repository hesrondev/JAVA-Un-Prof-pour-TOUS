<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="http://fonts.googleapis.com/css?family=Varela"
	rel="stylesheet" />
<link
	href="<c:url value="/resources/templated-plaindisplay/default.css"/>"
	rel="stylesheet" type="text/css" media="all" />
<link
	href="<c:url value="/resources/templated-plaindisplay/fonts.css" />"
	rel="stylesheet" type="text/css" media="all" />
<title>UPPT | Status de la page</title>
</head>
<body>
	<!-- Déclaration des variables -->

	<!--  HEADER INCLUSION  -->
	<div class="header">
		<%@ include file="header.jsp"%>
	</div>

	<br><br>
	
	<div>
		<h1>${status}</h1>	
	</div>
	
	<br><br>


	<!--  FOOTER INCLUSION  -->
	<div id="copyright" class="container">
		<div class="footer">
			<%@ include file="footer.jsp"%>
		</div>
	</div>
</body>
</html>