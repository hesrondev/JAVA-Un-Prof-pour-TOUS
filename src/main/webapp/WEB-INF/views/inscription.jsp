<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<c:url value="/resources/templated-transit/css/style.css" />"
	rel="stylesheet" type="text/css">
<title>Page d'inscription</title>
</head>
<body>

<!--  HEADER INCLUSION  -->
		<div class="header">
			<%@ include file="header.jsp"%>
		</div>
		
	<div>
		<h2>Inscription</h2>
		<p>
			Bienvenue sur Un Prof Pour Tous.</br> Veuillez remplir le formulaire
			ci-dessous pour vous inscire : </br>
		</p>

		<%@ include file="inscriptionForm.jsp"%>
	</div>
	<!--  FOOTER INCLUSION  -->
		<div class="footer">
			<%@ include file="footer.jsp"%>
		</div>
</body>
</html>