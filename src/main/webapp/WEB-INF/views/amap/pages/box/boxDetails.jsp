<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<h1 class="text-center">Détails du panier</h1>

<div class="card my-2 p-4 shadow-sm">
    <div class="card-body">
        <div class="row">
            <div class="col-md-6">
                <p><strong>Nom :</strong> ${box.name}</p>
                <p><strong>Description :</strong> ${box.description}</p>
                <p><strong>Fréquence :</strong> ${box.frequency.displayName}</p>
                <p><strong>Catégorie :</strong> ${box.category.displayName}</p>
                <p><strong>Prix :</strong> ${box.price} €</p>
                <p><strong>Stock :</strong> ${box.stock}</p>
            </div>
            <div class="col-md-6">
                <p><strong>Date de disponibilité :</strong> ${box.formattedAvailableDate}</p>
                <p><strong>Date limite d'achat :</strong> ${box.formattedPurchaseDeadlineDate}</p>
                <p><strong>Date de création :</strong> ${box.formattedCreationDate}</p>
                <p><strong>Date de dernière modification :</strong> ${box.formattedLastModifiedDate}</p>
            </div>
        </div>
    </div>
</div>

<a href="${pageContext.request.contextPath}/box/admin" class="btn btn-secondary mt-3 mb-5">Retour à la liste</a>