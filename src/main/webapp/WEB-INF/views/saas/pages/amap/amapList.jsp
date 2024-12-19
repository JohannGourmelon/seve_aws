<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<h1>Liste des AMAPs</h1>
	<a href="${pageContext.request.contextPath}/amaps/add">Ajouter AMAP</a>
	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nom</th>
				<th>Blason</th>
				<th>Valeurs</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="amap" items="${amaps}">
				<tr>
					<td>${amap.id}</td>
					<td>${amap.nom}</td>
					<td>${amap.blason}</td>
					<td>${amap.valeurs}</td>
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