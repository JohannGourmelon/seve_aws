<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<h1>Détails du panier</h1>
<p><strong>ID :</strong> ${box.id}</p>
<p><strong>Nom :</strong> ${box.name}</p>
<p><strong>Description :</strong> ${box.description}</p>
<p><strong>Prix :</strong> ${box.price}</p>
<p><strong>Stock :</strong> ${box.stock}</p>

<%-- <p><strong>Date de disponibilité :</strong>
    <fmt:formatDate value="${box.availableDate}" pattern="yyyy-MM-dd" />
</p>

<p><strong>Date limite d'achat :</strong>
    <fmt:formatDate value="${box.purchaseDeadlineDate}" pattern="yyyy-MM-dd" />
</p>

<p><strong>Date de création :</strong>
    <fmt:formatDate value="${box.creationDate}" pattern="yyyy-MM-dd" />
</p>

<p><strong>Date dernière modification :</strong>
    <fmt:formatDate value="${box.lastModifiedDate}" pattern="yyyy-MM-dd" />
</p> --%>

<a href="${pageContext.request.contextPath}/box">Retour à la liste</a>
