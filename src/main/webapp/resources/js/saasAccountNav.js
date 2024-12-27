// Fonction pour basculer l'affichage du sous-menu
function toggleSubMenu() {
    var subMenu = document.querySelector('.dropdown');
    var menu = document.querySelector('.secondary-nav');

    if (subMenu.style.display === "none" || subMenu.style.display === "") {
        subMenu.style.display = "block"; // Affiche le sous-menu
    } else {
        subMenu.style.display = "none"; // Cache le sous-menu
    }
}

// Cache le sous-menu au départ
document.addEventListener('DOMContentLoaded', function() {
    var subMenu = document.querySelector('.dropdown-content');
    subMenu.style.display = "none";
});
