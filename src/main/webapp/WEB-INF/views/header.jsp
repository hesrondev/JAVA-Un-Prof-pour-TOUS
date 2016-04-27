<!-- Header !!! -->



<!--  LOGO -->

<div class="page-header page-header-header">
	<div class="container">
		<header class="row">

			<div class="col-lg-2" style="margin-bottom:5px">
				<a href="${pageContext.request.contextPath}/home.html"> <img
					class="img-thumbnail" src="${pageContext.request.contextPath}/resources/img/logo.png">
				</a>
			</div>


			<!-- MENU 1 -->
			<c:choose>
				<c:when test="${!empty currentUser}">
					<nav class="col-lg-6 nav-header">
						<ul class="nav nav-pills">

							<!-- Nos annonces -->
							<li><a
								href="${pageContext.request.contextPath}/annonces.html">Annonces</a></li>

							<!-- Nos professeurs -->
							<li><a
								href="${pageContext.request.contextPath}/professors.html">Professeurs</a></li>

							<!-- Nos élèves -->
							<li><a
								href="${pageContext.request.contextPath}/students.html">Elèves</a></li>

							<!-- Le guide du site -->
							<li><a href="${pageContext.request.contextPath}/guide.html">Le
									Guide UPPT</a></li>
						</ul>
					</nav>
					
					<div class="col-lg-3">
						<%@ include file="forms/userSearchForm.jsp"%>
					</div>

					<!-- ICONE PROFIL HAUT DROITE  -->

					<div class="col-lg-1">
						<div class="dropdown pull-right">
							<div class="dropdown-toggle" data-toggle="dropdown">
								<img class="img-thumbnail"
									src="${pageContext.request.contextPath}/resources/img/default-picture-s22.png">&nbsp;<span
									class="caret"></span>
							</div>

							<ul class="dropdown-menu">
								<li><a
									href="${pageContext.request.contextPath}/profile.html">Mon
										profile</a></li>
								<li><a href="${pageContext.request.contextPath}/#.html">Mon
										planning</a></li>
								<li><a href="${pageContext.request.contextPath}/#.html">Mes
										annonces</a></li>
								<li><a href="${pageContext.request.contextPath}/#.html">Mes
										amis</a></li>

								<li class="divider"></li>
								<li><a href="${pageContext.request.contextPath}/logout">Se
										déconnecter</a></li>

							</ul>
						</div>
					</div>
				</c:when>


				<c:otherwise>

					<nav class="col-lg-5">

						<ul class="nav nav-pills">

							<!-- Nos annonces -->
							<li><a
								href="${pageContext.request.contextPath}/annonces.html">Annonces</a></li>

							<!-- Nos professeurs -->
							<li><a
								href="${pageContext.request.contextPath}/professors.html">Professeurs</a></li>

							<!-- Nos élèves -->
							<li><a
								href="${pageContext.request.contextPath}/students.html">Elèves</a></li>

							<!-- Le guide du site -->
							<li><a href="${pageContext.request.contextPath}/guide.html">Le
									Guide UPPT</a></li>
						</ul>
					</nav>

					<div class="col-lg-2">
						<%@ include file="forms/userSearchForm.jsp"%>
					</div>

					<div class="col-lg-3">
						<div class="form-group pull-right">
							<!-- Login -->
							<a href="${pageContext.request.contextPath}/login.html"
								class="btn btn-default">Connexion</a>

							<!-- Inscription -->
							<a href="${pageContext.request.contextPath}/inscription.html"
								class="btn btn-primary">Inscription</a>
						</div>
					</div>

				</c:otherwise>
			</c:choose>



		</header>
	</div>
</div>