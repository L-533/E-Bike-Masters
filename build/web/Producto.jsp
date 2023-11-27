<%-- 
    Document   : Producto
    Created on : 19/11/2023, 8:38:28 p. m.
    Author     : llina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <script src="https://kit.fontawesome.com/53b1bfb7db.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="" rel="stylesheet" type="text/css"/>
        <title>Producto</title>
    </head>
     <body>
        <div class="d-flex">
            <div class="card col-sm-4 ">
                <div class="card-body "  >
                    <form action="Controlador?menu=Producto" method="POST">
                        <div class="form-group">
                            <labe>Nombre</labe>
                            <input type="text" value="${producto.getNom()}" name="txtNombre" class="form-control">
                        </div>
                        <div class="form-group">
                            <labe>Precio</labe>
                            <input type="text" value="${producto.getPrecio()}" name="txtPrecio" class="form-control" placeholder="$/.0.00">
                        </div>
                        <div class="form-group">
                            <labe>Stock</labe>
                            <input type="number" value="${producto.getStock()}" name="txtStock" class="form-control">
                        </div>
                        <div class="form-group">
                            <labe>Estado</labe>
                            <input type="text" value="${producto.getEstado()}" name="txtEstado" class="form-control">
                        </div>


                        <div>
                            <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                             <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                        </div>

                    </form>
                </div>
            
            </div>
            
            <div class="col-sm-8 table-responsive" id="div_table">
                <div class="input-group mb-3">
                    <input type="text" class="form-control" placeholder="Buscar Producto">
                    <div class="input-group-append">
                        <button class="btn btn-outline-secondary" type="button">Buscar</button>
                    </div>
                </div>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>NOMBRE</th>
                            <th>PRECIO</th>
                            <th>STOCK</th>
                            <th>ESTADO</th>
                            <th>ACCIONES</th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="pr" items="${productos}">
                            <tr>
                                <td>${pr.getId()}</td>
                                <td>${pr.getNom()}</td>
                                <td>${pr.getPrecio()}</td>
                                <td>${pr.getStock()}</td>
                                <td>${pr.getEstado()}</td>


                                <td>
                                    <a class="btn btn-warning" href="Controlador?menu=Producto&accion=Editar&id=${pr.getId()}">Editar</a>
                                    <a class="btn btn-danger" href="Controlador?menu=Producto&accion=Delete&id=${pr.getId()}">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <!-- Paginación -->
                <ul class="pagination justify-content-end">
                    <li class="page-item disabled">
                        <span class="page-link">Anterior</span>
                    </li>
                    <li class="page-item active">
                        <span class="page-link">1</span>
                    </li>
                    <li class="page-item">
                        <a class="page-link" href="#">2</a>
                    </li>
                    <li class="page-item">
                        <a class="page-link" href="#">3</a>
                    </li>
                    <li class="page-item">
                        <a class="page-link" href="#">Siguiente</a>
                    </li>
                </ul>
            </div>
        </div>

        <!-- jQuery -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>

        <!-- Popper.js -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>

        <!-- Bootstrap JS -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </body>
</html>
    