<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado de tareas</title>
</head>
<body>
<h1>Prueba técnica - Imatia</h1>
	<h3>Tareas</h3>
	<table>
		<!-- iterate over the collection using forEach loop -->
		<tr>
			<th>ID</th>
			<th>Nombre</th>
			<th>Realizada</th>

		</tr>
		<c:forEach var="t" items="${tareas}">

			<!-- create an html table row -->

			<tr>
				<!-- create cells of row -->
				<td>${t.id}</td>
				<td>${t.name}</td>
				<td>${t.done}</td>
				<td><a href=" ${pageContext.request.contextPath}/tarea/${t.id}/realizada">Marcar como realizada</a>
				<td>
				<td><a href=" ${pageContext.request.contextPath}/tarea/${t.id}/borrar">Eliminar tarea</a>
				<td>
					<!-- close row -->
			</tr>
			<!-- close the loop -->

		</c:forEach>
		<!-- close table -->
	</table>
	<br>
	<a href=" ${pageContext.request.contextPath}/crear">Añadir nueva tarea</a>
	<br>
	<a href=" ${pageContext.request.contextPath}/">Volver a inicio</a> (Restablece las tareas)

</body>
</html>