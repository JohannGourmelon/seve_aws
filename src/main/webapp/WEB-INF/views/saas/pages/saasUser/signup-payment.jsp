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
					<p>Abonnement ${saasUser.subscription.name} </p>
				</div>
				<div class="signup-bp">
					<div class="dot-container">
						<div class="dot bg-g"></div>
					</div>
					<p>Prix : ${saasUser.subscription.price}</p>
				</div>
			</div>
		</div>
		<!-- Form -->
		<div class="signup-form-container shadow">
			<p class="font-weight-bold pb-2">Paiement par CB</p>
			<div class="panel-body">
				 

					<div class="form-group signup-field">
						<label for="cardNumber" class="control-label">Numéro de
							carte</label>
						<div>
							<input/> 

						</div>
					</div>
					<div class="form-group signup-field">
						<label for="cardDate" class="control-label">Date
							d'Expiration</label>
						<div>
							<input/>

						</div>
					</div>

					<div class="form-group signup-field">
						<label for="cvv" class="control-label">CVV</label>
						<div>
							<input/>

						</div> 
 					</div> 

					<div class="form-group signup-field">
						<label for="cardName" class="control-label">Nom du
							Propriétaire de la carte</label>
						<div>
							<input/>

						</div>
					</div>



					<div class="form-group">
						<div id="btns" class="form-buttons text-center">
							<button class="btn btn-b btn-package-card" onclick="window.location.href='${pageContext.request.contextPath}/amap/info/${saasUser.id}'"> Payer </button>
						</div>
					</div>

		
			</div>
		</div>
	</div>
</section>
