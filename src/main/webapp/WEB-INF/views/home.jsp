<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello World Spring MVC</h1>
 	<p>${message}</p>
	<ol>
		<c:forEach var="saasUser" items="${saasUsers}">
			<li>${saasUser.name} ${saasUser.firstname} - ${saasUser.phone}</li>
			<p>${saasUser.email} (${saasUser.password}) = ${saasUser.saasUserLevel}</p>
			<p>${saasUser.createDate} </p>
		</c:forEach>
	</ol> 
	
<!-- 	<ul> -->
<%-- 		<li> <a href="${pageContext.request.contextPath}/amaps">Gestion des amaps</a></li> --%>
<!-- 	</ul> -->
</body>
</html>