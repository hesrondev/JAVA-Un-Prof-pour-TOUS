<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="keywords" content="" />
<meta name="description" content="" />

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
 
	
<title>UPPT | <c:if test="${!empty annonce}">${annonce.title}</c:if></title>

</head>

<body>
	<!--  HEADER INCLUSION  -->
	<div class="header">
		<%@ include file="header.jsp"%>
	</div>

<div>

	<!-- En tête de l'annonce -->
	<br><br>
	<div>
		<c:if test="${!empty annonce}">
		
		<div>
			<h2>${annonce.title}</h2>
			<p>Par <a href="${pageContext.request.contextPath}/profile/${item.user.id}">${annonce.user.lastName} ${annonce.user.firstName}</a> &#8226 ${annonce.location} &#8226 ${annonce.toStringDate()}</p>
		</div>
		
		<!--  Contact de l'annonceur -->
		<div>
			<c:set var="listSize" value="${fn:length(annonce.applications)}"></c:set>
			<c:choose>
				<c:when test="${listSize == 0}">
					<h3>Candidatures</h3>
					<p>Soyez le premier à candidater pour cette annonce</p>
				</c:when>
				<c:otherwise>
					<h3>${listSize} Candidature<c:if test="${listSize > 1}">s</c:if></h3>
					<p>Comparez vous aux autres candidats</p>				
				</c:otherwise>			
			</c:choose>
		
			<p><strong><a href="${pageContext.request.contextPath}/annonces/candidater/${annonce.id}">Candidater à l'annonce</a></strong></p>
		</div>
		
		<!--  Suite des détails de l'annonce -->
		<div>
			<h3>Informations sur l'annonce</h3>
			<hr>
			
			<table>
				<tr>
					<th>Matière</th>
					<th>Rémunération de base</th>
					<th>Niveau</th>
				</tr>
				<tr>
					<td>${annonce.subject}</td>
					<td>${annonce.costPerHour} €/heure</td>
					<td>${annonce.level}</td>
				</tr>
			</table>
			<hr><br>
			
			<h3>Description</h3>
			<p>${annonce.description}</p>
			<br>
			
			<!-- Si contact disponible -->
			<c:if test="${annonce.showPhoneNumber}">
				<h3>Contact</h3>
				<p>***Numéro de téléphone***</p>
			</c:if>
			
			
			<br><br>
			<p><strong><a href="${pageContext.request.contextPath}/annonces/candidater/${annonce.id}">Candidater</a></strong></p>
			
		</div>
		
		</c:if>	
	</div>
	
	<!--  A ranger à droite de l'écran -->
	<hr>
	<div>
		<h3>Offres similaires</h3>
		<br>
		<ul>
			<c:forEach items="${annonces}" var="item">
				<li>
					<strong><a href="${pageContext.request.contextPath}/annonces/${item.id}">${item.title}</a></strong><br>
					${item.location} &#8226 ${annonce.toStringDate()}
				</li>	
			</c:forEach>
	
		</ul>
		
		<!-- Recherche les annonces similaires -->
		<p><strong><a href="${pageContext.request.contextPath}/annonces/recherche?subject=${annonce.subject}&location=${annonce.location}">Voir les offres similaires</a></strong></p>
		
	</div>
	<br><br>

</div>

	<!--  FOOTER INCLUSION  -->
	<div id="copyright" class="container">
		<div class="footer">
			<%@ include file="footer.jsp"%>
		</div>
	</div>
</body>
</html>