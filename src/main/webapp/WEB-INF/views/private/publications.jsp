<!-- Panel de la liste des publications postées -->

<div class="row">
	<div class="col-lg-offset-2 col-lg-8">

		<c:forEach items="${currentUser.publications}" var="item">

			<li class="list-group-item">
				<!-- Date de la publication -->								
				<!-- description -->
				<p>
					${item.description}<br>
				</p>
				<h4><small>${item.toStringDate()}</small></h4>
				<!-- tags -->
			
			</li>
		</c:forEach>

	</div>
</div>