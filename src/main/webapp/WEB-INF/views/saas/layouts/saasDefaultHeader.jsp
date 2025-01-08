
<nav id="navbar" class="navbar navbar-expand-lg bg-light navbar-light">
	<div>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#nav-content" aria-controls="nav-content"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<a class="navbar-brand" href="${pageContext.request.contextPath}/saas">Sève</a>
	</div>

	<div class="collapse navbar-collapse" id="nav-content">
		<ul class="navbar-nav ml-auto">
			<li class="nav-item"><a class="nav-link"
				data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show"
				onclick="window.location.href='${pageContext.request.contextPath}/saas'">Accueil</a></li>
			<li class="nav-item"><a class="nav-link"
				data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show"
				onclick="window.location.href='${pageContext.request.contextPath}/saas/forfaits'">Nos offres</a></li>
				
				<li class="nav-item"><a class="nav-link"
				data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show"
				onclick="window.location.href='${pageContext.request.contextPath}/saas/nos-amaps'">Notre réseau</a></li>

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" data-bs-toggle="dropdown"
				id="Preview" href="#" role="button" aria-haspopup="true"
				aria-expanded="false"> Souscrire </a>
				<div class="dropdown-menu mt-0" aria-labelledby="Preview">
					<a class="dropdown-item" data-bs-toggle="collapse"
						data-bs-target=".navbar-collapse.show"
						onclick="window.location.href='${pageContext.request.contextPath}/saasuser/souscription-essentiel'">Forfait
						Essentiel</a> <a class="dropdown-item" href="#"
						data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show"
						onclick="window.location.href='${pageContext.request.contextPath}/saasuser/souscription-standard'">Forfait Standard</a> <a
						class="dropdown-item" href="#" data-bs-toggle="collapse"
						data-bs-target=".navbar-collapse.show" onclick="window.location.href='${pageContext.request.contextPath}/saasuser/souscription-premium'">Forfait
						Premium</a>
				</div></li>
			<li class="nav-item"><a class="nav-link"
				data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show"
				onclick="window.location.href='${pageContext.request.contextPath}/saas/contact'">Contactez nous</a></li>
				
				
			<li class="nav-item"><a  class="nav-link" href="index.html"
				data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show" onclick="window.location.href='${pageContext.request.contextPath}/profile'">Mon espace</a></li>
				
				<li class="nav-item d-lg-none">
                    <hr class="dropdown-divider">
                </li>
				                
                <li class="nav-item d-lg-none">
                    <a class="nav-link" data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show" onclick="window.location.href='${pageContext.request.contextPath}/amap/info'">Mon AMAP</a>
                </li>
                <li class="nav-item d-lg-none">
                    <a class="nav-link" data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show" onclick="window.location.href='${pageContext.request.contextPath}/configuration/design'">Configuration design</a>
                </li>
                <li class="nav-item d-lg-none">
                    <a class="nav-link" data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show" onclick="window.location.href='${pageContext.request.contextPath}/configuration/contenu'">Configuration contenu</a>
                </li>
		</ul>
	</div>
</nav>
