<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<h1>D�tails du produit</h1>
<p><strong>ID :</strong> ${product.id}</p>
<p><strong>Nom :</strong> ${product.name}</p>
<p><strong>Description :</strong> ${product.description}</p>
<p><strong>Prix :</strong> ${product.price}</p>
<p><strong>Stock :</strong> ${product.stock}</p>
<p><strong>Cat�gorie :</strong> ${product.category.displayName}</p>

 <p><strong>Date de disponibilit� :</strong>
    ${product.formattedAvailableDate}
</p>

<p><strong>Date limite d'achat :</strong>
   ${product.formattedPurchaseDeadlineDate}
</p>

<p><strong>Date de cr�ation :</strong>
    ${product.formattedCreationDate}
</p>

<p><strong>Date derni�re modification :</strong>
   ${product.formattedLastModifiedDate}
</p> 

<a href="${pageContext.request.contextPath}/product">Retour � la liste</a>