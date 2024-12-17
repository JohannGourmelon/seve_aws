<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<title>Sève - accueil</title>
		<link rel="stylesheet" href="/resources/static/css/saas/main.css" />
				<link rel="stylesheet" href="/resources/static/css/saas/home.css" />
		
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>
<body>
	<main>
			<h1 class="text-center">La solution numérique pour votre AMAP</h1>
			<section>
				<div class="presentation-container">
					<div>
						<img src="/resources/static/images/saas/home-pres.png" alt="" />
					</div>
					<div class="ctas-home">
						<div class="d-flex justify-content-center package-btn">
							<button class="btn btn-o btn-home">
								Créer mon compte
							</button>
						</div>
						<div class="d-flex justify-content-center package-btn">
							<button class="btn btn-b btn-home">Voir les offres</button>
						</div>
						<div class="d-flex justify-content-center package-btn">
							<button class="btn btn-g btn-home">En savoir plus</button>
						</div>
					</div>
				</div>
			</section>
			<section>
				<h2>Simplifiez la gestion de votre AMAP dès aujourd'hui</h2>
				<div class="features pt-3">
					<div class="feature-card shadow-o">
						<img src="/resources/static/images/saas/panier.jpg" alt="" />
						<div class="feature-card-content">
							<p class="text-center feature-name pt-3 pb-2">
								Gestion des paniers maraîchers
							</p>
							<ul>
								<li>Gestion des commandes et des paniers</li>
								<li>Plateforme de paiement et suivi</li>
								<li>Personnalisation et gestion des stocks</li>
							</ul>
						</div>
					</div>
					<div class="feature-card shadow-b">
						<img src="/resources/static/images/saas/package-pres.png" alt="" />
						<div class="feature-card-content">
							<p class="text-center feature-name pt-3 pb-2">
								Suivi statistique
							</p>
							<ul>
								<li>Suivi des adhésions et participations</li>
								<li>Analyse des distributions</li>
								<li>Optimisation et bilan d'activité</li>
							</ul>
						</div>
					</div>
					<div class="feature-card shadow-g">
						<img src="/resources/images/saas/planning.png" alt="" />
						<div class="feature-card-content">
							<p class="text-center feature-name pt-3 pb-2">
								Gestion des plannings
							</p>
							<ul>
								<li>Création et gestion des plannings</li>
								<li>Coordination et communication</li>
								<li>Suivi et mise à jour en direct</li>
							</ul>
						</div>
					</div>
				</div>
			</section>
			<section class="py-1">
				<h2>Comment ça marche ?</h2>
				<div class="steps pt-4 mb-5">
					<div class="step shadow">
						<p class="text-center number bg-grey">1</p>
						<p class="text-center">Je crée mon compte</p>
					</div>
					<div class="step shadow-b">
						<p class="text-center number bg-b">2</p>
						<p class="text-center">
							Je choisis le forfait adapté à mes besoins
						</p>
					</div>
					<div class="step shadow-g">
						<p class="text-center number bg-g">3</p>
						<p class="text-center">
							Je configure mon site en quelques clics
						</p>
					</div>
					<div class="step shadow-o">
						<p class="text-center number bg-o">4</p>
						<p class="text-center">Je pilote mon activité</p>
					</div>
				</div>
			</section>
			<section>
				<h3 class="text-center">
					Prêt à simplifier la gestion de votre AMAP ?
				</h3>
				<p class="text-center">Essayez gratuitement pendant 14 jours !</p>
				<div class="d-flex justify-content-center package-btn">
					<button
						class="btn btn-secondary m-3"
						onclick="redirect('subscription.html')"
					>
						Démarrer mon essai gratuit
					</button>
				</div>
			</section>
		</main>
</body>
</html>