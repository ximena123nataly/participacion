<%
    if (session.getAttribute("login")!="OK") {
            response.sendRedirect("login.jsp");
        }
    %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"/>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <title>Punto de venta</title>
    </head>
    <body>
        <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="ventas"/>
            </jsp:include>
        <div class="container">  
            <h1>formulario de productos</h1>
            
            <br>  
            <form action="ProductoControlador" method="post">
                <input type="hidden" name="id" value="${producto.id}">
                <div class="form-group">
                    <label for="nombre" class="form-label">Cliente</label>
                    <select name="cliente_id" class="form-control">
                        <option value="">-- Seleccione --</option> 
                        <c:forEach var="item" items="${lista_clientes}">
                       <option value="${item.id}"
                               <c:if test="${producto.cliente_id==item.id}">
                                selected
                                </c:if>
                               >${item.nombre}</option>
                        </c:forEach>                                
                    </select>
                </div>
                <label for="nombre" class="form-label">Producto</label>
                <select name="producto_id" class="form-control">
                    <c:forEach var="item" items="${lista_productos}">
                        <option value="${item.id}" 
                                <c:if test="${producto.producto_id==item.id}">
                                selected
                                </c:if>
                                >${item.nombre}</option>
                    </c:forEach>
                </select>
                 <div class="form-group">
                    <label for="nombre" class="form-label">Producto</label>
                    <input type="text" class="form-control" name="id_producto" value="${producto.producto_id}" placeholder="escriba el id del producto">
                </div>
             
                <div class="form-group">
                    <label for="nombre" class="form-label">Descripcion</label>
                    <input type="text" class="form-control" name="fecha" value="${producto.descripcion}" placeholder="escriba la descripcion">
                </div>
                 <div class="form-group">
                    <label for="nombre" class="form-label">Precio</label>
                    <input type="text" class="form-control" name="precio" value="${producto.precio}" placeholder="escriba el precio">
                </div>
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>


    </body>
</html>