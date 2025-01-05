<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<h1 class="text-center">Détails de l'atelier</h1>

<div class="card my-2 p-4 shadow-sm">
    <div class="card-body">
        <div class="row">
            <div class="col-md-6">
                <p><strong>Nom :</strong> ${activity.name}</p>
                <p><strong>Description :</strong> ${activity.description}</p>
                <p><strong>Prix :</strong> ${activity.price} €</p>
                <p><strong>Nombre de places disponibles :</strong> ${activity.availableSpace}</p>
            </div>
            <div class="col-md-6">
                <p><strong>Date de l'atelier :</strong> ${activity.formattedDate}</p>
                <p><strong>Horaire de l'atelier :</strong>${activity.formattedStartTime} - ${activity.formattedEndTime}</p>
                <p><strong>Lieu de l'atelier:</strong> ${activity.place}</p>
				<p><strong>Date limite d'achat :</strong> ${activity.formattedPurchaseDeadlineDate}</p>               
                <p><strong>Date de création :</strong> ${activity.formattedCreationDate}</p>
                <p><strong>Date de dernière modification :</strong> ${activity.formattedLastModifiedDate}</p>
            </div>
        </div>
    </div>
</div>

<a href="${pageContext.request.contextPath}/${slug}/activity/admin" class="btn btn-secondary mt-3 mb-5">Retour à la liste</a>
