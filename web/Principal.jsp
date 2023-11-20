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
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link href="css/Principal.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" id="#NavBrand" href="#">E-Bike Masters</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
              <ul class="navbar-nav">

                <li class="nav-item">
                    <a class="btn btn-outline-light a_nav"  href="Controlador?accion=Producto" target="myFrame" >Producto</a>
                </li>
                <li class="nav-item">
                  <a class="btn btn-outline-light a_nav" href="Controlador?accion=Empleado" target="myFrame">Empleado</a>
                </li>
                <li class="nav-item">
                  <a class="btn btn-outline-light a_nav" href="Controlador?accion=Cliente" target="myFrame">Clientes</a>
                </li>
                <li class="nav-item">
                  <a class="btn btn-outline-light a_nav" href="Controlador?accion=NuevaVenta" target="myFrame">Nueva Venta</a>
                </li>
              </ul>
            </div>

             <div class="dropdown">
              <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                    ${usuario.getNom()}
              </button>
              <ul class="dropdown-menu text-center" aria-labelledby="dropdownMenuButton1">
                    <img src="img/perfil.png" alt="perfil" width="60px" height="60px"/>
                    <li><a class="dropdown-item" href="#">${usuario.getUser()}</a></li>
                    <li><a class="dropdown-item" href="#">usuario@gmail.com</a></li>
                    <div class="dropdown-divider"></div>
                    <form action="Validar" method="POST">
                        <button name="accion" value="Salir" class="dropdown-item" href="#">Salir</button>
                    </form>

              </ul>

            </div>
        </nav>
        
        <div class="m-4 divIFrame">
            <iframe name="myFrame" >
                
            </iframe>          
           
        </div>
                    
  

        

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    </body>
</html>
