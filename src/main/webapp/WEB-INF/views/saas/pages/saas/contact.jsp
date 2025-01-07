<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/saas/contact.css">
</head>
<body>
    <div class="container">
        <h1>Contactez-nous</h1>
        
        <c:if test="${not empty success}">
            <div class="success">${success}</div>
        </c:if>
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>

        <div class="contact-grid">
            <div class="contact-info">
                <div id="map"></div>
                <h3>Nos coordonnées</h3>
                <p>3 boulevard Michelet</p>
                <p>13008 Marseille, France</p>
                <p>Tél: +33 4 00 00 00 0</p>
                <p>Email: contact@seve.com/p>
            </div>

            <div class="contact-form">
                <form action="${pageContext.request.contextPath}/contact" method="post">
                    <div class="form-group">
                        <label for="name">Nom*</label>
                        <input type="text" id="name" name="name" value="${name}" required>
                    </div>

                    <div class="form-group">
                        <label for="email">Email*</label>
                        <input type="email" id="email" name="email" value="${email}" required>
                    </div>

                    <div class="form-group">
                        <label for="phone">Téléphone</label>
                        <input type="tel" id="phone" name="phone" value="${phone}">
                    </div>

                    <div class="form-group">
                        <label for="message">Message*</label>
                        <textarea id="message" name="message" rows="5" required>${message}</textarea>
                    </div>

                    <button type="submit">Envoyer</button>
                </form>
            </div>
        </div>
    </div>

</body>
</html>