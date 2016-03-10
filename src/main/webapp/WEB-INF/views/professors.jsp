<html>
<head>
<link href="http://fonts.googleapis.com/css?family=Varela"
	rel="stylesheet" />
<link
	href="<c:url value="/resources/templated-plaindisplay/default.css"/>"
	rel="stylesheet" type="text/css" media="all" />
<link
	href="<c:url value="/resources/templated-plaindisplay/fonts.css" />"
	rel="stylesheet" type="text/css" media="all" />
<title>UPPT | Professors Page</title>
</head>
<body>

	<!--  HEADER INCLUSION  -->
	<div class="header">
		<%@ include file="header.jsp"%>
	</div>

	<div class="container">

		<h2>Liste des professeurs</h2>
		<c:if test="${!empty listProfessors}">
			<table class="tg">
				<tr>
					<th>Professor ID</th>
					<th>FirstName</th>
					<th>LastName</th>
					<th>email</th>
					<th>password</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				<c:forEach items="${listProfessors}" var="prof">
					<tr>
						<td>${prof.id}</td>
						<td>${prof.firstName}</td>
						<td>${prof.lastName}</td>
						<td>${prof.email}</td>
						<td>${prof.password}</td>
						<td><a href="<c:url value='/edit/${prof.id}' />">Edit</a></td>
						<td><a href="<c:url value='/remove/${prof.id}' />">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>

	<!--  FOOTER INCLUSION  -->
	<div class="footer">
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>