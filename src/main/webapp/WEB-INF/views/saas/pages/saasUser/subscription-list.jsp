<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Liste des forfaits</h1>

<table border="1">
	<thead>
		<tr>
			<th>ID</th>
			<th>Nom</th>
			<th>Description</th>
			<th>Prix</th>

		</tr>
	</thead>
	<tbody>
		<c:forEach var="subscriptions" items="${subscriptions}">
			<tr>
				<td>${subscriptions.id}</td>
				<td>${subscriptions.name}</td>
				<td>${subscriptions.description}</td>
				<td>${subscriptions.price}</td>

			</tr>
		</c:forEach>
	</tbody>
</table>
