<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container mt-5">
    <h1 class="text-center">Votre Panier</h1>
    <c:if test="${not empty cart.items}">
        <table class="table">
            <thead>
                <tr>
                    <th>Box</th>
                    <th>Prix Unitaire</th>
                    <th>Quantité</th>
                    <th>Total</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${cart.items.values()}">
                    <tr>
                        <td>${item.box.name}</td>
                        <td>${item.box.price} €</td>
                        <td>
                            <form action="${pageContext.request.contextPath}/${slug}/cart/update" method="post">
                                <input type="hidden" name="boxId" value="${item.box.id}" />
                                <input type="number" name="quantity" value="${item.quantity}" min="0" class="form-control d-inline" style="width: 70px;" />
                                <button type="submit" class="btn btn-primary btn-sm">Modifier</button>
                            </form>
                        </td>
                        <td>${item.totalPrice} €</td>
                        <td>
                            <form action="${pageContext.request.contextPath}/${slug}/cart/remove" method="post">
                                <input type="hidden" name="boxId" value="${item.box.id}" />
                                <button type="submit" class="btn btn-danger btn-sm">Supprimer</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div class="d-flex justify-content-between align-items-center">
            <h3>Total : ${cart.totalPrice} €</h3>
            <form action="${pageContext.request.contextPath}/${slug}/cart/clear" method="post">
                <button type="submit" class="btn btn-danger btn-sm">Vider le panier</button>
            </form>
        </div>
    </c:if>
    <c:if test="${empty cart.items}">
        <p class="text-center">Votre panier est vide.</p>
    </c:if>
</div>
