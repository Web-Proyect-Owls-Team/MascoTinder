<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<title>Matches</title>
</head>
<body>

<%@include file="../templates/banner_interno.html"%>
	<h1>Mis Matches</h1>	
	<div>
		<a href="ListarMascotasController"> Volver </a>
	</div>
	
	<div class="wrapper">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<td scope="col">id</td>
					<td scope="col">Nombre</td>
				</tr>
			</thead>
			<c:forEach items="${ mascotas }" var="m">
				<tr>
					<td>${m.id}</td>
					<td>${m.nombre}</td>
					
				</tr>
					<c:forEach items="${ fotos }" var="f">
						<tr>
						<td> <img alt="Esta es una foto" src="${f.foto }"> </td>

				</c:forEach>

			</c:forEach>
			
		</table>
	</div>

</body>
</html>