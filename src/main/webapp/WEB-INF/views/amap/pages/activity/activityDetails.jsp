<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<h1>Détails de l'atelier</h1>
<p><strong>ID :</strong> ${activity.id}</p>
<p><strong>Nom :</strong> ${activity.name}</p>
<p><strong>Description :</strong> ${activity.description}</p>
<p><strong>Prix :</strong> ${activity.price}</p>
<p><strong>Nombre de participants maximum :</strong> ${activity.maxParticipant}</p>
<p><strong>Nombre de places disponibles :</strong> ${activity.availableSpace}</p>


 <p><strong>Date de l'atelier :</strong>
    ${activity.formattedDate}
</p>

<p><strong>Heure de début de l'atelier :</strong>
    ${activity.formattedStartTime}
</p>

<p><strong>Heure de fin de l'atelier :</strong>
    ${activity.formattedEndTime}
</p>

<p><strong>Lieu de l'atelier:</strong> ${activity.place}</p>

<p><strong>Date de création :</strong>
    ${activity.formattedCreationDate}
</p>

<p><strong>Date dernière modification :</strong>
   ${activity.formattedLastModifiedDate}
</p> 

<a href="${pageContext.request.contextPath}/activity">Retour à la liste</a>
