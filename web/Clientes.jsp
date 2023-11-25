<%-- 
    Document   : Cliente
    Created on : 19/11/2023, 8:38:39 p. m.
    Author     : llina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <script src="https://kit.fontawesome.com/53b1bfb7db.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
     <body>
        <div class="d-flex">
            <div class="card col-sm-4 ">
                <div class="card-body "  >
                    <form action="Controlador?menu=Cliente" method="POST">
                        <div class="form-group">
                            <labe>Cedula</labe>
                            <input type="text" value="${cliente.getCedula()}" name="txtCedula" class="form-control">
                        </div>
                        <div class="form-group">
                            <labe>Nombres</labe>
                            <input type="text" value="${cliente.getNom()}" name="txtNombres" class="form-control">
                        </div>
                        <div class="form-group">
                            <labe>Direccion</labe>
                            <input type="text" value="${cliente.getDireccion()}" name="txtDireccion" class="form-control">
                        </div>
                        <div class="form-group">
                            <labe>Telefono</labe>
                            <input type="text" value="${cliente.getTel()}" name="txtTel" class="form-control">
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
                    <input type="text" class="form-control" placeholder="Buscar Cliente">
                    <div class="input-group-append">
                        <button class="btn btn-outline-secondary" type="button">Buscar</button>
                    </div>
                </div>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>CEDULA</th>
                            <th>NOMBRES</th>
                            <th>DIRECCION</th>
                            <th>TELEFONO</th>
                            <th>ACCIONES</th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="cl" items="${clientes}">
                            <tr>
                                <td>${cl.getId()}</td>
                                <td>${cl.getCedula()}</td>
                                <td>${cl.getNom()}</td>
                                <td>${cl.getDireccion()}</td>
                                <td>${cl.getTel()}</td>


                                <td>
                                    <a class="btn btn-warning" href="Controlador?menu=Cliente&accion=Editar&id=${cl.getId()}">Editar</a>
                                    <a class="btn btn-danger" href="Controlador?menu=Cliente&accion=Delete&id=${cl.getId()}">Delete</a>
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
