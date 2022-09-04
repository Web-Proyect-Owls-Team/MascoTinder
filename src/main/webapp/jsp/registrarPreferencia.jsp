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
	href="${pageContext.request.contextPath}/css/login_styles.css">

</head>


<body>

<%@include file="../templates/banner_interno.html"%>
<section class="h-100 h-custom" style="background-color: #670039;">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-lg-8 col-xl-6">
        <div class="card rounded-3">
          <img src="${pageContext.request.contextPath}/images/paws.jpg"
            class="w-100" style="border-top-left-radius: .3rem; border-top-right-radius: .3rem;"
            alt="Sample photo">
          <div class="card-body p-4 p-md-5">
            <h4 class="mb-4 pb-2 pb-md-0 mb-md-5 px-md-2">Preferencias de ${mascota.nombre}</h4>

            <form method="post" action="RegistrarMascotaController" class="px-md-2">

              <div class="form-outline mb-4">
                <input type="text" name="txtNombre" id="txtNombre" class="form-control" placeholder="Nombre de la mascota"/>
              </div>

              <div class="row">
                <div class="col-md-6 mb-4">

                  <div class="form-outline datepicker">
                    <input type="number" class="form-control" name="txtFechaNacimiento" id="txtFechaNacimiento" placeholder="Edad de la mascota" /> <br> <br>
                  </div>

                </div>
                <div class="col-md-6 mb-4">
                  <label class="form-label" for="txtSexo">Sexo</label>
                  <select class="select name="txtSexo" id="sexo">
                    <option value="seleccione" disabled>Sexo</option>
                    <option value="Macho">Macho</option>
                    <option value="Hembra">Hembra</option>
                </select>

                </div>
              </div>

              <div class="mb-4">
              <label class="form-label" for="txtEspecie">Especie</label>
              
              <select name="txtEspecie" id="especie">
                    <option value="Seleccione" disabled>Seleccione</option>
                    <option value="Perro">Perro</option>
                    <option value="Gato">Gato</option>
                    <option value="Hammster">Hammster</option>
                    <option value="Ave">Ave</option>
                </select>
              </div>

              <input type="submit" class="btn login_btn" value="¡Registrar!" /> <br>

            </form>

          </div>
        </div>
      </div>
    </div>
  </div>
</section>
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