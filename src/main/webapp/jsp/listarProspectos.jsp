<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<title>Mis Prospectos</title>
</head>
<body>

	<%@include file="../templates/banner_interno.html"%>
	<h1>Mis Prospectos</h1>
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
			<c:forEach items="${ prospectos }" var="p">
				<tr>
					<td>${p.id}</td>
					<td>${p.nombre}</td>
				</tr>
			</c:forEach>
		</table>
	</div>


</body>
</html>