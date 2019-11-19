<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Prueba técnica - Imatia</h1>
	<h3>La tarea ${tarea.id} ha sido eliminada</h3>

	<a href=" ${pageContext.request.contextPath}/tareas">Ver Tareas</a>
	<br>
	<a href=" ${pageContext.request.contextPath}/">Volver a inicio</a> (Restablece las tareas)
</body>
</html>