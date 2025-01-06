<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<h1>Nos AMAPs</h1>
	<table border="1" class="mb-5">
		<thead>
			<tr>
				<th>Nom</th>
				<th>Site web</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="amap" items="${amaps}">
				<tr>				
					<td>${amap.name}</td>
					<td>
						<a href="http://localhost:8080/seve/${amap.slug}" target="_blank">https://${amap.slug}.com</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
