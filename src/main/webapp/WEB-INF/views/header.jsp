<!-- Header !!! -->

<!-- <div id="titre_principal">  -->

<div class="icon">
	<div id="label">
		<a href="${pageContext.request.contextPath}/home.html"> <img
			src="#" alt="Logo UPPT" />
		</a>
	</div>
</div>


<div id="header">

	<h1>UPPT</h1>
	<h2>Un Prof Pour Tous</h2>
	<!--  </div>  -->

	<nav>
		<c:choose>
			<c:when test="${!empty user}">
				<!-- <div id="div-menu-profile">  -->
				<ul id="menu-profile">
					<!-- Profile -->
					<li><a href="#">Hello <c:out
								value="${user.firstName} ${user.lastName}"></c:out></a>
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
						</ul></li>
				</ul>
				<!-- </div>  -->
			</c:when>
			<c:otherwise>

				<ul>
					<li class="button"><a
						href="${pageContext.request.contextPath}/login.html">Se
							connecter</a></li>
					<li class="button"><a
						href="${pageContext.request.contextPath}/inscription.html">S'inscrire</a>
					</li>
				</ul>

				<!--  <form action="${pageContext.request.contextPath}/login.html">
				<input type="submit" value="SE CONNECTER">
			</form>
			
			<form action="${pageContext.request.contextPath}/inscription.html">
				<input type="submit" value="S'INSCRIRE">
			</form> -->
			</c:otherwise>
		</c:choose>
	</nav>

</div>

<br>
<hr>