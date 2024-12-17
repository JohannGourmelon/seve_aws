<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="toto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello World Spring MVC</h1>
<%-- 	<p>${message}</p>
	<ol>
		<toto:forEach var="adh" items="${adherents}">
			<li>${adh.nom} (${adh.email}) - ${adh.type}</li>
		</toto:forEach>
	</ol> --%>
	
	<ul>
		<li> <a href="${pageContext.request.contextPath}/amaps">Gestion des amaps</a></li>
	</ul>
</body>
</html>