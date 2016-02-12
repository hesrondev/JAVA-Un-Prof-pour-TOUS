<html>
<head>
	<link href="<c:url value="/resources/templated-transit/css/style.css" />"
	rel="stylesheet" type="text/css">
	<title>UPPT | Professors Page</title>
</head>
<body>

<!--  HEADER INCLUSION  -->
		<div class="header">
			<%@ include file="header.jsp"%>
		</div>

<br>
	<hr>
	<h2>Liste des professeurs</h2>
	<c:if test="${!empty listProfessors}">
		<table class="tg">
			<tr>
				<th width="80">Professor ID</th>
				<th width="120">FirstName</th>
				<th width="120">LastName</th>
				<th width="120">email</th>
				<th width="120">password</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
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
	<!--  FOOTER INCLUSION  -->
		<div class="footer">
			<%@ include file="footer.jsp"%>
		</div>
</body>
</html>