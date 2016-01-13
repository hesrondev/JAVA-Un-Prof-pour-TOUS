<!-- Header !!! -->

<div>
	<ul>
		<li><a href="${pageContext.request.contextPath}/home.html">Logo UPPT</a></li>
			
		<c:choose>
			<c:when test="${!empty user}">
				<li>
						
					<!-- Profile -->
					<c:out value="Bonjour ${user.firstName} ${user.lastName}"></c:out>
					 
					<ul>
						<li><a href="${pageContext.request.contextPath}/#.html">Mon profile</a></li>
						<li><a href="${pageContext.request.contextPath}/#.html">Mes recherches</a></li>
						<li><a href="${pageContext.request.contextPath}/#.html">Tableau de bord</a></li>
						
						<li><a href="${pageContext.request.contextPath}/#.html">Paramètres</a></li>
						<li><a href="${pageContext.request.contextPath}/#.html">Se déconnecter</a></li>
					</ul>								
			</c:when>
			
			<c:otherwise>
				<li><a href="${pageContext.request.contextPath}/login.html">Se connecter</a></li>
				<li><a href="${pageContext.request.contextPath}/inscription.html">S'inscrire</a></li>
			</c:otherwise>			
			
		</c:choose>
								
	</ul>
</div>