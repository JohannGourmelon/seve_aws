<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inscription Validée</title>

</head>
<body>
	<div class="container">
		<div class="col-md-offset-2 col-md-7">
			<h1>${message}</h1>
			<hr />

			<table class="table table-striped table-bordered">
				<tr>
					<td><b>Prénom</b>: ${saasUser.firstname}</td>
				</tr>
				<tr>
					<td><b>Nom </b> : ${saasUser.name}</td>
				</tr>
				<tr>
					<td><b>Téléphone</b> : ${saasUser.phone}</td>
				</tr>
				<tr>
					<td><b>Email </b>: ${saasUser.email}</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>