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
<title>Page d'inscription</title>
</head>
<body>

<!--  HEADER INCLUSION  -->
		
			<%@ include file="header.jsp"%>
	
	<div id="featured">	
	<div class="container">
		<h2>Inscription</h2>
		<p>
			Bienvenue sur Un Prof Pour Tous.</br> Veuillez remplir le formulaire
			ci-dessous pour vous inscire : </br>
		</p>

		<%@ include file="forms/inscriptionForm.jsp"%>
	</div>
	</div>
	<!--  FOOTER INCLUSION  -->
	<div id="copyright" class="container">
		<div class="footer">
			<%@ include file="footer.jsp"%>
		</div>
	</div>
</body>
</html>