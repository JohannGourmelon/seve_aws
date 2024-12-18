<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title th:block="title">Mon Application</title>
</head>
<body>
    <header>
        <nav>
            <!-- Barre de navigation -->
        </nav>
    </header>

    <main>
        <div th:replace="${body}"></div>
    </main>

    <footer>
        <p>&copy; 2024 Mon Application</p>
    </footer>
</body>
</html>
