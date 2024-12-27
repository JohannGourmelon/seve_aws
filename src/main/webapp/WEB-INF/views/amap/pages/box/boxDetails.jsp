<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<h1>D�tails du panier</h1>
<p><strong>ID :</strong> ${box.id}</p>
<p><strong>Nom :</strong> ${box.name}</p>
<p><strong>Description :</strong> ${box.description}</p>
<p><strong>Prix :</strong> ${box.price}</p>
<p><strong>Stock :</strong> ${box.stock}</p>
<p><strong>Fr�quence :</strong> ${box.frequency}</p>
<p><strong>Cat�gorie :</strong> ${box.category}</p>

 <p><strong>Date de disponibilit� :</strong>
    ${box.availableDate}
</p>

<p><strong>Date limite d'achat :</strong>
   ${box.purchaseDeadlineDate}
</p>

<p><strong>Date de cr�ation :</strong>
    ${box.creationDate}
</p>

<p><strong>Date derni�re modification :</strong>
   ${box.lastModifiedDate}
</p> 

<a href="${pageContext.request.contextPath}/box">Retour � la liste</a>
