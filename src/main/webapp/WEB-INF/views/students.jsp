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
 
<title>UPPT | Students Page</title>
</head>
<body>

	<!--  HEADER INCLUSION  -->
	<div class="header">
		<%@ include file="header.jsp"%>
	</div>

	<div>
		<%@ include file="forms/userSearchForm.jsp"%>
	</div>

	<hr>

	<div>
		<h2>Liste des élèves</h2>
		<c:if test="${!empty listStudents}">
			<table>
				<c:forEach items="${listStudents}" var="item">
					<tr>
						<td>${item.id}</td>
						<td>${item.firstName}</td>
						<td>${item.lastName}</td>
						<td>${item.email}</td>
						<td>${item.password}</td>
						<td><a href="<c:url value='/edit/${item.id}' />">Edit</a></td>
						<td><a href="<c:url value='/remove/${item.id}' />">Delete</a></td>
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