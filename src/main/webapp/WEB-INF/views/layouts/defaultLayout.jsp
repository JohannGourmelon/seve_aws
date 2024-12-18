<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><tiles:getAsString name="title" /></title>
    <link rel="stylesheet" href="<c:url value='/resources/css/styles.css' />">
</head>
<body>
    <header>
        <tiles:insertAttribute name="header" />
    </header>
    <nav>
        <tiles:insertAttribute name="menu" />
    </nav>
    <main>
        <tiles:insertAttribute name="body" />
    </main>
    <footer>
        <tiles:insertAttribute name="footer" />
    </footer>
</body>
</html>
