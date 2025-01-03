
<nav id="navbar" class="navbar navbar-expand-sm bg-light navbar-light">
	<div>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#nav-content" aria-controls="nav-content"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<a class="navbar-brand" href="${pageContext.request.contextPath}/amap-space">Amap name</a>
	</div>

	<div class="collapse navbar-collapse" id="nav-content">
		<ul class="navbar-nav ml-auto">
			<li class="nav-item">
				<a class="nav-link" data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show" onclick="window.location.href='${pageContext.request.contextPath}/amap-space'">Accueil</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show"
				onclick="window.location.href='${pageContext.request.contextPath}/box'">Liste des paniers</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show"
				onclick="window.location.href='${pageContext.request.contextPath}/box/admin'">Gestion des paniers</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="index.html" data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show" onclick="window.location.href='${pageContext.request.contextPath}/order'">Panier</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="index.html" data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show">Contactez-nous</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="index.html" data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show">Se connecter</a>
			</li>
		</ul>
	</div>
</nav>
