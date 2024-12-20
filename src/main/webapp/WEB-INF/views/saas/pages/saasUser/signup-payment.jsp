<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1 class="text-center">Vous y êtes presque !</h1>
<section class="signup-section">
	<div class="signup-container">
		<!-- Info -->
		<div class="signup-info">
			<p>Voici un récapitulatif de votre inscription :</p>
			<div class="my-4">
				<div class="signup-bp">
					<div class="dot-container">
						<div class="dot bg-o"></div>
					</div>
					<p>Nom : ${saasUser.name}</p>
					<p>Prenom ${saasUser.firstname}</p>
					<p>Mail : ${saasUser.email}</p>
					<p>Téléphone : ${saasUser.phone}</p>
				</div>
				<div class="signup-bp">
					<div class="dot-container">
						<div class="dot bg-b"></div>
					</div>
					<p>Abonnement Essentiel</p>
				</div>
				<div class="signup-bp">
					<div class="dot-container">
						<div class="dot bg-g"></div>
					</div>
					<p>Prix : 9,99€/mois</p>
				</div>
			</div>
		</div>
<!-- 		<!-- Form --> -->
<!-- 		<div class="signup-form-container shadow"> -->
<!-- 			<p class="font-weight-bold pb-2">Paiement par CB</p> -->
<!-- 			<div class="panel-body"> -->
<%-- 				<form:form action="/saasUser/savePayment" cssClass="form-horizontal" --%>
<%-- 				method="post" modelAttribute="payment">  --%>

<!-- 					<div class="form-group signup-field"> -->
<!-- 						<label for="cardNumber" class="control-label">Numéro de -->
<!-- 							carte</label> -->
<!-- 						<div> -->
<%-- 							<form:input path="cardNumber" cssClass="form-control" --%>
<%-- 							value="${payment.cardNumber}" required="true" /> --%>

<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="form-group signup-field"> -->
<!-- 						<label for="cardDate" class="control-label">Date -->
<!-- 							d'Expiration</label> -->
<!-- 						<div> -->
<%-- 							<form:input path="cardDate" cssClass="form-control" --%>
<%-- 							value="${payment.cardDate}" />  --%>

<!-- 						</div> -->
<!-- 					</div> -->

<!-- 					<div class="form-group signup-field"> -->
<!-- 						<label for="cvv" class="control-label">CVV</label> -->
<!-- 						<div> -->
<%-- 							<form:input path="cvv" cssClass="form-control" value="${payment.cvv}" --%>
<%-- 							required="true" />  --%>

<!-- 						</div> -->
<!-- 					</div> -->

<!-- 					<div class="form-group signup-field"> -->
<!-- 						<label for="cardName" class="control-label">Nom du -->
<!-- 							Propriétaire de la carte</label> -->
<!-- 						<div> -->
<%-- 							<form:input path="cardName" cssClass="form-control" --%>
<%-- 							value="${payment.cardName}" />  --%>

<!-- 						</div> -->
<!-- 					</div> -->



<!-- 					<div class="form-group"> -->
<!-- 						<div id="btns" class="form-buttons text-center"> -->
<%-- 							<form:button class="btn btn-b">Payer</form:button> --%>
<!-- 						</div> -->
<!-- 					</div> -->

<%-- 				</form:form> --%>
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
<!-- </section> -->
