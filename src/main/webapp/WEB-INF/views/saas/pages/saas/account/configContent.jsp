<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Configuration du contenu de votre Amap</h1>

<form
	action="${pageContext.request.contextPath}/configuration/editContent/${configuration.id}"
	method="post"
	enctype="multipart/form-data">
	<div class="contentForm-inputs">
		<label for="presentationText">Texte de présentation</label>
		<textarea id="presentationText" name="presentationText" rows="6"
			cols="70">${configuration.presentationText}</textarea>
	</div>

	<div class="contentForm-inputs">
		<label for="logo">Importer un nouveau logo :</label> <input
			type="file" id="logo" name="logo" accept="image/*" />
	</div>

	<div class="configForm-submit">
		<button class="btn btn-secondary" type="submit">Enregistrer</button>
	</div>
</form>

<c:if test="${not empty message}">
	<div class="alert alert-success  mt-4">${message}</div>
</c:if>
