<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>
	Bienvenue, <span>${username} </span>!
</h1>

<p>Vous bénéficiez du forfait ${subscription}.</p>

<c:if test="${!empty amap}">
		<a href="http://localhost:8080/seve/${slug}" target="_blank">
			<button class="btn btn-secondary mt-5">Accéder au site web de mon AMAP</button>
		</a>
	
</c:if>

<c:if test="${empty amap}">
	<div class="alert alert-warning my-5">
		 <a href="${pageContext.request.contextPath}/amap/info" style="color: #856404;">Complétez les informations de votre AMAP pour accéder à l'url de votre site web.</a> 
	</div>
</c:if>