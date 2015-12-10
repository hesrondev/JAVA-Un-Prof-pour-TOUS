<section>
	<c:url var="addAction" value="/professors/add"></c:url>
	<form:form action="${addAction}" commandName="professor">
		<table>
			<tr>
				<td><form:label path="firstName">
						<spring:message text="Prénom" />
					</form:label></td>
				<td><form:label path="lastName">
						<spring:message text="Nom" />
					</form:label></td>
			</tr>
			<tr>
				<td><form:input path="lastName" /></td>
				<td><form:input path="firstName" /></td>
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
				<td colspan ="2"><form:label path="password">
						<spring:message text="Retapez le de passe" />
					</form:label></td>
			</tr>
			<tr>
				<td colspan="2"><form:password path="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value="<spring:message text="INSCRIPTION"/>" /></td>

			</tr>

		</table>
	</form:form>
</section>