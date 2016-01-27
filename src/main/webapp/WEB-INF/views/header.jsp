<!-- Header !!! -->

<div id="menu-header">
	
	<table>
		<tr> 
			<td><a href="${pageContext.request.contextPath}/home.html">Logo UPPT</a></td>
			
			<!-- Si l'utilisateur n'est pas vide -->
			<td>			
				<c:choose>
					<c:when test="${!empty user}">														
						<div id="div-menu-profile"> 
							<ul id="menu-profile">
								<!-- Profile -->
								<li>
									<a href="#">Hello <c:out value="${user.firstName} ${user.lastName}"></c:out></a>
							
									<ul>															
										<li><a href="${pageContext.request.contextPath}/profile.html">Mon profile</a></li>
										<li><a href="${pageContext.request.contextPath}/#.html">Mes recherches</a></li>
										<li><a href="${pageContext.request.contextPath}/#.html">Tableau de bord</a></li>
										
										<li><a href="${pageContext.request.contextPath}/#.html">Paramètres</a></li>
										<li><a href="${pageContext.request.contextPath}/#.html">Se déconnecter</a></li>
									</ul>	
								</li>
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
	
	<!-- Ligne horizontal -->
	<br>
	<hr>
</div>
