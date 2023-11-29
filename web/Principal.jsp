<%-- 
    Document   : Principal
    Created on : 18/11/2023, 3:35:43 p. m.
    Author     : llina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>E-Bike Masters</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" id="#NavBrand">E-Bike Masters</a>
            
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav nav-active">
                  <li class="nav-item">
                    <a class="btn btn-outline-light" id="navProducto" href="Controlador?menu=Producto&accion=Listar" target="myFrame">Producto</a>
                  </li>
                  <li class="nav-item">
                    <a class="btn btn-outline-light" id="navEmpleado" href="Controlador?menu=Empleado&accion=Listar" target="myFrame">Empleado</a>
                  </li>
                  <li class="nav-item">
                    <a class="btn btn-outline-light" id="navCliente" href="Controlador?menu=Cliente&accion=Listar" target="myFrame">Clientes</a>
                  </li>
                  <li class="nav-item">
                    <a class="btn btn-outline-light active" id="navNuevaVenta" href="Controlador?menu=NuevaVenta&accion=default" target="myFrame">Nueva Venta</a>
                  </li>                
                </ul>
                
                               
            </div>
            

            <div class="dropdown-center">
                <button class="btn btn-outline-light dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                      ${usuario.getNom()}
                </button>
                <ul class="dropdown-menu text-center " aria-labelledby="dropdownMenuButton1">
                    
                    <li>
                        <img src="img/perfil.png" alt="perfil" width="60px" height="60px"/>

                    </li>                    
                    <li>${usuario.getUser()}</li>
                    <li>usuario@gmail.com</li>
                    <div class="dropdown-divider"></div>
                    <form action="Validar" method="POST">
                        <button name="accion" value="Salir" class="dropdown-item" href="#">Salir</button>
                    </form>

             </ul>

            </div>   
           
        </nav>
           
        <div class="m-4 divIFrame">
            <iframe name="myFrame" src="Controlador?menu=NuevaVenta&accion=default">
                
            </iframe>          
           
        </div>
                    
  

        
                        
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
        <script>
            document.addEventListener("DOMContentLoaded", function() {
              // Obtener todos los elementos de la barra de navegación
              var navItems = document.querySelectorAll(".nav-active a");

              // Agregar un controlador de eventos clic a cada elemento
              navItems.forEach(function(item) {
                item.addEventListener("click", function() {
                  // Eliminar la clase activa de todos los elementos
                  navItems.forEach(function(innerItem) {
                    innerItem.classList.remove("active");
                  });

                  // Agregar la clase activa al elemento clicado
                  item.classList.add("active");
                });
              });
            });
        </script>
    </body>
</html>
