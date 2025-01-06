<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Ils nous font confiance</h1>

<div class="features amaps">
	<c:forEach var="amap" items="${amaps}">
		<div class="feature-card amap shadow mb-5">
			<a href="http://localhost:8080/seve/${amap.slug}" target="_blank">

				<img
				src="${pageContext.request.contextPath}/configuration/logo/${amap.id}"
				alt="" />
					<p class="text-center feature-name pt-4 pb-2">${amap.name}</p>
			</a>

		</div>
	</c:forEach>
</div>

