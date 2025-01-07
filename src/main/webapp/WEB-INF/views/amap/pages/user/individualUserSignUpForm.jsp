<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="container mt-3">
	<h1 class="mb-4 text-center">${amapProducerUser.id != null ? 'Modifier utilisateur' : 'Création d\'un compte individuel'}
	</h1>

	<form
		action="${pageContext.request.contextPath}/${slug}/individual/signup"
		method="post" class="needs-validation" novalidate>

		<div class="mb-3">
			<label for="name" class="form-label">Nom :</label> <input type="text"
				id="name" name="amapUser.name" class="form-control"
				value="${amapUser.name != null ? amapUser.name : ''}"
				placeholder="Entrez votre nom" required>
			<div class="invalid-feedback">Veuillez saisir un nom.</div>
		</div>

		<div class="mb-3">
			<label for="firstname" class="form-label">Prénom :</label> <input
				type="text" id="firstname" name="amapUser.firstname"
				class="form-control"
				value="${amapUser.firstname != null ? amapUser.firstname : ''}"
				placeholder="Entrez votre prénom" required>
			<div class="invalid-feedback">Veuillez saisir un prénom.</div>
		</div>

		<div class="mb-3">
			<label for="email" class="form-label">Email :</label> <input
				type="email" id="email" name="amapUser.email" class="form-control"
				value="${amapUser.email != null ? amapUser.email : ''}"
				placeholder="Entrez votre email" required>
			<div class="invalid-feedback">Veuillez saisir un email valide.</div>
		</div>

		<div class="mb-3">
			<label for="phone" class="form-label">Numéro de téléphone :</label> <input
				type="tel" id="phone" name="amapUser.phone" class="form-control"
				value="${amapUser.phone != null ? amapUser.phone : ''}"
				placeholder="Entrez votre numéro de téléphone" required>
			<div class="invalid-feedback">Veuillez saisir un numéro de
				téléphone valide.</div>
		</div>

		<div class="mb-3">
			<label for="password" class="form-label">Mot de passe :</label> <input
				type="password" id="password" name="amapUser.password"
				class="form-control"
				value="${amapUser.password != null ? amapUser.password : ''}"
				placeholder="Entrez votre mot de passe" required>
			<div class="invalid-feedback">Veuillez saisir un mot de passe.</div>
		</div>


		<div class="mb-3 form-check">
			<input type="checkbox" id="volunteer" name="volunteer"
				class="form-check-input"
				${amapIndividualUser.volunteer ? 'checked' : ''}> <label
				class="form-check-label" for="volunteer"> Je veux aussi être
				bénévole </label>
			<div class="invalid-feedback">Veuillez indiquer si vous
				souhaitez être bénévole.</div>
		</div>

		<div class="d-flex justify-content-center mt-4 mb-5">
			<a href="${pageContext.request.contextPath}/${slug}"
				class="btn btn-info mx-3">Annuler</a>
			<button type="submit" class="btn btn-info mx-3">Enregistrer</button>
		</div>
	</form>
</div>

