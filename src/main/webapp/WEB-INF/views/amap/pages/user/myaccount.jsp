<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="body-container">
	<h1>Bienvenue chez ${amap.name}</h1>

    <c:choose>
        <c:when test="${amapUser.type == 'INDIVIDUAL'}">
            <p>Vous �tes un ${amapUser.type} </p>
            <ul>
                <li>${amapUser.name}</li>
                <li>${amapUser.firstname}</li>
            </ul>

        </c:when>

        <c:when test="${amapUser.type == 'PRODUCER'}">
            <p>Vous �tes un ${amapUser.type} </p>
            <ul>
                <li>${amapUser.name}</li>
                <li>${amapUser.firstname}</li>
            </ul>
        </c:when>

        <c:otherwise>
            <p>Erreur : r�le inconnu. Veuillez contacter l'administrateur.</p>
        </c:otherwise>
    </c:choose>


</div>
