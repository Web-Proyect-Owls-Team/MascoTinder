<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h1> Mensajes </h1>

    <!-- div para mostrar los mensajes recibidos-->
    <div id="mostrarMensajes">
        <c:forEach items="${mensajes}" var="mensaje">
            <p>${mensaje.mensaje}</p>
        </c:forEach>
    </div>

    <!-- div para enviar los mensajes enviados-->
    <div id="enviarMensaje">
        <form action="EnviarMensajeController" method="post">
            <input type="text" name="mensaje" id="mensaje">
            <input type="text" name="coincidenciaId" value="${coincidencia.id}">
            <input type="text" name="idMascotaMatch" value="${idMascotaMatch}">
            <input type="text" name="idMiMascota" value="${idMiMascota}">
            <input type="submit" value="Enviar">
        </form>
</body>
</html>
