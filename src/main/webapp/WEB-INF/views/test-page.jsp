<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Test Page</title>
</head>
<body>

	<h1>Page de Test des fonctionnalités du site</h1>

	<div>
		<h2>1. Gestion des amitiés</h2>

		<!-- Liste de tous les utilisateurs  -->
		<h3>> Liste de tous les utilisateurs</h3>

		<table>
			<tr>
				<th>Utilisateur</th>
				<th>Action</th>
			</tr>

			<!-- Boucle -->
			<c:forEach items="${userList}" var="item">
				<tr>
					<td>${item.firstName}${item.lastName}</td>

					<!-- UTILISER UN FORMULAIRE CACHE ??? -->
					<!-- Ne pas s'inviter soi même -->
					<c:if test="${item.id != user.id}">
						<td><a
							href="${pageContext.request.contextPath}/inviter/${user.id}_${item.id}">INVITER</a></td>
					</c:if>
				</tr>
			</c:forEach>
		</table>

		<!-- ESPACE USER -->

		<c:if test="${!empty user}">
			<p>
				<strong>Vous êtes connecté! Bonjour ${user.firstName}</strong>
			</p>
			<!-- LISTE DES DEMANDES D'AJOUTS -->
			<h3>> Mes demandes d'ajouts</h3>

			<table>
				<tr>
					<th>Utilisateur</th>
					<th>Action</th>
				</tr>

				<!-- Boucle -->
				<c:forEach items="${user.friendRequests}" var="item">
					<c:if test="${item.received}">
						<tr>
							<td>${item.senderName}</td>
							<td><a
								href="${pageContext.request.contextPath}/friend-request:accept/${item.id}">ACCEPTER</a>
								<a
								href="${pageContext.request.contextPath}/friend-request:refuse/${item.id}">REFUSER</a>
							</td>
						</tr>
					</c:if>
					
				</c:forEach>
			</table>
			
			<h3>> Mes demandes envoyées</h3>

			<table>
				<tr>
					<th>Utilisateur</th>
					<th>Action</th>
				</tr>

				<!-- Boucle -->
				<c:forEach items="${user.friendRequests}" var="item">
					<c:if test="${item.sent}">
						<tr>
							<td>${item.receiverID}</td>
							<td><a
								href="${pageContext.request.contextPath}/friend-request:accept/${item.receiverName}">ANNULER</a>
							</td>
						</tr>
					</c:if>
				</c:forEach>
			</table>

			<h3>> Liste des amis</h3>
			<table>
				<tr>
					<th>Utilisateur</th>
					<th>Action</th>
				</tr>
				<!-- Boucle -->
				<c:forEach items="${user.myFriends}" var="item">
					<tr>
						<td>${item.firstName} ${item.lastName}</td>
						<td><a
							href="${pageContext.request.contextPath}/friend-request:remove/${item.id}">SUPPRIMER</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
</body>
</html>