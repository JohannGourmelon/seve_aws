<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



	<h1>Merci ! Votre commande a bien été validée.</h1>
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
					<td>${item.price}€</td>
					<td>${item.quantity}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>Prix total : ${order.totalAmount} €</p>


