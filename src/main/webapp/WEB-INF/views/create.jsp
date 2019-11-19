<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Prueba técnica - Imatia</h1>
	<h3>Crear nueva tarea</h3>

		
		<form:form action="crear" method="post" commandName="tarea">
            <table border="0">                

 				<tr>
                    <td><form:label path="name">Nombre de tarea</form:label></td>
                    <td><form:input path="name"/></td>
                </tr>
              

           
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Crear tarea" /></td>
                </tr>
            </table>
        </form:form>
	<br>
	<a href=" ${pageContext.request.contextPath}/tareas">Ver Tareas</a>
	<br>
	<a href=" ${pageContext.request.contextPath}/">Volver a inicio</a> (Restablece las tareas)
</body>
</html>