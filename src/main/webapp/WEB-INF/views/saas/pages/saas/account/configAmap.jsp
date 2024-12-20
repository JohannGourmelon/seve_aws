<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <h1>Informations de votre AMAP</h1>
	<c:choose>
	    <c:when test="${amap.id != null}">
	        <form action="${pageContext.request.contextPath}/amap/editAmap/${amap.id}" method="post">
	    </c:when>
	    <c:otherwise>
	        <form action="${pageContext.request.contextPath}/amap/addAmap" method="post">
	    </c:otherwise>
	</c:choose>
        <p>
            <label for="name">Nom :</label>
            <input type="text" id="name" name="name" value="${amap.name}" required>
        </p>
        <p>
            <label for="address">Adresse :</label>
            <input type="text" id="address" name="address" value="${amap.address}" required>
        </p>
        <p>
            <label for="siret">Siret :</label>
            <input id="siret" name="siret" value="${amap.siret}" required>
        </p>
        <p>
            <button class="btn btn-secondary" type="submit">Enregistrer</button>
        </p>
    </form>
    
    <!-- Affichage du message de succ�s si pr�sent -->
<c:if test="${not empty message}">
    <div class="alert alert-success">
        ${message}  <!-- Affiche le message "ok" -->
    </div>
</c:if>
