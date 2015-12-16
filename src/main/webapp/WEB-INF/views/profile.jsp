<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UPPT | Profile</title>
</head>
<body>
	<c:if test="${!empty loginStatus.firstName}">
		<h2>
			<c:out value="Bonjour ${loginStatus}"></c:out>
		</h2>
	</c:if>
</body>
</html>