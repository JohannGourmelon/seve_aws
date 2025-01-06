<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav id="navbar" class="navbar navbar-expand-sm navbar-light">
	<div class="nav-collapse">
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#nav-content" aria-controls="nav-content"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<img class="nav-logo"
			src="${pageContext.request.contextPath}/configuration/logo/${amap.amapSpace.configuration.id}"
			alt="Logo de l'AMAP" />
	</div>
		
	<div class="collapse navbar-collapse" id="nav-content">
		<ul class="navbar-nav ml-auto">
			<li class="nav-item">
				<a class="nav-link" data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show"
					onclick="window.location.href='${pageContext.request.contextPath}/${slug}'">Accueil</a>
			</li>
			
			<li class="nav-item">
				<a class="nav-link" data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show"
					onclick="window.location.href='${pageContext.request.contextPath}/${slug}/box'">Nos paniers maraîchers</a>
			</li>		
				
			<c:if test="${showProducts}">
            	<li class="nav-item">
                	<a class="nav-link" data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show"
                       	onclick="window.location.href='${pageContext.request.contextPath}/${slug}/product'">Nos produits</a>
            	</li>
        	</c:if>
        	
        	<c:if test="${showActivities}">
            	<li class="nav-item">
                	<a class="nav-link" data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show"
                       onclick="window.location.href='${pageContext.request.contextPath}/${slug}/activity'">Nos ateliers</a>
            	</li>
        	</c:if>
			
			<li class="nav-item"><a class="nav-link" href="index.html"
				data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show">Contactez-nous</a>
			</li>
			
			<li class="nav-item">
				<a class="nav-link" href="index.html" data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show"
					onclick="window.location.href='${pageContext.request.contextPath}/${slug}/cart'">
					<img src="${pageContext.request.contextPath}/resources/images/amap/cart.png" alt="Panier" style="width: 20px; height: 20px;">
				</a>
			</li>
			
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" id="Preview" href="#" role="button" aria-haspopup="true"
					aria-expanded="false"> BO </a>
					<div class="dropdown-menu mt-0" aria-labelledby="Preview">
						<a class="dropdown-item" data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show"
							onclick="window.location.href='${pageContext.request.contextPath}/${slug}/box/admin'">Gestion paniers</a> 
							
						<c:if test="${showProducts}">	
							<a class="dropdown-item" href="#" data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show"
								onclick="window.location.href='${pageContext.request.contextPath}/${slug}/product/admin'">Gestion produits</a>
						</c:if>
        				
        				<c:if test="${showActivities}">
							<a class="dropdown-item" href="#" data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show" 
								onclick="window.location.href='${pageContext.request.contextPath}/${slug}/activity/admin'">Gestion ateliers</a>
						</c:if>
					</div>
			</li>
		</ul>
		
		<ul class="navbar-nav ml-auto">
			<li class="nav-item">
				<a class="nav-link" href="${pageContext.request.contextPath}/${slug}/login" data-bs-toggle="" data-bs-target=".navbar-collapse.show">Se connecter</a>
			</li>		
			<li class="nav-item">
				<a class="nav-link" href="${pageContext.request.contextPath}/${slug}/signup" data-bs-toggle="" data-bs-target=".navbar-collapse.show">Créer un compte</a>
			</li>		
		</ul>
		
	</div>
</nav>
