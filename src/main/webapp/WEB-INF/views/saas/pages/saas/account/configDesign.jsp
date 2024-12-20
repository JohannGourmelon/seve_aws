<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <h1>Design</h1>
	<c:choose>
	    <c:when test="${configuration.id != null}">
	        <form action="${pageContext.request.contextPath}/configuration/edit/${configuration.id}" method="post">
	    </c:when>
	    <c:otherwise>
	        <form action="${pageContext.request.contextPath}/configuration/addConfigDesign" method="post">
	    </c:otherwise>
	</c:choose>
        <p>
            <label for="primaryColor">Couleur primaire :</label>
            <input type="text" id="primaryColor" name="primaryColor" value="${configuration.primaryColor}">
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
