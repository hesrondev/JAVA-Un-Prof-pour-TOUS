<!-- Header !!! -->
<div id="header-wrapper">
	<div id="header" class="container">

		<!--  LOGO -->
		<div id="logo">
			<h1>
				<a href="${pageContext.request.contextPath}/home.html"> <img
					src="#" /> Un Prof Pour Tous
				</a>
			</h1>
		</div>

		<!-- MENU 1 -->
		<c:choose>
			<c:when test="${!empty user}">
				<div id="menu">
					<ul>
						<!-- Espace personnel -->
						<li><a href="${pageContext.request.contextPath}/profile.html">
								Mon Espace Personnel</a> <!-- 
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
			</c:when>
			<c:otherwise>
				<div id="menu">
					<ul>
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

				<div id="menu-login">
					<ul>					
						<!-- Login -->
						<li><a href="${pageContext.request.contextPath}/login.html">Connexion</a></li>

						<!-- Inscription -->
						<li><a class="small"
							href="${pageContext.request.contextPath}/inscription.html">Inscription</a></li>
					</ul>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</div>