<%
    if (session.getAttribute("login")!="OK") {
            response.sendRedirect("login.jsp");
        }
    %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"/>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <title>Punto de Venta</title>
    </head>
    <body>
         <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="clientes"/>
            </jsp:include>
        <div class="container">  
            <h1>formulario de clientes</h1>
           
            <br>  
            <form action="ClienteControlador" method="post">
                <input type="hidden" name="id" value="${cliente.id}">
                <div class="form-group">
                    <label for="nombre" class="form-label">Nombre</label>
                    <input type="text" class="form-control" name="nombre" value="${cliente.nombre}" id="nombre">
                </div>
              <div class="form-group">
                    <label for="correo" class="form-label">Correo electronico</label>
                    <input type="email" class="form-control" name="correo" value="${cliente.correo}" id="correo">
                </div>
                <div class="form-group">
                    <label for="celular" class="form-label">Celular</label>
                    <input type="text" class="form-control" name="celular" value="${cliente.celular}" id="celular">
                </div>
                <button type="submit" class="btn btn-primary">Procesar</button>
            </form>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>


    </body>
</html>