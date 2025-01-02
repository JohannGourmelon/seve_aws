<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<h1>D�tails de l'atelier</h1>
<p><strong>ID :</strong> ${activity.id}</p>
<p><strong>Nom :</strong> ${activity.name}</p>
<p><strong>Description :</strong> ${activity.description}</p>
<p><strong>Prix :</strong> ${activity.price}</p>
<p><strong>Nombre de participants maximum :</strong> ${activity.maxParticipant}</p>
<p><strong>Nombre de places disponibles :</strong> ${activity.availableSpace}</p>


 <p><strong>Date de l'atelier :</strong>
    ${activity.formattedDate}
</p>

<p><strong>Heure de d�but de l'atelier :</strong>
    ${activity.formattedStartTime}
</p>

<p><strong>Heure de fin de l'atelier :</strong>
    ${activity.formattedEndTime}
</p>

<p><strong>Lieu de l'atelier:</strong> ${activity.place}</p>

<p><strong>Date de cr�ation :</strong>
    ${activity.formattedCreationDate}
</p>

<p><strong>Date derni�re modification :</strong>
   ${activity.formattedLastModifiedDate}
</p> 

<a href="${pageContext.request.contextPath}/activity">Retour � la liste</a>
