<footer class="bg-o text-center">
	<div class="footer-container">
		<div class="footer-content">
			<img
				src="${pageContext.request.contextPath}/configuration/logo/${amap.amapSpace.configuration.id}"
				alt="Logo de l'AMAP" />
		</div>
		<div class="footer-content">
			<h3>Coordonnées</h3>


			<p>Adresse du bureau : ${amap.address}</p><br/>
			<p>Email : ${amap.saasUser.email}</p><br/>
			<p>Téléphone : ${amap.saasUser.phone}</p><br/>
			<p>SIRET Association : ${amap.siret}</p>

		</div>
		
		<div class="footer-content">
			<h3>Navigation</h3>


			<a class="nav-link" data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show" onclick="window.location.href='${pageContext.request.contextPath}/${amap.name}'">Accueil</a>
			<a class="nav-link" data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show"
				onclick="window.location.href='${pageContext.request.contextPath}/box'">Liste des paniers</a>
			<a class="nav-link" data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show"
				onclick="window.location.href='${pageContext.request.contextPath}/product'">Liste des produits</a>
			<a class="nav-link" data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show"
				onclick="window.location.href='${pageContext.request.contextPath}/activity'">Liste des ateliers</a>

		</div>
		
	</div>
	<div class="footer-container">
	<p class="cr mt-3">© 2025 - Tous droits réservés</p>
	</div>
</footer>