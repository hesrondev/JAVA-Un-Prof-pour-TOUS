<!-- Panel des candidatures à une annonce -->

<div class="row">
	<div class="col-lg-offset-1 col-lg-9">

		<c:if test="${empty annonce.applications}">
			<div class="panel panel-default">
				<div class="panel-body">
					<p align="center">Cette annonce n'a aucune candidature pour le
						moment.</p>
				</div>
			</div>
		</c:if>

		<c:forEach items="${annonce.applications}" var="item">

			<div class="panel panel-default">

				<ul class="list-group">

					<li class="list-group-item">
						<!-- description -->
						<h5 class="page-header">${item.firstName}&nbsp;${item.lastName} <small>${item.toStringDate()}</small></h5>
						<p>${item.message}</p>
						<p>Contact:&nbsp;&nbsp; <span class="glyphicon glyphicon-envelope"></span>&nbsp;&nbsp;${item.email}&nbsp;&nbsp;&nbsp;
							<span class="glyphicon glyphicon-earphone"></span>&nbsp;${item.phoneNumber}
						</p>

					</li>


				</ul>
			</div>
		</c:forEach>

	</div>
</div>