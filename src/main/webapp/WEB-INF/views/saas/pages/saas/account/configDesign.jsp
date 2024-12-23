<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Configuration du design de votre Amap</h1>

<c:if test="${not empty amap}">
	<form
		action="${pageContext.request.contextPath}/configuration/editDesign/${configuration.id}"
		method="post">
		<div class="designForm-content">
			<div class="designForm-side">
				<div class="designForm-labels">
					<label for="primaryColor" class="formItem">Couleur primaire</label>
					<label for="secondaryColor" class="formItem">Couleur secondaire</label>
					<label for="tertiaryColor" class="formItem">Couleur tertiaire</label>
				</div>
				<div class="designForm-inputs">
					<input type="color" id="primaryColor" name="primaryColor" value="${configuration.primaryColor}">
					<input type="color" id="secondaryColor" name="secondaryColor" value="${configuration.secondaryColor}"> 
					<input type="color" id="tertiaryColor" name="tertiaryColor" value="${configuration.tertiaryColor}">
				</div>
			</div>
			<div class="designForm-side">
				<div class="designForm-labels">
					<label for="police" class="formItem">Police</label> 
					<label class="formItem">Style des bordures</label>
				</div>
				<div class="designForm-inputs">
					<input type="text" id="police" name="police" value="${configuration.police}">
					<div class="designForm-radios">
						<div>
							<input type="radio" id="roundedNo" name="isRoundedBorders" value="false" ${!configuration.isRoundedBorders ? 'checked' : ''}>
							<label for="roundedNo">Droit</label> 
						</div>
						<div>
							<input type="radio" id="roundedYes" name="isRoundedBorders" value="true" ${configuration.isRoundedBorders ? 'checked' : ''}>
							<label for="roundedYes">Arrondi</label>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="configForm-submit">
			<button class="btn btn-secondary" type="submit">Enregistrer</button>
		</div>
	</form>
</c:if>

<c:if test="${empty amap}">
	<div class="alert alert-warning">
		Veuillez renseigner <a href="${pageContext.request.contextPath}/amap/info">les
			informations de votre AMAP</a> avant de configurer le contenu.
	</div>
</c:if>

<c:if test="${not empty message}">
	<div class="alert alert-success mt-4">${message}</div>
</c:if>
