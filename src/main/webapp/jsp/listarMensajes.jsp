<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login_styles.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<link rel="stylesheet" 
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Mensajes</title>
</head>
<body>
<%@include file="../templates/banner_interno.html"%>
<br>
	<div>
	<a class="btn btn-primary" href="ListarCoincidenciasController?idMascota=${idMiMascota}" role="button"><i class="fa-solid fa-arrow-left"></i> Regresar a matches</a>
	</div>
	<br><br>

</body>

<section style="background-color: #eee;">
  <div class="container py-5">

    <div class="row d-flex justify-content-center">
      <div class="col-md-8 col-lg-6 col-xl-4">

        <div class="card" id="chat1" style="border-radius: 15px;">
          <div
            class="card-header d-flex justify-content-between align-items-center p-3 bg-info text-white border-bottom-0"
            style="border-top-left-radius: 15px; border-top-right-radius: 15px;">
            <p class="col text-center mb-0 fw-bold">Chat con ${mascota.nombre}</p>
          </div>
          <div class="card-body">
          
              <div id="mostrarMensajes">
        <c:forEach items="${mensajes}" var="mensaje">
        
       <c:choose>
     <c:when test="${myId == mensaje.emisor.id}" >
        <div class="d-flex flex-row justify-content-start mb-4">
              <img src="${mascota.foto[0].foto}" class="rounded-circle"
                alt="avatar 1" style="width: 45px; height: 100%;">
              <div class="p-3 ms-3" style="border-radius: 15px; background-color: rgba(57, 192, 237,.2);">
                <p class="small mb-0">${mensaje.mensaje}</p>
              </div>
            </div>
     </c:when>
     <c:otherwise>
                     <div class="d-flex flex-row justify-content-end mb-4">
              <div class="p-3 me-3 border" style="border-radius: 15px; background-color: #fbfbfb;">
                <p class="small mb-0">${mensaje.mensaje}</p>
              </div>
              <img src="${match.foto[0].foto}" class="rounded-circle"
                alt="avatar 1" style="width: 45px; height: 100%;">
            </div>
     </c:otherwise>
 </c:choose>
                        
        </c:forEach>
    </div>

            <div class="form-outline">
              <form action="EnviarMensajeController" method="post">
            <input class="form-control" type="text" name="mensaje" id="mensaje">
            <label class="form-label" for="mensaje">Escribe tu mensaje</label>
            <input type="hidden"  type="text" name="coincidenciaId" value="${coincidencia.id}">
            <input  type="hidden" type="text" name="idMascotaMatch" value="${idMascotaMatch}">
            <input  type="hidden" type="text" name="idMiMascota" value="${idMiMascota}"><br>
            <input class="btn btn-primary" type="submit" value="Enviar">
        </form>
              
            </div>

          </div>
        </div>

      </div>
    </div>

  </div>
</section>
</html>
