<%-- 
    Document   : Empleado
    Created on : 19/11/2023, 8:39:07 p. m.
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
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
      <script src="https://kit.fontawesome.com/53b1bfb7db.js" crossorigin="anonymous"></script>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
      <link href="css/styles.css" rel="stylesheet" type="text/css"/>

      <title>Movie Reviews | Home Page</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4 ">
            <div class="card-body">
                <form action="Controlador?menu=Empleado" method="POST">
                    <div class="form-group">
                        <labe>Dni</labe>
                        <input type="text" name="txtDni" class="form-control">
                    </div>
                    <div class="form-group">
                        <labe>Nombres</labe>
                        <input type="text" name="txtNombres" class="form-control">
                    </div>
                    <div class="form-group">
                        <labe>Telefono</labe>
                        <input type="text" name="txtTel" class="form-control">
                    </div>
                    <div class="form-group">
                        <labe>Estado</labe>
                        <input type="text" name="txtEstado" class="form-control">
                    </div>
                    <div class="form-group">
                        <labe>Usuario</labe>
                        <input type="text" name="txtUser" class="form-control">
                    </div>
                    
                    <div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                    </div>
                    
                </form>
            </div>
            
        </div>
            
        <div class="col-sm-8" id="div_table">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>DNI</th>
                        <th>NOMBRES</th>
                        <th>TELEFONO</th>
                        <th>ESTADO</th>
                        <th>USER</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="em" items="${empleados}">
                        <tr>
                            <td>${em.getId()}</td>
                            <td>${em.getDni()}</td>
                            <td>${em.getNom()}</td>
                            <td>${em.getTel()}</td>
                            <td>${em.getEstado()}</td>
                            <td>${em.getUser()}</td>
                            <td>
                                <a>Editar</a>
                                <a>Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        </div>

      <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" ></script>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    </body>
</html>
