<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar Preferencia</title>

<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<!-- CSS only -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/estilos.css">

</head>


<body>

<%@include file="../templates/banner_interno.html"%>
	<div>
		<a href="ListarMascotasController">Volver</a>
	</div>

	<div class="wrapper">
		<h1>Registrar Preferencias</h1>

		<form method="post" action="RegistrarPreferenciaController">

				<input type="hidden" name="idMascota" value="${mascota.id }">
		
				<label> Nombre </label>
				<input type="text" name="txtNombre" value="${mascota.nombre }">

				
			    <label for="txtId">Edad Minima</label> <input type="text" name="txtEdadMinima" id="txtEdadMinima" /> <br><br>
			    <label for="txtId">Edad Máxima</label> <input type="text" name="txtEdadMaxima" id="txtEdadMaxima" /> <br> <br>
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