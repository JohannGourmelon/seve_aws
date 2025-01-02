<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>${product.id != null ? 'Modifier' : 'Ajouter'} un produit</h1>

<c:choose>
	<c:when test="${product.id != null}">
		<form action="${pageContext.request.contextPath}/product/edit/${product.id}"
			method="post">
	</c:when>
	<c:otherwise>
		<form action="${pageContext.request.contextPath}/product/add"
			method="post">
	</c:otherwise>
</c:choose>

<p>
	<label for="name">Nom :</label> <input type="text" id="name"
		name="name" value="${product.name}" required>
</p>

<p>
	<label for="description">Description :</label> <input type="text"
		id="description" name="description" value="${product.description}"
		required>
</p>

<p>
	<label for="price">Prix :</label> <input type="number" id="price"
		name="price" value="${product.price}" step="0.01" min="0.01" required>
</p>

<p>
	<label for="stock">Stock :</label> <input type="number" id="stock"
		name="stock" value="${product.stock}" min="1" required>
</p>

<label for="availableDate">Date de disponibilité :</label>
<input type="date" id="availableDate" name="availableDate"
	value="${product.availableDate}" required />

<label for="purchaseDeadlineDate">Date limite d'achat :</label>
<input type="date" id="purchaseDeadlineDate" name="purchaseDeadlineDate"
	value="${product.purchaseDeadlineDate}" required />

<p>
	<label for="category">Catégorie :</label> <select id="category"
		name="category" required>
		<option value="" selected disabled>Choisissez une catégorie</option>

		<c:forEach var="category" items="${categories}">
			<option value="${category}"
				${category == product.category ? 'selected' : ''}>${category.displayName}</option>
		</c:forEach>
	</select>
</p>

<p>
	<button type="submit">Enregistrer</button>
	<a href="${pageContext.request.contextPath}/product">Annuler</a>
</p>

</form>

<script src="${pageContext.request.contextPath}/resources/js/formValidation.js"></script>

