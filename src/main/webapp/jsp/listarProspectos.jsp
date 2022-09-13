<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login_styles.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<link rel="stylesheet" 
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Mis Prospectos</title>
</head>
<body>
	<%@include file="../templates/banner_interno.html"%>
	<div class="wrapper">
		<table class="table align-middle mb-0 bg-white">
			<thead class="bg-light">
				<tr>
					<th>Mascota</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ prospectos }" var="p">
				<tr>
					<td>
					<div class="d-flex align-items-center">
					<img alt="Esta es una foto" src="${p.foto[0].foto}" style="width: 100px; height: 100px" class="rounded-circle">
					<div class="ms-3">
            <p class="fw-bold mb-1">${p.nombre}</p>
            <p class="text-muted mb-0">Edad: ${p.edad}</p>
            <p class="text-muted mb-0">Sexo: ${p.sexo}</p>
            <p class="text-muted mb-0">Especie: ${p.especie}</p>
          </div>
          </div>
					</td>
					<td>
					<a class="btn btn-success" href="DarLikeController?idPretendido=${p.id}&idPretendiente=${miMascota.id}" role="button"><i class="fa-solid fa-heart"></i>  Like</a> 
					<a class="btn btn-danger" href="ListarMascotasController" role="button"><i class="fa-solid fa-remove"></i> Dislike</a> 
				</tr>

			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>