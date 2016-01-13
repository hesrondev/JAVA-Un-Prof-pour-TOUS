<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UPPT | ${!empty user ? user.firstName : Profile}</title>
</head>
<body>

	<%@ include file="header.jsp"%>

	<!-- Si l'utilisateur est connecté -->
	
	<c:if test="${!empty user}">
		<h2>
			<c:out value="Bonjour ${user.firstName}"></c:out>
		</h2>
	</c:if>
</body>
</html>