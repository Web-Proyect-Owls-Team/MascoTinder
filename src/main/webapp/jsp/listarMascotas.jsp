<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<title>Mis Mascotas</title>
</head>
<body>
	<%@include file="../templates/banner_interno.html"%>
	<h1>Mis Mascotas</h1>	
	<div>
		<a href="RegistrarMascotaController"> Nuevo </a>
	</div>
	
	<div>
	<a href = "ListarProspectosController">Prospectos</a>
	</div>
	
	<div class="wrapper">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<td scope="col">id</td>
					<td scope="col">Nombre</td>
					<td scope="col">Acciones</td>
					<td scope ="col">Prospectos</td>
					<td scope="col"> Fotos <td/>
				</tr>
			</thead>
			<c:forEach items="${ mascotas }" var="m">
				<tr>
					<td>${m.id}</td>
					<td>${m.nombre}</td>
					<td><a href="RegistrarPreferenciaController?idMascota=${m.id}">
							Preferences </a> | 
							<a
						href="#"> Eliminar </a></td>
					<td><a href="ListarProspectosController?idMascota=${m.id} ">prospectos</a></td>
					<td><a href="ListarCoincidenciasController?idMascota=${m.id} ">Matches</a></td>
				</tr>
				
				 </tr>
<<<<<<< HEAD
					<c:forEach items="${ m.fotos }" var="f">
=======

					<c:forEach items="${ fotos }" var="f">
>>>>>>> 787f8839eff0338a14d643c88998fc531e953877
						<tr>
							<td> <img alt="Esta es una foto" src="${f.foto }" width="500px" height="500px"> </td>
						</tr>
					</c:forEach>

			</c:forEach>
			
		</table>
	</div>

</body>
</html>