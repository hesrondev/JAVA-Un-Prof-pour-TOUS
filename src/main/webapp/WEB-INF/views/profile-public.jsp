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
 
<title>UPPT | ${!empty user ? user.firstName : Profile}</title>
</head>
<body>

	<!--  HEADER INCLUSION  -->
	<div class="header">
		<%@ include file="header.jsp"%>
	</div>

	<!-- Si l'utilisateur est connecté -->
	<br>
	<c:if test="${!empty user}">
		<h2>
			<c:out value="Profile de: ${user.firstName}"></c:out>
		</h2>
	</c:if>
	
		<div id="page">
				<div class="container">
					<div class="row">
						<div class="3u">
							<section id="sidebard2">
								<header>
									<h2>Mon profil</h2>
								</header>
								<ul class="style1">
									<li class="first"><span class="fa fa-check"></span><a href="#">Mes compétences</a></li>
									<li><span class="fa fa-check"></span><a href="#">Mes diplômes</a></li>
									<li><span class="fa fa-check"></span><a href="#">...</a></li>
									<li><span class="fa fa-check"></span><a href="#">...</a></li>
									<li><span class="fa fa-check"></span><a href="#">Mes élèves</a></li>
									<li><span class="fa fa-check"></span><a href="#">Mes contacts</a></li>
								</ul>
								<a href="#" class="button">Modifier</a>
							</section>
						</div>
						
						
						<div class="9u skel-cell-important">
							<section id="content" >
								<header>
									<h2>Mon Planning</h2>
								</header>
								<p> Planning de la semaine ou du mois </p>
								<p> ... <br> </p>
							</section>
						</div>
					</div>

				</div>	
			</div>
	
	<!--  FOOTER INCLUSION  -->
			<div id="copyright" class="container">
				<div class="footer">
					<%@ include file="footer.jsp"%>
				</div>
			</div>
</body>
</html>