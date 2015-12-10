<html>
<head>
<title>UPPT | Professor Page</title>
<style type="text/css">

body {
	font-family: Helvetica, sans-serif;
	font-size: 14px;
	word-break: normal;
	background-color: #ffff;
}
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>
</head>
<body>

<h2>Ajouter un professeur</h2>

<%@ include file="inscriptionForm.jsp" %>

<br>
<hr>
	<h2>Liste de professeurs</h2>
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
</body>
</html>
