<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>${box.id != null ? 'Modifier' : 'Ajouter'} un panier</h1>

<c:choose>
	<c:when test="${box.id != null}">
		<form action="${pageContext.request.contextPath}/box/edit/${box.id}"
			method="post">
	</c:when>
	<c:otherwise>
		<form action="${pageContext.request.contextPath}/box/add"
			method="post">
	</c:otherwise>
</c:choose>

<p>
	<label for="name">Nom :</label> <input type="text" id="name"
		name="name" value="${box.name}" required>
</p>

<p>
	<label for="description">Description :</label> <input type="text"
		id="description" name="description" value="${box.description}"
		required>
</p>

<p>
	<label for="price">Prix :</label> <input type="number" id="price"
		name="price" value="${box.price}" step="0.01" min="0.01" required>
</p>

<p>
	<label for="stock">Stock :</label> <input type="number" id="stock"
		name="stock" value="${box.stock}" min="1" required>
</p>

<label for="availableDate">Date de disponibilit� :</label>
<input type="date" id="availableDate" name="availableDate"
	value="${box.availableDate}" required />

<label for="purchaseDeadlineDate">Date limite d'achat :</label>
<input type="date" id="purchaseDeadlineDate" name="purchaseDeadlineDate"
	value="${box.purchaseDeadlineDate}" required />

<p>
	<label for="category">Cat�gorie :</label> <select id="category"
		name="category" required>
		<option value="" selected disabled>Choisissez une cat�gorie</option>

		<c:forEach var="category" items="${categories}">
			<option value="${category}"
				${category == box.category ? 'selected' : ''}>${category.displayName}</option>
		</c:forEach>
	</select>
</p>

<p>
	<label for="frequency">Fr�quence :</label> <select id="frequency"
		name="frequency" required>
		<option value="" selected disabled>Choisissez une fr�quence</option>
		<c:forEach var="frequency" items="${frequencies}">
			<option value="${frequency}"
				${frequency == box.frequency ? 'selected' : ''}>${frequency.displayName}</option>
		</c:forEach>
	</select>
</p>

<p>
	<button type="submit">Enregistrer</button>
	<a href="${pageContext.request.contextPath}/box">Annuler</a>
</p>

</form>
