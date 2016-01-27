<html>
<head>
<link href="<c:url value="/resources/theme-default/css/table.css" />"
	rel="stylesheet" type="text/css">
<title>UPPT | Students Page</title>
</head>
<body>

	<!--  HEADER INCLUSION  -->

	<%@ include file="header.jsp"%>


	<h2>Liste des élèves</h2>
	<c:if test="${!empty listStudents}">
		<table class="tg">
			<tr>
				<th width="80">Student ID</th>
				<th width="120">FirstName</th>
				<th width="120">LastName</th>
				<th width="120">email</th>
				<th width="120">password</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
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


	<!--  FOOTER INCLUSION  -->

	<%@ include file="footer.jsp"%>
	
	
</body>
</html>
