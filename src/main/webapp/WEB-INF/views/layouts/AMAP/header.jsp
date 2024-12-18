<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><tiles:getAsString name="title" /></title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Fichier CSS principal -->
    <link rel="stylesheet" href="<c:url value='/resources/css/styles.css' />">
    <!-- Fichiers CSS spécifiques -->
    <tiles:insertAttribute name="css" />
</head>
<body>
    <header class="bg-light shadow-sm py-3">
        <div class="container">
            <h1 class="text-primary">Mon AMAP</h1>
            <p class="text-muted">Bienvenue dans une application propulsée par Apache Tiles et Spring MVC.</p>
        </div>
    </header>
