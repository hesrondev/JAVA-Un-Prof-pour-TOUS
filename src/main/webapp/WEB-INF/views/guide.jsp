<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UPPT | Guide</title>
</head>
<body>

		<!--  HEADER INCLUSION  -->

		<div id="">
			<%@ include file="header.jsp"%>
		</div>

		<div id="home_menu">
			<nav>
			<ul>
				<li><a href="${pageContext.request.contextPath}/home.html">Accueil</a></li>
				<li><a
					href="${pageContext.request.contextPath}/professors.html">Professeurs</a></li>
				<li><a href="${pageContext.request.contextPath}/students.html">Elèves</a></li>
				<li><a href="${pageContext.request.contextPath}/guide.html">Guide</a></li>
			</ul>
			</nav>
		</div>

		<h2>Guide d'utilisation du site...</h2>

		<!--  FOOTER INCLUSION  -->
		<div class="footer">
			<%@ include file="footer.jsp"%>
		</div>
</body>
</html>