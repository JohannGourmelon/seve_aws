<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Contenu de pr�sentation de votre AMAP</h1>
<form
	action="${pageContext.request.contextPath}/configuration/editContent/${configuration.id}"
	method="post">

	<p>
		<label for="presentationText">Texte de pr�sentation :</label> <input
			type="text" id="presentationText" name="presentationText"
			value="${configuration.presentationText}">
	</p>
	<p>
		<button class="btn btn-secondary" type="submit">Enregistrer</button>
	</p>
</form>

<c:if test="${not empty message}">
	<div class="alert alert-success">${message}</div>
</c:if>
