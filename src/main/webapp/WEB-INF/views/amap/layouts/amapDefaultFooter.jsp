<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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


			<a class="nav-link" data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show" onclick="window.location.href='${pageContext.request.contextPath}/${amap.slug}'">Accueil</a>
			<a class="nav-link" data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show"
				onclick="window.location.href='${pageContext.request.contextPath}/${amap.slug}/box'">Liste des paniers</a>
			<c:if test="${showProducts}">
			<a class="nav-link" data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show"
				onclick="window.location.href='${pageContext.request.contextPath}/${amap.slug}/product'">Liste des produits</a>
			</c:if>
        				
			<c:if test="${showActivities}">
			<a class="nav-link" data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show"
				onclick="window.location.href='${pageContext.request.contextPath}/${amap.slug}/activity'">Liste des ateliers</a>
			</c:if>
		</div>
		
	</div>
	<div class="footer-container">
	<p class="cr mt-3">© 2025 - Tous droits réservés</p>
	</div>
</footer>