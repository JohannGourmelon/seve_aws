<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>${box.id != null ? 'Modifier' : 'Ajouter'} un panier</h1>

<c:choose>
    <c:when test="${box.id != null}">
        <form action="${pageContext.request.contextPath}/box/edit/${box.id}" method="post">
    </c:when>
    <c:otherwise>
        <form action="${pageContext.request.contextPath}/box/add" method="post">
    </c:otherwise>
</c:choose>

<p>
    <label for="name">Nom :</label>
    <input type="text" id="name" name="name" value="${box.name}" required>
</p>

<p>
    <label for="description">Description :</label>
    <input type="text" id="description" name="description" value="${box.description}" required>
</p>

<p>
    <label for="price">Prix :</label>
    <input type="number" id="price" name="price" value="${box.price}" step="0.01" required>
</p>

<p>
    <label for="stock">Stock :</label>
    <input type="number" id="stock" name="stock" value="${box.stock}" required>
</p>

<label for="availableDate">Date de disponibilité :</label>

    <input type="date" id="availableDate" name="availableDate" value="${box.formattedAvailableDate}" />

    <label for="purchaseDeadlineDate">Date limite d'achat :</label>
    <input type="date" id="purchaseDeadlineDate" name="purchaseDeadlineDate" value="${box.formattedPurchaseDeadlineDate}" />

<p>
    <button type="submit">Enregistrer</button>
    <a href="${pageContext.request.contextPath}/amap">Annuler</a>
</p>

</form>
