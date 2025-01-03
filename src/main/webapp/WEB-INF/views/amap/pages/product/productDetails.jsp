<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<h1>Détails du produit</h1>
<p><strong>ID :</strong> ${product.id}</p>
<p><strong>Nom :</strong> ${product.name}</p>
<p><strong>Description :</strong> ${product.description}</p>
<p><strong>Prix :</strong> ${product.price}</p>
<p><strong>Stock :</strong> ${product.stock}</p>
<p><strong>Catégorie :</strong> ${product.category.displayName}</p>

 <p><strong>Date de disponibilité :</strong>
    ${product.formattedAvailableDate}
</p>

<p><strong>Date limite d'achat :</strong>
   ${product.formattedPurchaseDeadlineDate}
</p>

<p><strong>Date de création :</strong>
    ${product.formattedCreationDate}
</p>

<p><strong>Date dernière modification :</strong>
   ${product.formattedLastModifiedDate}
</p> 

<a href="${pageContext.request.contextPath}/product">Retour à la liste</a>