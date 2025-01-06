<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="container mt-5">
    <h1 class="mb-4 text-center">Sélectionner le type de compte utilisateur</h1>

    <div class="d-flex flex-column align-items-center">
        <!-- Boucle sur les types définis -->
        <c:forEach var="type" items="${types}">
            <a href="${pageContext.request.contextPath}/${slug}/${type.key}/signup" 
               class="btn btn-primary mb-3 w-50">
                ${type.value}
            </a>
        </c:forEach>
    </div>

    <div class="d-flex justify-content-center mt-4">
        <a href="${pageContext.request.contextPath}/${slug}" class="btn btn-secondary">Annuler</a>
    </div>
</div>




