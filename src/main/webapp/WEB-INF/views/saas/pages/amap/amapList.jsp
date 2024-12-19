<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<h1>Liste des AMAPs</h1>
	<a href="${pageContext.request.contextPath}/amaps/add">Ajouter AMAP</a>
	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nom</th>
				<th>Adresse</th>
				<th>Siret</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="amap" items="${amaps}">
				<tr>
					<td>${amap.id}</td>
					<td>${amap.name}</td>
					<td>${amap.address}</td>
					<td>${amap.siret}</td>
					<td>
						<a href="${pageContext.request.contextPath}/amaps/${amap.id}">Details</a> |
						<a href="${pageContext.request.contextPath}/amaps/edit/${amap.id}">Modifier</a> |
						<a href="${pageContext.request.contextPath}/amaps/delete/${amap.id}" onclick="return confirm('Etes-vous sur ?')">Supprimer</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="${pageContext.request.contextPath}/home">Accueil</a>