<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" />
	
	
<link href="<c:url value="/resources/custom/css/default.css"/>"
	rel="stylesheet" />

<link href="<c:url value="/resources/custom/css/custom-design.css"/>"
	rel="stylesheet" />


<title>UPPT | Elèves</title>
</head>
<body>


	<!--  HEADER INCLUSION  -->


	<div>
		<%@ include file="header.jsp"%>
	</div>


	<div class="container">
		<div class="row">
			<div class="col-lg-offset-1 col-lg-8">
				<div>
					<h3>Liste des élèves</h3>
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

				<br> <br>

			</div>
		</div>
	</div>


	<!--  FOOTER INCLUSION  -->

	<div class="container">
		<footer class="row">
		<div class="col-lg-12">
			<%@ include file="footer.jsp"%>
		</div>
		</footer>
	</div>
</body>
</html>