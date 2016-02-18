<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<c:url value="/resources/templated-transit/css/style.css" />"
	rel="stylesheet" type="text/css">
<!--<link href="/resources/theme-default/bootstrap/css/bootstrap.css" rel="stylesheet"> -->

<title>UPPT | Accueil</title>
</head>
<body>
	<div id="bloc_page">

		<!--  HEADER INCLUSION  -->
		
		<!--  <div id="header"> -->
			<%@ include file="header.jsp"%>
		<!--  </div> -->
		
		<div id="home_menu">
			<nav> 
				<ul>
					<li><a href="${pageContext.request.contextPath}/home.html">Annonces</a></li>
					<li><a href="${pageContext.request.contextPath}/professors.html">Professeurs</a></li>
					<li><a href="${pageContext.request.contextPath}/students.html">Elèves</a></li>
					<li><a href="${pageContext.request.contextPath}/#.html">Guide</a></li>
				</ul>
			</nav>
		</div>
		
		
		<!--  FOOTER INCLUSION  -->
		<div class="footer">
			<%@ include file="footer.jsp"%>
		</div>

	</div>
</body>
</html>