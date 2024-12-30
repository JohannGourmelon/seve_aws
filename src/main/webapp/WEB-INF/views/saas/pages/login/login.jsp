<!-- saasuser-login.jsp -->
 <form method="POST" action="/login">
        <label for="username">Nom d'utilisateur :</label>
        <input type="text" id="username" name="username" required>

        <label for="password">Mot de passe :</label>
        <input type="password" id="password" name="password" required>

        <!-- Jeton CSRF -->
        <input type="hidden" name="_csrf" value="${_csrf.token}">

        <button type="submit">Se connecter</button>
    </form>
