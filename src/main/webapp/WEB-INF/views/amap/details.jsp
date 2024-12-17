<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Détails de l'AMAP</title>
</head>
<body>
    <h1>Détails de l'AMAP</h1>
    <p><strong>ID :</strong> ${amap.id}</p>
    <p><strong>Nom :</strong> ${amap.nom}</p>
    <p><strong>Blason :</strong> ${amap.blason}</p>
    <p><strong>Valeurs :</strong> ${amap.valeurs}</p>
    <a href="${pageContext.request.contextPath}/amaps">Retour à la liste</a>
</body>
</html>