<nav id="navbar" class="navbar navbar-expand-sm bg-light navbar-light">
			<div>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#nav-content"
					aria-controls="nav-content" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<a class="navbar-brand"
					href="${pageContext.request.contextPath}/saas">Sève</a>
			</div>

			<div class="collapse navbar-collapse" id="nav-content">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link"
						data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show"
						onclick="window.location.href='${pageContext.request.contextPath}/saas'">Accueil</a>
					</li>
					<li class="nav-item"><a class="nav-link"
						data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show"
						onclick="window.location.href='${pageContext.request.contextPath}/saas/packages'">Nos
							offres</a></li>

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" data-bs-toggle="dropdown"
						id="Preview" href="#" role="button" aria-haspopup="true"
						aria-expanded="false"> Souscrire </a>
						<div class="dropdown-menu mt-0" aria-labelledby="Preview">
							<a class="dropdown-item" href="#" data-bs-toggle="collapse"
								data-bs-target=".navbar-collapse.show">Forfait Essentiel</a> <a
								class="dropdown-item" href="#" data-bs-toggle="collapse"
								data-bs-target=".navbar-collapse.show" href="index.html">Forfait
								Standard</a> <a class="dropdown-item" href="#"
								data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show"
								href="index.html">Forfait Premium</a>
							<!-- <li role="separator" class="divider"></li> -->
						</div></li>
					<li class="nav-item"><a class="nav-link" href="index.html"
						data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show">Contactez-nous</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="index.html"
						data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show">Se
							connecter</a></li>
				</ul>
			</div>
		</nav>