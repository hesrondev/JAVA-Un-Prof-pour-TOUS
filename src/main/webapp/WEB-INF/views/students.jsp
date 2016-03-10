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
<title>UPPT | Students Page</title>
</head>
<body>

	<!--  HEADER INCLUSION  -->
	<div class="header">
		<%@ include file="header.jsp"%>
	</div>

	<!--  Tableau des élèves  -->
	<div class="container">

		<h2>Liste des élèves</h2>
		<c:if test="${!empty listStudents}">
			<table class="tg">
				<tr>
					<th>Student ID</th>
					<th>FirstName</th>
					<th>LastName</th>
					<th>email</th>
					<th>password</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				<c:forEach items="${listStudents}" var="std">
					<tr>
						<td>${std.id}</td>
						<td>${std.firstName}</td>
						<td>${std.lastName}</td>
						<td>${std.email}</td>
						<td>${std.password}</td>
						<td><a href="<c:url value='/edit/${std.id}' />">Edit</a></td>
						<td><a href="<c:url value='/remove/${std.id}' />">Delete</a></td>
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