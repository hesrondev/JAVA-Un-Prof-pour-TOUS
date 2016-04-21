<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" />
<!-- INCLURE UN CSS PERSO ICI -->


<title>Test Page</title>
</head>
<body>

	<h1>Page de Test des fonctionnalités du site</h1>

	<div>
		<h3>1. Gestion des amitiés</h3>

		<!-- Liste de tous les utilisateurs  -->
		<h3>> Liste de tous les utilisateurs</h3>

		<table>
			<tr>
				<th>Nom</th>
				<th>Prénom</th>
				<th>Action</th>
			</tr>

			<!-- Boucle -->
			<c:forEach items="${userList}" var="item">
				<tr>
					<td>${item.firstName}</td>
					<td>${item.lastName}</td>

					<!-- UTILISER UN FORMULAIRE CACHE ??? -->
					<!-- Ne pas s'inviter soi même -->
					
					<c:choose>
					
						<c:when test="${item.id == currentUser.id || currentUser.hasBeenRequestedByFriend(item.id) > -1}">
							<td>
								<!-- CAS OU JE NE PEUX RIEN FAIRE -->
								BEAU GOSS!
							</td>
						</c:when>						
						<c:when test="${currentUser.getFriend(item.id) != null}">
							<td>
							<!--  CAS OU JE PEUX SUPPRIMER -->
							<!-- BOUTON SUPPRIMER -->
							<div>
								<c:set var="action" value="delete"></c:set>
								<c:set var="requestID" value="${0}"></c:set>
								<c:set var="senderID" value="${currentUser.id}"></c:set>
								<c:set var="receiverID" value="${item.id}"></c:set>
								<%@ include file="forms/generic-request-hidden-form.jsp"%>
							</div>
							</td>
						</c:when>
						
						<c:when test="${currentUser.hasRequestedFriend(item.id) > -1}">
							<td>
							<!-- BOUTON ANNULER -->
							<!-- CAS OU JE PEUX ANNULER -->
							<div>
								<c:set var="action" value="cancel"></c:set>
								<c:set var="requestID" value="${currentUser.hasRequestedFriend(item.id)}"></c:set>
								<c:set var="senderID" value="${currentUser.id}"></c:set>
								<c:set var="receiverID" value="${item.id}"></c:set>
								<%@ include file="forms/generic-request-hidden-form.jsp"%>
							</div>
						</td>
						</c:when>
						
						
						<c:otherwise>
							<td>
							<!-- CAS OU JE PEUX AJOUTER -->
							<!-- BOUTON AJOUTER -->
							<div>
								<c:set var="action" value="add"></c:set>
								<c:set var="requestID" value="${0}"></c:set>
								<c:set var="senderID" value="${currentUser.id}"></c:set>
								<c:set var="receiverID" value="${item.id}"></c:set>
								<%@ include file="forms/generic-request-hidden-form.jsp"%>
							</div>
						</td>
						</c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>
		</table>

		<!-- ESPACE USER -->

		<c:if test="${!empty currentUser}">
			<p>
				<strong>Vous êtes connecté! Bonjour ${currentUser.firstName}</strong><br>
				<a href="${pageContext.request.contextPath}/logout">Se déconnecter</a>
			</p>
			<!-- LISTE DES DEMANDES D'AJOUTS -->
			<h3>> Mes demandes d'ajouts</h3>

			<table>
				<tr>
					<th>Utilisateur</th>
					<th>Action</th>
				</tr>

				<!-- Boucle -->
				<c:forEach items="${currentUser.friendRequests}" var="item">
					<c:if test="${item.received}">
						<tr>
							<td>${item.senderName}</td>
							<td>
								<!-- BOUTON ACCEPT -->
								<div>
									<c:set var="action" value="accept"></c:set>
									<c:set var="requestID" value="${item.id}"></c:set>
									<c:set var="senderID" value="${item.senderID}"></c:set>
									<c:set var="receiverID" value="${item.senderID}"></c:set>
									<%@ include file="forms/generic-request-hidden-form.jsp"%>
								</div>
								
								<!-- BOUTON REFUSE -->
								<div>
									<c:set var="action" value="refuse"></c:set>
									<c:set var="requestID" value="${item.id}"></c:set>
									<c:set var="senderID" value="${item.senderID}"></c:set>
									<c:set var="receiverID" value="${item.senderID}"></c:set>
									<%@ include file="forms/generic-request-hidden-form.jsp"%>
								</div>
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
				<c:forEach items="${currentUser.friendRequests}" var="item">
					<c:if test="${item.sent}">
						<tr>
							<td>${item.receiverName}</td>
							
							<!-- BOUTON ANNULER -->
							<td>
								<div class="header">
									<c:set var="action" value="cancel"></c:set>
									<c:set var="requestID" value="${item.id}"></c:set>
									<c:set var="senderID" value="${item.senderID}"></c:set>
									<c:set var="receiverID" value="${item.senderID}"></c:set>
									<%@ include file="forms/generic-request-hidden-form.jsp"%>
								</div>
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
				<c:forEach items="${currentUser.myFriends}" var="item">
					<tr>
						<td>${item.firstName} ${item.lastName}</td>
						<td><a
							href="${pageContext.request.contextPath}/removeContact/${user.id}:${item.id}">SUPPRIMER</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
</body>
</html>