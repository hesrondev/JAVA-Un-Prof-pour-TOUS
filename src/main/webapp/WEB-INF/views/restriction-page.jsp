<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	
	<!--  HEADER INCLUSION  -->

		<div>
			<%@ include file="header.jsp"%>
		</div>
		
	<div>		

		<div align="center">
			<h2>Vous devez être connecté pour ${statusMessage}!</h2>
			<p>Choisissez une action pour continuer.</p>

			<!-- Boutons -->
			<div>
				<div>
					<a href="${pageContext.request.contextPath}/inscription">S'inscrire</a>
				</div>
				<div>
					<a href="${pageContext.request.contextPath}/login">Se connecter</a>
				</div>
			</div>
		</div>

	</div>
	
	<!--  FOOTER INCLUSION  -->

		<div>
			<%@ include file="footer.jsp"%>
		</div>

</body>
</html>