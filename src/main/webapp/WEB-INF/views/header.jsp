<!-- Header !!! -->

<div class="container">
	
	<!--  LOGO -->
	<div class="navbar navbar-header">
		<h4>
			<a href="${pageContext.request.contextPath}/home.html">
			<img class="img-thumbnail" src="resources/img/default-picture-s22.png">&nbsp;&nbsp;Un Prof Pour Tous </a>
		</h4>
	</div>

	<!-- ICONE PROFIL HAUT DROITE  -->
	<c:if test="${!empty currentUser}">

		<div class="dropdown pull-right">
			
			<h4 class="dropdown-toggle" data-toggle="dropdown">
				<img class="img-thumbnail" src="resources/img/default-picture-s22.png">&nbsp;<span
				class="caret"></span>
			</h4>
			
			<ul class="dropdown-menu">
				<li><a href="${pageContext.request.contextPath}/profile.html">Mon
						profile</a></li>
				<li><a href="${pageContext.request.contextPath}/#.html">Mon planning</a></li>
				<li><a href="${pageContext.request.contextPath}/#.html">Mes annonces</a></li>
				<li><a href="${pageContext.request.contextPath}/#.html">Mes amis</a></li>
				
				<li class="divider"></li>
				<li><a href="${pageContext.request.contextPath}/logout">Se déconnecter</a></li>
				
			</ul>

		</div>
	</c:if>
</div>

<div class="container">
	<div class="row">
		<!-- MENU 1 -->
		<c:choose>
			<c:when test="${!empty currentUser}">
				<nav class="col-lg-12">
					<div class="">
						<div class="container-fluid">
							<ul class="nav navbar-nav">

								<!-- Accueil -->

								<li><a href="${pageContext.request.contextPath}/home.html">Accueil</a></li>

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
						</div>
					</div>
				</nav>
			</c:when>


			<c:otherwise>

				<nav class="col-lg-12">

					<div class="container-fluid">

						<ul class="nav navbar-nav">

							<!-- Accueil -->

							<li><a href="${pageContext.request.contextPath}/home.html">Accueil</a></li>

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
						<div class="navbar-form navbar-right">
							<div class="form-group">
								<!-- Login -->
								<a href="${pageContext.request.contextPath}/login.html"
									class="btn btn-default">Connexion</a>

								<!-- Inscription -->
								<a href="${pageContext.request.contextPath}/inscription.html"
									class="btn btn-primary">Inscription</a>
							</div>
						</div>
					</div>

				</nav>
			</c:otherwise>
		</c:choose>
	</div>
</div>