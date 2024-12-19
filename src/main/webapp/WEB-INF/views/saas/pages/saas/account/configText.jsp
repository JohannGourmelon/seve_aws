<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <h1>Textes et images pour votre AMAP</h1>
	<c:choose>
	    <c:when test="${configuration.id != null}">
	        <form action="${pageContext.request.contextPath}/configuration/edit/${configuration.id}" method="post">
	    </c:when>
	    <c:otherwise>
	        <form action="${pageContext.request.contextPath}/configuration/addConfigText" method="post">
	    </c:otherwise>
	</c:choose>
        <p>
            <label for="pres-text-1">Texte de présentation :</label>
            <input type="text" id="pres-text-1" name="presentationText" value="${configuration.presentationText}">
        </p>
        <p>
            <button class="btn btn-secondary" type="submit">Enregistrer</button>
        </p>
    </form>
    
    <!-- Affichage du message de succès si présent -->
<c:if test="${not empty message}">
    <div class="alert alert-success">
        ${message}  <!-- Affiche le message "ok" -->
    </div>
</c:if>
