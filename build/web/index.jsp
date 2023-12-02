<%-- 
    Document   : index
    Created on : 13/11/2023, 7:17:29 p. m.
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
    </head>
    <body>
    <div class="d-flex justify-content-center align-items-center">
    <div class="container mt-4">
      <div class="row justify-content-center">
          <div class="col-lg-4 col-md-6 ">
              <div class="card">
                  <div class="card-body">
                      <form  class="form-sign" action="Validar" method="POST">

                          <div class="form-group text-center">
                              <h3>E-Bike Masters</h3>
                              <img src="img/logo.png" alt="Logo de E-Bike Masters">
                          </div>
                          <div class="form-group">
                              <label for="txtuser">Usuario:</label>
                              <input type="text" id="txtuser" name="txtuser" class="form-control">
                          </div>
                          <div class="form-group">
                              <label for="txtpass">Password:</label>
                              <input type="password" id="txtpass" name="txtpass" class="form-control">
                          </div>
                          <input type="submit" name="accion" value="Ingresar" class="btn btn-primary  d-grid w-100 mt-3">
                      </form>
                  </div>
              </div>
          </div>
      </div>
  </div>
</div>
     


        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
 
    </body>
</html>
