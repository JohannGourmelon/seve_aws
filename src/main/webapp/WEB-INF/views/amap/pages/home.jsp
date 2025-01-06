<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="body-container">
	<h1>Bienvenue chez ${amap.name}</h1>
	<pre>${amap.amapSpace.configuration.presentationText}</pre>
	<c:choose>
        <c:when test="${not empty sessionScope['SPRING_SECURITY_CONTEXT'].authentication and sessionScope['SPRING_SECURITY_CONTEXT'].authentication.authenticated}">
            <p>Vous �tes connect� en tant que : <strong>${sessionScope['SPRING_SECURITY_CONTEXT'].authentication.name}</strong></p>
            <p>Votre r�le est : 
                <strong>
                    <c:forEach var="role" items="${sessionScope['SPRING_SECURITY_CONTEXT'].authentication.authorities}">
                        <c:out value="${role.authority}" />
                    </c:forEach>
                </strong>
            </p>
        </c:when>
        <c:otherwise>
            <p>Vous n'�tes pas connect�.</p>
        </c:otherwise>
    </c:choose>
</div>
