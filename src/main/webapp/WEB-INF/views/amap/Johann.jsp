<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Liste des AMAPs</title>
</head>
<body>
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
</body>
</html>