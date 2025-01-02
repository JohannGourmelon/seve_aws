<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Liste des ateliers disponibles</h1>
<a href="${pageContext.request.contextPath}/activity/add">Ajouter un
	atelier</a>
<table border="1">
	<thead>
		<tr>
			<th>ID</th>
			<th>Nom</th>
			<th>Description</th>
			<th>Prix</th>
			<th>Nombre de participants maximum</th>
			<th>Nombre de places disponibles</th>
			<th>Date et horaire de l'atelier</th>
 			<th>Lieu de l'atelier</th>
			<th>Date de création</th>
			<th>Date de dernière modification</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="activity" items="${activities}">
			<tr>
				<td>${activity.id}</td>
				<td>${activity.name}</td>
				<td>${activity.description}</td>
				<td>${activity.price} €</td>
				<td>${activity.maxParticipant}</td>
				<td>${activity.availableSpace}</td>
 				<td>${activity.formattedDateAndTime}</td>
				<td>${activity.place}</td>
				<td>${activity.formattedCreationDate}</td>
				<td>${activity.formattedLastModifiedDate}</td>
				<td><a
					href="${pageContext.request.contextPath}/activity/${activity.id}">Details</a>
					| <a href="${pageContext.request.contextPath}/activity/edit/${activity.id}">Modifier</a>
					| <a
					href="${pageContext.request.contextPath}/activity/delete/${activity.id}"
					onclick="return confirm('Êtes-vous sûr de vouloir supprimer cet atelier ?')">Supprimer</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>