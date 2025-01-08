<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Configuration du contenu de votre Amap</h1>

<form
	action="${pageContext.request.contextPath}/configuration/editContent/${configuration.id}"
	method="post" enctype="multipart/form-data">
	<div class="contentForm-content">
			<div class="contentForm-side side1">
					<label for="logo">Logo de votre AMAP</label> 
					<label for="presentationImage">Image de présentation</label> 
					<label for="presentationText">Texte de présentation</label>
			</div>
			<div class="contentForm-side">
				<input type="file" class="input-img" id="logo" name="logo" accept="image/*" />
				<input type="file" class="input-img" id="presentationImage" name="presentationImage" accept="image/*" />
				<textarea id="presentationText" name="presentationText" rows="8" cols="80">${configuration.presentationText}</textarea>
			</div>
	</div>

	<div class="configForm-submit">
		<button class="btn btn-secondary mb-4" type="submit">Enregistrer</button>
	</div>
</form>

<c:if test="${not empty message}">
	<div class="alert alert-success">${message}</div>
</c:if>
