<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 

<link href="http://fonts.googleapis.com/css?family=Varela"
	rel="stylesheet" />
<link
	href="<c:url value="/resources/templated-plaindisplay/default.css"/>"
	rel="stylesheet" type="text/css" media="all" />
<link
	href="<c:url value="/resources/templated-plaindisplay/fonts.css" />"
	rel="stylesheet" type="text/css" media="all" />
 -->
 
<title>UPPT | ${!empty currentUser ? currentUser.firstName : Profile}</title>
</head>
<body>

	<!--  HEADER INCLUSION  -->
	<div>
		<%@ include file="../header.jsp"%>
	</div>

	<!-- Si l'utilisateur est connecté -->
	<br>
	<c:if test="${!empty currentUser}">
		<h2>
			<c:out value="Bonjour ${currentUser.firstName}"></c:out>
		</h2>
		<a href="${pageContext.request.contextPath}/logout">Se déconnecter</a>
	</c:if>



	<!--  FOOTER INCLUSION  -->
	<div id="copyright" class="container">
		<div class="footer">
			<%@ include file="../footer.jsp"%>
		</div>
	</div>
</body>
</html>