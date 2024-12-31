<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Liste des paniers disponibles</h1>
<a href="${pageContext.request.contextPath}/box/add">Ajouter un
	panier</a>
<table border="1">
	<thead>
		<tr>
			<th>ID</th>
			<th>Nom</th>
			<th>Description</th>
			<th>Prix</th>
			<th>Stock</th>
			<th>Fr�quence</th>
			<th>Categorie</th>
 			<th>Date de disponibilit�</th>
			<th>Date limite d'achat</th>
			<th>Date de cr�ation</th>
			<th>Date de derni�re modification</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="box" items="${boxes}">
			<tr>
				<td>${box.id}</td>
				<td>${box.name}</td>
				<td>${box.description}</td>
				<td>${box.price}</td>
				<td>${box.stock}</td>
				<td>${box.frequency.displayName}</td>
				<td>${box.category.displayName}</td>
 				<td>${box.formattedAvailableDate}</td>
				<td>${box.formattedPurchaseDeadlineDate}</td>
				<td>${box.formattedCreationDate}</td>
				<td>${box.formattedLastModifiedDate}</td>
				<td><a
					href="${pageContext.request.contextPath}/box/${box.id}">Details</a>
					| <a href="${pageContext.request.contextPath}/box/edit/${box.id}">Modifier</a>
					| <a
					href="${pageContext.request.contextPath}/box/delete/${box.id}"
					onclick="return confirm('�tes-vous s�r de vouloir supprimer ce panier ?')">Supprimer</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>