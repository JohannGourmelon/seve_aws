<!-- saasuser-login.jsp -->
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Connexion</title>
</head>
<body>
    <h2>Connexion</h2>
    <form action="${pageContext.request.contextPath}/login" method="post"> 
        <div>
            <label for="username">Email:</label>
            <input type="text" id="username" name="username" required />
        </div>
        <div>
            <label for="password">Mot de passe:</label>
            <input type="password" id="password" name="password" required />
        </div>
        <div>
            <button type="submit">Se connecter</button>
        </div>
        <c:if test="${not empty param.error}">
            <p style="color: red;">Erreur de connexion. Vérifiez vos identifiants.</p>
        </c:if>
    </form>
</body>
</html>
