<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Design</h1>

<c:if test="${not empty amap}">
	<form
		action="${pageContext.request.contextPath}/configuration/editDesign/${configuration.id}"
		method="post">

		<p>
			<label for="primaryColor">Couleur primaire :</label> <input
				type="color" id="primaryColor" name="primaryColor"
				value="${configuration.primaryColor}">
		</p>
		<p>
			<label for="secondaryColor">Couleur secondaire :</label> <input
				type="color" id="secondaryColor" name="secondaryColor"
				value="${configuration.secondaryColor}">
		</p>
		<p>
			<label for="tertiaryColor">Couleur tertiaire :</label> <input
				type="color" id="tertiaryColor" name="tertiaryColor"
				value="${configuration.tertiaryColor}">
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
