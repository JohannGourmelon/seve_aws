<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form action="${pageContext.request.contextPath}/signup" method="post">
    <div>
        <label for="firstname">Prénom :</label>
        <input type="text" id="firstname" name="firstname"
               value="<%= request.getAttribute("firstname") != null ? request.getAttribute("firstname") : "" %>"/>
        <%-- Affichage des erreurs spécifiques pour le prénom --%>
        <%
            String firstnameError = (String) request.getAttribute("firstnameError");
            if (firstnameError != null) {
        %>
            <span><%= firstnameError %></span>
        <%
            }
        %>
    </div>

    <div>
        <label for="name">Nom :</label>
        <input type="text" id="name" name="name"
               value="<%= request.getAttribute("name") != null ? request.getAttribute("name") : "" %>"/>
        <%-- Affichage des erreurs spécifiques pour le nom --%>
        <%
            String nameError = (String) request.getAttribute("nameError");
            if (nameError != null) {
        %>
            <span><%= nameError %></span>
        <%
            }
        %>
    </div>

    <div>
        <label for="email">Email :</label>
        <input type="email" id="email" name="email"
               value="<%= request.getAttribute("email") != null ? request.getAttribute("email") : "" %>"/>
        <%-- Affichage des erreurs spécifiques pour l'email --%>
        <%
            String emailError = (String) request.getAttribute("emailError");
            if (emailError != null) {
        %>
            <span><%= emailError %></span>
        <%
            }
        %>
    </div>

    <div>
        <label for="password">Mot de passe :</label>
        <input type="password" id="password" name="password"/>
        <%-- Affichage des erreurs spécifiques pour le mot de passe --%>
        <%
            String passwordError = (String) request.getAttribute("passwordError");
            if (passwordError != null) {
        %>
            <span><%= passwordError %></span>
        <%
            }
        %>
    </div>

    <div>
        <label for="confirmPassword">Confirmer le mot de passe :</label>
        <input type="password" id="confirmPassword" name="confirmPassword"/>
        <%-- Affichage des erreurs spécifiques pour la confirmation du mot de passe --%>
        <%
            String confirmPasswordError = (String) request.getAttribute("confirmPasswordError");
            if (confirmPasswordError != null) {
        %>
            <span><%= confirmPasswordError %></span>
        <%
            }
        %>
    </div>

    <div>
        <button type="submit">Créer un compte</button>
    </div>
</form>
