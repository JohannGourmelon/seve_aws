<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Configuration du contenu de votre Amap</h1>


<c:if test="${not empty amap}">
	<form
		action="${pageContext.request.contextPath}/configuration/editContent/${configuration.id}"
		method="post">
		<p>
			<label for="presentationText">Texte de présentation :</label> <input
				type="text" id="presentationText" name="presentationText"
				value="${configuration.presentationText}">
		</p>
		<p>
			<button class="btn btn-secondary" type="submit">Enregistrer</button>
		</p>
	</form>
</c:if>


<c:if test="${empty amap}">
	<div class="alert alert-warning">Veuillez renseigner <a href="${pageContext.request.contextPath}/amap/info">les
		informations de votre AMAP</a> avant de configurer le contenu.</div>
</c:if>

<c:if test="${not empty message}">
	<div class="alert alert-success">${message}</div>
</c:if>
