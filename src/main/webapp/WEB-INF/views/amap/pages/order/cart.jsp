
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container mt-5">
    <h1 class="text-center">Votre Panier</h1>
    <c:if test="${not empty cart.items}">
        <ul>
            <c:forEach var="item" items="${cart.items}">
                <li>${item.name} - ${item.price} €</li>
            </c:forEach>
        </ul>
        <form action="${pageContext.request.contextPath}/cart/clear" method="post">
            <button type="submit" class="btn btn-danger">Vider le panier</button>
        </form>
    </c:if>
    <c:if test="${empty cart.items}">
        <p class="text-center">Votre panier est vide.</p>
    </c:if>
</div>
