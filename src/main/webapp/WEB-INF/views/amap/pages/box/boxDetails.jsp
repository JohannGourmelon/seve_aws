<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<h1>Détails du panier</h1>
<p><strong>ID :</strong> ${box.id}</p>
<p><strong>Nom :</strong> ${box.name}</p>
<p><strong>Description :</strong> ${box.description}</p>
<p><strong>Prix :</strong> ${box.price}</p>
<p><strong>Stock :</strong> ${box.stock}</p>
<p><strong>Fréquence :</strong> ${box.frequency.displayName}</p>
<p><strong>Catégorie :</strong> ${box.category.displayName}</p>

 <p><strong>Date de disponibilité :</strong>
    ${box.formattedAvailableDate}
</p>

<p><strong>Date limite d'achat :</strong>
   ${box.formattedPurchaseDeadlineDate}
</p>

<p><strong>Date de création :</strong>
    ${box.formattedCreationDate}
</p>

<p><strong>Date dernière modification :</strong>
   ${box.formattedLastModifiedDate}
</p> 

<a href="${pageContext.request.contextPath}/box">Retour à la liste</a>
