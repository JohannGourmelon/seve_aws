<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>${activity.id != null ? 'Modifier' : 'Ajouter'} un atelier</h1>

<c:choose>
	<c:when test="${activity.id != null}">
		<form action="${pageContext.request.contextPath}/activity/edit/${activity.id}"
			method="post">
	</c:when>
	<c:otherwise>
		<form action="${pageContext.request.contextPath}/activity/add"
			method="post">
	</c:otherwise>
</c:choose>

<p>
	<label for="name">Nom :</label> <input type="text" id="name"
		name="name" value="${activity.name}" required>
</p>

<p>
	<label for="description">Description :</label> <input type="text"
		id="description" name="description" value="${activity.description}"
		required>
</p>

<p>
	<label for="price">Prix :</label> <input type="number" id="price"
		name="price" value="${activity.price}" step="0.01" min="0.01" required>
</p>

<p>
	<label for="maxParticipant">Nombre de participants maximum :</label> <input type="number" id="maxParticipant"
		name="maxParticipant" value="${activity.maxParticipant}" min="1" required>
</p>

<p>
	<label for="availableSpace">Nombre de places disponibles :</label> <input type="number" id="availableSpace"
		name="availableSpace" value="${activity.availableSpace}" min="1" required>
</p>

<label for="dateAndTime">Date et horaire de l'atelier :</label>
<input type="date" id="dateAndTime" name="dateAndTime"
	value="${activity.dateAndTime}" required />
	
<p>
	<label for="place">Lieu de l'atelier :</label> <input type="text" id="place"
		name="place" value="${activity.place}" required>
</p>
	

<!-- <label for="purchaseDeadlineDate">Date limite d'achat :</label> -->
<!-- <input type="date" id="purchaseDeadlineDate" name="purchaseDeadlineDate" -->
<%-- 	value="${activity.purchaseDeadlineDate}" required /> --%>


<p>
	<button type="submit">Enregistrer</button>
	<a href="${pageContext.request.contextPath}/activity">Annuler</a>
</p>

</form>

<script src="${pageContext.request.contextPath}/resources/js/formValidation.js"></script>

