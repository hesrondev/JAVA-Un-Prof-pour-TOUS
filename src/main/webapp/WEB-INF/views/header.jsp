<!-- Header !!! -->

<div id="menu-header">
	
	<table>
		<tr> 
			<td><a href="${pageContext.request.contextPath}/home.html">Logo UPPT</a></td>
			
			<td>			
				<c:choose>
					<c:when test="${!empty user}">
							
							<!-- Profile -->
							<c:out value="${user.firstName} ${user.lastName}"></c:out>
							
							<div id="menu-profile-header"> 
								<ul>
									<li><a href="${pageContext.request.contextPath}/#.html">Mon profile</a></li>
									<li><a href="${pageContext.request.contextPath}/#.html">Mes recherches</a></li>
									<li><a href="${pageContext.request.contextPath}/#.html">Tableau de bord</a></li>
									
									<li><a href="${pageContext.request.contextPath}/#.html">Paramètres</a></li>
									<li><a href="${pageContext.request.contextPath}/#.html">Se déconnecter</a></li>
								</ul>	
							</div>							
					</c:when>
					
					<c:otherwise>
						<a href="${pageContext.request.contextPath}/login.html">Se connecter</a>
						<a href="${pageContext.request.contextPath}/inscription.html">S'inscrire</a>
					</c:otherwise>			
					
				</c:choose>
			</td>					
		</tr>		
	</table>
</div>