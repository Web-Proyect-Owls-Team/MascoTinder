<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login | Mascotinder</title>

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
	<%@include file="../templates/banner_home.html"%>


	<div class="wrapper">
		<div class="formContent">
		<img src="${pageContext.request.contextPath}/images/mascotinder-logo.png"  width="150" ><br>
			<form method="post" action="LoginController">
				<fieldset>
					<legend>Iniciar sesión</legend>
					<p>Usuario</p>
					<input type="text" name="usuario" /><br><br>
					<p>Contraseña</p>
					<input type="password" name="clave" /> <br> <br> <br>
					<input type="submit" value="Iniciar" />
				</fieldset>
			</form>
			
			<br><a href="RegistrarPropietarioController">¿Nuevo en Mascotinder? Regístrate aquí</a>
		</div>

	</div>
</body>
</html>