<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Liste des produits disponibles</h1>
<a href="${pageContext.request.contextPath}/product/add">Ajouter un
	produit</a>
<table border="1">
	<thead>
		<tr>
			<th>ID</th>
			<th>Nom</th>
			<th>Description</th>
			<th>Prix</th>
			<th>Stock</th>
			<th>Categorie</th>
 			<th>Date de disponibilité</th>
			<th>Date limite d'achat</th>
			<th>Date de création</th>
			<th>Date de dernière modification</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="product" items="${products}">
			<tr>
				<td>${product.id}</td>
				<td>${product.name}</td>
				<td>${product.description}</td>
				<td>${product.price} €</td>
				<td>${product.stock}</td>
				<td>${product.category.displayName}</td>
 				<td>${product.formattedAvailableDate}</td>
				<td>${product.formattedPurchaseDeadlineDate}</td>
				<td>${product.formattedCreationDate}</td>
				<td>${product.formattedLastModifiedDate}</td>
				<td><a
					href="${pageContext.request.contextPath}/product/${product.id}">Details</a>
					| <a href="${pageContext.request.contextPath}/product/edit/${product.id}">Modifier</a>
					| <a
					href="${pageContext.request.contextPath}/product/delete/${product.id}"
					onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce produit ?')">Supprimer</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>