<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Design</h1>
<form
	action="${pageContext.request.contextPath}/configuration/editDesign/${configuration.id}"
	method="post">

	<p>
		<label for="primaryColor">Couleur primaire :</label> <input
			type="text" id="primaryColor" name="primaryColor"
			value="${configuration.primaryColor}">
	</p>
	<p>
		<label for="secondaryColor">Couleur secondaire :</label> <input
			type="text" id="secondaryColor" name="secondaryColor"
			value="${configuration.secondaryColor}">
	</p>
	<p>
		<label for="tertiaryColor">Couleur tertiaire :</label> <input
			type="text" id="tertiaryColor" name="tertiaryColor"
			value="${configuration.tertiaryColor}">
	</p>
	<p>
		<button class="btn btn-secondary" type="submit">Enregistrer</button>
	</p>
</form>

<!-- Affichage du message de succès si présent -->
<c:if test="${not empty message}">
	<div class="alert alert-success">
		${message}
		<!-- Affiche le message "ok" -->
	</div>
</c:if>
