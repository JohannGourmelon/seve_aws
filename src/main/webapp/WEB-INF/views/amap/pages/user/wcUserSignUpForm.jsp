<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="container mt-3">
    <h1 class="mb-4 text-center">${amapWorksComitteeUser.id != null ? 'Modifier' : 'Création d\'un compte'} comité d'entreprise</h1>

    <form action="${pageContext.request.contextPath}/${slug}/works-comittee/signup"
          method="post" class="needs-validation" novalidate>

        <div class="mb-3">
            <label for="name" class="form-label">Nom :</label> 
            <input type="text" id="name" name="amapUser.name" class="form-control"
                   value="${amapWorksComitteeUser.amapUser.name != null ? amapWorksComitteeUser.amapUser.name : ''}" placeholder="Entrez votre nom" required>
            <div class="invalid-feedback">Veuillez saisir un nom.</div>
        </div>

        <div class="mb-3">
            <label for="firstname" class="form-label">Prénom :</label> 
            <input type="text" id="firstname" name="amapUser.firstname" class="form-control"
                   value="${amapWorksComitteeUser.amapUser.firstname != null ? amapWorksComitteeUser.amapUser.firstname : ''}" placeholder="Entrez votre prénom" required>
            <div class="invalid-feedback">Veuillez saisir un prénom.</div>
        </div>

        <div class="mb-3">
            <label for="email" class="form-label">Email :</label> 
            <input type="email" id="email" name="amapUser.email" class="form-control"
                   value="${amapWorksComitteeUser.amapUser.email != null ? amapWorksComitteeUser.amapUser.email : ''}" placeholder="Entrez votre email" required>
            <div class="invalid-feedback">Veuillez saisir un email valide.</div>
        </div>

        <div class="mb-3">
            <label for="phone" class="form-label">Numéro de téléphone :</label> 
            <input type="tel" id="phone" name="amapUser.phone" class="form-control"
                   value="${amapWorksComitteeUser.amapUser.phone != null ? amapWorksComitteeUser.amapUser.phone : ''}" placeholder="Entrez votre numéro de téléphone" required>
            <div class="invalid-feedback">Veuillez saisir un numéro de téléphone valide.</div>
        </div>

        <div class="mb-3">
            <label for="password" class="form-label">Mot de passe :</label> 
            <input type="password" id="password" name="amapUser.password" class="form-control"
                   value="${amapWorksComitteeUser.amapUser.password != null ? amapWorksComitteeUser.amapUser.password : ''}" placeholder="Entrez votre mot de passe" required>
            <div class="invalid-feedback">Veuillez saisir un mot de passe.</div>
        </div>

        <div class="mb-3">
            <label for="companyName" class="form-label">Nom de l'entreprise :</label> 
            <input type="text" id="companyName" name="companyName" class="form-control"
                   value="${amapWorksComitteeUser.companyName != null ? amapWorksComitteeUser.companyName : ''}" placeholder="Entrez le nom de votre entreprise" required>
            <div class="invalid-feedback">Veuillez saisir un nom d'entreprise.</div>
        </div>

        <!-- Nouveau champ pour le SIRET -->
        <div class="mb-3">
            <label for="siret" class="form-label">Numéro SIRET :</label> 
            <input type="text" id="siret" name="siret" class="form-control"
                   value="${amapWorksComitteeUser.siret != null ? amapWorksComitteeUser.siret : ''}" placeholder="Entrez votre numéro SIRET" required>
            <div class="invalid-feedback">Veuillez saisir un numéro SIRET valide.</div>
        </div>

        <!-- Boutons -->
        <div class="d-flex justify-content-center mt-4 mb-5">
            <a href="${pageContext.request.contextPath}/${slug}" class="btn btn-secondary mx-3">Annuler</a>
            <button type="submit" class="btn btn-primary mx-3">Enregistrer</button>
        </div>
    </form>
</div>
