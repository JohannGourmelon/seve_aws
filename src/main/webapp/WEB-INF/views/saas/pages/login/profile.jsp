<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Profil</title>
</head>
<body>
    <h1>Bienvenue, <span>${username} </span>!</h1>
    <a href="${pageContext.request.contextPath}/logout">Me déconnecter</a>
</body>
</html>
