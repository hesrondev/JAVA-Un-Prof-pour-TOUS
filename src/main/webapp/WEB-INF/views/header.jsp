<!-- Header !!! -->

<div class="col-lg-12">
	<!--  LOGO -->
	<div class="row">
		<div class="col-lg-4">
			<h3>
				<img src="#" />
				<a href="${pageContext.request.contextPath}/home.html"> Un Prof
					Pour Tous </a>
			</h3>
		</div>
	</div>

	<div class="row">
		<!-- MENU 1 -->
		<c:choose>
			<c:when test="${!empty currentUser}">
				<nav class="col-lg-12">
					<div class="">
						<div class="container-fluid">
							<ul class="nav navbar-nav">
								<!-- Espace personnel -->
								<li><a
									href="${pageContext.request.contextPath}/profile.html"> Mon
										Espace Personnel</a> <!-- 
								<ul>
									<li><a
										href="${pageContext.request.contextPath}/profile.html">Mon
											profile</a></li>
									<li><a href="${pageContext.request.contextPath}/#.html">Mes
											recherches</a></li>
									<li><a href="${pageContext.request.contextPath}/#.html">Tableau
											de bord</a></li>
									<li><a href="${pageContext.request.contextPath}/#.html">Paramètres</a></li>
									<li><a href="${pageContext.request.contextPath}/#.html">Se
											déconnecter</a></li>
								</ul>  --></li>

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
					<div class="">
						<div class="container-fluid">
							<ul class="nav navbar-nav">
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
							<div class="navbar-form navbar-right inline-form">
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
					</div>
				</nav>
			</c:otherwise>
		</c:choose>
	</div>

</div>