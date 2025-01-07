<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<section>
	<div class="payment-container">
		<!-- Info -->
		<div class="left">
			<p>Récapitulatif de votre commande</p>
			<table class="table">
				<thead>
					<tr>
						<th>Article</th>
						<th>Prix unitaire</th>
						<th>Quantité</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${orderItems}">
						<tr>
							<td>${item.genre}</td>
							<td>${item.price} €</td>
							<td>${item.quantity}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<p>Prix total : ${order.totalAmount} €</p>
		</div>
		<!-- Form -->
		<div class="card shadow payment-form">
			<div class="payment-form-header">
				<p class="font-weight-bold">Paiement par CB</p>
				<div class="payment-icons">
					<img
						src="${pageContext.request.contextPath}/resources/images/saas/visa.png"
						alt="" /> <img
						src="${pageContext.request.contextPath}/resources/images/saas/mastercard.png"
						alt="" /> <img
						src="${pageContext.request.contextPath}/resources/images/saas/amex.png"
						alt="" />
				</div>
			</div>
			<div class="panel-body">

				<div class="form-group signup-field">
					<label for="cardName" class="control-label">Nom du
						propriétaire de la carte</label>
					<div>
						<input />

					</div>
				</div>

				<div class="form-group signup-field">
					<label for="cardNumber" class="control-label">Numéro de
						carte</label>
					<div>
						<input />

					</div>
				</div>
				<div class="flex">
					<div class="form-group signup-field">
						<label for="cardDate" class="control-label">Date
							d'expiration</label>
						<div>
							<input />

						</div>
					</div>

					<div class="form-group signup-field">
						<label for="cvv" class="control-label">CVV</label>
						<div>
							<input />

						</div>
					</div>
				</div>

				<div id="btns" class="form-buttons text-center mt-4">
					<button class="btn btn-b btn-package-card px-5"
						onclick="window.location.href='${pageContext.request.contextPath}/profile'">Confirmer
						le paiement</button>
				</div>

			</div>
		</div>
	</div>
</section>
