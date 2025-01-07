<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


    <div class="container mt-5">
        <div class="row">
            <div class="col-md-6">
                <div class="order-summary">
                    <h3>Récapitulatif de votre commande</h3>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Nom</th>
                                <th>Quantité</th>
                                <th>Prix Unitaire</th>
                                <th>Total</th>	
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="item" items="${orderItems}">
                                <tr>
                                    <td>${item.genre}</td>
                                    <td>${item.quantity}</td>
                                    <td>${item.price} €</td>
                                    <td>${item.price * item.quantity} €</td>
                                </tr>
                            </c:forEach>
                            <tr class="total-row">
                                <td colspan="3">Total</td>
                                <td>${order.totalAmount} €</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="col-md-6">
                <div class="payment-container">
                    <form class="payment-form">
                    <div class="payment-icons">
					<img src="${pageContext.request.contextPath}/resources/images/saas/visa.png" alt="" />
					<img src="${pageContext.request.contextPath}/resources/images/saas/mastercard.png" alt="" />
					<img src="${pageContext.request.contextPath}/resources/images/saas/amex.png" alt="" />
					</div>
                        <div class="form-group">
                            <label for="card-name">Nom du propriétaire de la carte</label>
                            <input type="text" class="form-control" id="card-name">
                        </div>
                        <div class="form-group">
                            <label for="card-number">Numéro de la carte</label>
                            <input type="text" class="form-control" id="card-number">
                        </div>
                        <div class="form-group">
                            <label for="expiry-date">Date d'expiration</label>
                            <input type="text" class="form-control" id="expiry-date">
                        </div>
                        <div class="form-group">
                            <label for="cvv">CVV</label>
                            <input type="text" class="form-control" id="cvv">
                        </div>
                        <button type="submit" class="btn btn-primary btn-block" onclick="window.location.href='${pageContext.request.contextPath}/${slug}/order/success'">Payer maintenant</button>
                    </form>
                </div>
            </div>
        </div>
    </div>