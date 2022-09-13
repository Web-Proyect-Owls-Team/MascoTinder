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

            <form method="post" action="RegistrarPreferenciaController" class="px-md-2">
            <input type="hidden" name="idMascota" value="${mascota.id }">

              <div class="form-outline mb-4">
                <input type="hidden" name="txtNombre" id="txtNombre" value="${mascota.nombre }" class="form-control" />
              </div>

              <div class="row">
                <div class="col-md-6 mb-4">

                  <div class="form-outline datepicker">		
                  <label class="form-label" for="txtEdadMinima">Edad mínima</label>	    
                    <input type="number" class="form-control" name="txtEdadMinima" id="txtEdadMinima" placeholder="${mascota.preferencia.edadMinima}" /> <br>
                    <label class="form-label" for=txtEdadMaxima>Edad máxima</label>	 
                    <input type="number" class="form-control" name="txtEdadMaxima" id="txtEdadMaxima" placeholder="${mascota.preferencia.edadMaxima}" /> <br> 
                  </div>

                </div>
                <div class="col-md-6 mb-4">
                <br>
                  <label class="form-label" for="txtSexo">Sexo</label>
                  <select name="txtSexo" id="txtSexo">
                    <option value="seleccione" disabled>Sexo</option>
                    <option value="Macho">Macho</option>
                    <option value="Hembra">Hembra</option>
                </select>
                <br><br><br><br>
              <label class="form-label" for="txtEspecie">Especie</label>
              
              <select name="txtEspecie" id="especie">
                    <option value="Seleccione" disabled>Seleccione</option>
                    <option value="Perro">Perro</option>
                    <option value="Gato">Gato</option>
                    <option value="Hammster">Hammster</option>
                    <option value="Ave">Ave</option>
                </select>
                </div>
              </div>

              <div class="mb-4">

              </div>

              <input type="submit" class="btn login_btn" value="Guardar preferencias" /> <br>

            </form>

          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</body>
</html>