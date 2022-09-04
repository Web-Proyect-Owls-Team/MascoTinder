<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrar nueva Mascota</title>
<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<!-- CSS only -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/estilos.css">
<body>

	<%@include file="../templates/banner_interno.html"%>
	<div>
		<a href="ListarMascotasController">Volver a Lista de Mascotas</a>
	</div>

	<div class="wrapper">
		<h1>Registrar Propietario</h1>

		<form method="post" action="RegistrarMascotaController">
			
			    <label for="txtId">Nombre</label> <input type="nombre" name="txtNombre" id="txtNombre" /> <br><br>
			    <label for="txtId">Edad</label> <input type="number" name="txtFechaNacimiento" id="txtFechaNacimiento" /> <br> <br>
                <label for="txtEspecie">Especie</label> 
                <select name="txtEspecie" id="especie">
                    <option value="Seleccione">Seleccione</option>
                    <option value="Perro">Perro</option>
                    <option value="Gato">Gato</option>
                    <option value="Hammster">Hammster</option>
                    <option value="Ave">Ave</option>
                </select> <br><br>
                <label for="txtSexo">Sexo</label>
                <select name="txtSexo" id="sexo">
                    <option value="seleccione">Seleccione</option>
                    <option value="Macho">Macho</option>
                    <option value="Hembra">Hembra</option>
                </select> <br><br>

				<input type="submit" value="Registrar"/> <br>
		</form>
	</div>
</body>
</html>