<div class="formInsc">

	<form:form action= "${pageContext.request.contextPath}/inscription" method="POST" commandName="inscriptionBean">
		<table>
			<tr>
				<td colspan="2"><c:out value="${profStatus}"/></td>
			</tr>
			<tr>
				<td><form:label path="firstName">
						<spring:message text="Prénom" />
					</form:label></td>
				<td><form:label path="lastName">
						<spring:message text="Nom" />
					</form:label></td>
			</tr>
			<tr>
				<td><form:input path="firstName" /></td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td colspan="2"><form:label path="email">
						<spring:message text="Email" />
					</form:label></td>
			</tr>
			<tr>
				<td colspan="2"><form:input path="email" /></td>
			</tr>
			<tr>
				<td colspan ="2"><form:label path="password">
						<spring:message text="Mot de passe" />
					</form:label></td>
			</tr>
			<tr>
				<td colspan="2"><form:password path="password" /></td>
			</tr>
			<tr>
				<td colspan ="2"><form:label path="rePassword">
						<spring:message text="Retapez le de passe" />
					</form:label></td>
			</tr>
			<tr>
				<td colspan="2"><form:password path="rePassword" /></td>
			</tr>
			<tr>
				<td><form:label path="status">
						<spring:message text="Votre statut : " />
					</form:label>
				</td>
				<td>
					<form:select path="status">
						<form:option value="student">Elève</form:option>  
						<form:option value="professor">Professeur</form:option>  
					</form:select>
				</td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="INSCRIPTION" /></td>
			</tr>

		</table>
	</form:form>
</div>