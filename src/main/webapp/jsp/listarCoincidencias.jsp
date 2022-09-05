<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<link rel="stylesheet" 
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Matches</title>
</head>
<body>

<%@include file="../templates/banner_interno.html"%>
	<br>
	<div class="wrapper">
		<table class="table align-middle mb-0 bg-white">
			<thead class="bg-light">
				<tr>
					<th>Match</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ match }" var="m">
				<tr>
					<td>
					<div class="d-flex align-items-center">
					<img alt="Esta es una foto" src="${m.foto[0].foto}" style="width: 100px; height: 100px" class="rounded-circle">
					<div class="ms-3">
            <p class="fw-bold mb-1">${m.nombre}</p>
            <p class="text-muted mb-0">ID de mascota: ${m.id}</p>
          </div>
          </div>
					</td>
					
					<td>
					<a class="btn btn-secondary" href="RegistrarPreferenciaController?idMascota=${m.id}" role="button"><i class="fa-solid fa-messages"></i>  Enviar mensaje</a> 
					</td>
				</tr>

			</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>