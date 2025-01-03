<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <div class="container-fluid">
        <h1 class="text-center">Gestion des ateliers</h1>
        <div class="text-end mb-2">
            <a href="${pageContext.request.contextPath}/activity/add" class="btn btn-success">Ajouter un atelier</a>
        </div>
        <table class="table table-bordered table-striped table-hover mb-5">
            <thead>
                <tr>
                    <th class="d-none">ID</th>
                    <th class="col-1">Nom</th>
                    <th class="col-1">Prix</th>
                    <th class="col-1">Nombre de places disponibles</th>
                    <th class="col-1">Date de l'atelier</th>
                    <th class="col-1">Horaire</th>
                    <th class="col-1">Lieu de l'atelier</th>
                    <th class="col-1">Date limite d'achat</th>
                    <th class="col-1">Date de création</th>
                    <th class="col-1">Dernière modification</th>
                    <th class="col-2">Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="activity" items="${activities}">
                    <tr>
                        <td class="d-none">${activity.id}</td>
                        <td>${activity.name}</td>
                        <td>${activity.price} €</td>
                        <td>${activity.availableSpace}</td>
                        <td>${activity.formattedDate}</td>
                        <td>${activity.formattedStartTime} - ${activity.formattedEndTime}</td>
                        <td>${activity.place}</td>
                        <td>${activity.formattedPurchaseDeadlineDate}</td>
                        <td>${activity.formattedCreationDate}</td>
                        <td>${activity.formattedLastModifiedDate}</td>
                        <td>
                            <div class="btn-container">
                                <a href="${pageContext.request.contextPath}/activity/${activity.id}" class="btn btn-info btn-sm btn-link">Détails</a>
                                <a href="${pageContext.request.contextPath}/activity/edit/${activity.id}" class="btn btn-warning btn-sm btn-link">Modifier</a>
                                <a href="${pageContext.request.contextPath}/activity/delete/${activity.id}" class="btn btn-danger btn-sm btn-link" onclick="return confirm('Êtes-vous sûr de vouloir supprimer cet atelier ?')">Supprimer</a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>