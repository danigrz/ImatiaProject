<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Prueba técnica - Imatia</h1>

	<p>Se han generado nuevas tareas</p>
	<table>
		<!-- iterate over the collection using forEach loop -->
		<tr>
			<th>ID</th>
			<th>Nombre</th>
			<th>Realizado</th>

		</tr>
		<c:forEach var="t" items="${tareas}">

			<!-- create an html table row -->

			<tr>
				<!-- create cells of row -->
				<td>${t.id}</td>
				<td>${t.name}</td>
				<td>${t.done}</td>
					<!-- close row -->
			</tr>
			<!-- close the loop -->

		</c:forEach>
		<!-- close table -->
	</table>
	<br>
	<a href=" ${pageContext.request.contextPath}/crear">Añadir nueva tarea</a>
	<br>
	<a href=" ${pageContext.request.contextPath}/tareas">Administrar Tareas</a>


</body>
</html>
