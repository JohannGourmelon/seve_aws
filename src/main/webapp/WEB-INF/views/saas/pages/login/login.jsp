<!-- saasuser-login.jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty error}">
    <div style="color: red;">${error}</div>
</c:if>

 <form method="POST" action="${pageContext.request.contextPath}/login" class="my-5">
        <label for="username">Nom d'utilisateur :</label>
        <input type="text" id="username" name="username" required>

        <label for="password">Mot de passe :</label>
        <input type="password" id="password" name="password" required>

        <!-- Jeton CSRF -->
        <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />

        <button type="submit">Se connecter</button>
    </form>
