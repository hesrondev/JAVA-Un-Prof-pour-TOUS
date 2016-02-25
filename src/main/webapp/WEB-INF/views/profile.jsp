<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!--
<link
	href="<c:url value="/resources/templated-transit/css/style.css" />"
	rel="stylesheet" type="text/css"> -->
<title>UPPT | ${!empty user ? user.firstName : Profile}</title> 
</head>
<body>

	<!--  HEADER INCLUSION  -->
	<div id="header">
		<%@ include file="header.jsp"%>
	</div>

	<!-- Si l'utilisateur est connecté -->

	<c:if test="${!empty user}">
		<h2>
			<c:out value="Bonjour ${user.firstName}"></c:out>
		</h2>
	</c:if>
	
	<!--  FOOTER INCLUSION  -->
	<div id="footer">
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>