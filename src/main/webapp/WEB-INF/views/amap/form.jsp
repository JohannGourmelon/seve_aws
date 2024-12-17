<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${amap.id != null ? 'Modifier' : 'Ajouter'} une AMAP</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <h1>${amap.id != null ? 'Modifier' : 'Ajouter'} une AMAP</h1>
	<c:choose>
	    <c:when test="${amap.id != null}">
	        <form action="${pageContext.request.contextPath}/amaps/edit/${amap.id}" method="post">
	    </c:when>
	    <c:otherwise>
	        <form action="${pageContext.request.contextPath}/amaps/add" method="post">
	    </c:otherwise>
	</c:choose>
        <p>
            <label for="nom">Nom :</label>
            <input type="text" id="nom" name="nom" value="${amap.nom}" required>
        </p>
        <p>
            <label for="blason">Blason :</label>
            <input type="text" id="blason" name="blason" value="${amap.blason}">
        </p>
        <p>
            <label for="valeurs">Valeurs :</label>
            <textarea id="valeurs" name="valeurs">${amap.valeurs}</textarea>
        </p>
        <p>
            <button type="submit">Enregistrer</button>
            <a href="${pageContext.request.contextPath}/amaps">Annuler</a>
        </p>
    </form>
</body>
</html>