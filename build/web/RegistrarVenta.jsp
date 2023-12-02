<%-- 
    Document   : RegistrarVenta
    Created on : 19/11/2023, 8:39:47 p. m.
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
        <title>Registrar Venta</title>
        <style>
            /*Imprimir comprobante*/

        @media print{
            .parte01, .btn, .accion{
                display:none;
            }
}
        </style>
    </head>           
    
    <body>
        
        <div class="d-flex">
            <div class="col-sm-5 parte01">
                <div class="card">
                    <form action="Controlador?menu=NuevaVenta" method="POST">
                        <div class="card-body">
                            <div class="form-group">
                                <label>Datos del Cliente</label>
                            </div>
                            <div class="form-group d-flex mb-4">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="CodigoCliente" value="${clienteV.getCedula()}" class="form-control" placeholder="Codigo">
                                    <input type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-info ">
                                </div>

                                <div class="col-sm-6">
                                    <input type="text" name="nombrescliente" value="${clienteV.getNom()}" class="form-control" placeholder="Datos Cliente" readonly>
                                </div>                     

                            </div>
                            <div class="form-group">
                                <label>Datos Producto</label>

                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="CodigoProducto" value="${producto.getId()}"  class="form-control" placeholder="Codigo" pattern="[0-9]+" title="Ingrese solo números" >
                                    <input type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-info ">
                                </div>

                                <div class="col-sm-6">
                                    <input type="text" name="NombreProducto" value="${producto.getNom()}" class="form-control" placeholder="Datos Producto" readonly>
                                </div> 
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="precio" value="${producto.getPrecio()}" class="form-control" placeholder="$/.0.00" pattern="\d+(\.\d{1,2})?" title="Ingrese un valor positivo con hasta dos decimales">

                                </div>

                                <div class="col-sm-3">
                                    <input type="number" value="${cantidad}" name="cantidad" value="1" class="form-control" min="1" max="${producto.getStock()}">
                                </div>  
                                <div class="col-sm-3">
                                    <input type="text" name="stock" value="${producto.getStock()}"  class="form-control" placeholder="Stock" readonly>
                                </div> 
                            </div>
                            <div class="form-group">
                                <div class="col-sm">
                                    <input type="submit" name="accion" value="Agregar" class="btn btn-outline-info">
                                    <input type="submit" name="accion" value="Actualizar" style="margin-left: 10px" class="btn btn-outline-success">
                                </div>
                            </div>
                        </div>
                    </form>  
                </div>
            </div> 
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-5 ml-auto">
                            <label>Nro.Serie: </label>
                            <input type="text" name="NroSerie" value="${nSerie}" class="form-control">
                        </div>
                        <br>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Nro</th>
                                    <th>Codigo</th>
                                    <th>Descripcion</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>Subtotal</th>
                                    <th class="accion">Acciones</th>
                                </tr>
                            </thead> 
                            <tbody>
                                <c:forEach var="list" items="${lista}">
                                <tr>
                                    <td>${list.getItem()}</td>
                                    <td>${list.getIdProducto()}</td>
                                    <td>${list.getDescripcionP()}</td>
                                    <td>${list.getPrecio()}</td>
                                    <td>${list.getCantidad()}</td>
                                    <td>${list.getSubtotal()}</td>
                                    <td class="d-flex">
                                        <a class="btn btn-warning" href="Controlador?menu=NuevaVenta&accion=Editar&id=${list.getItem()}" >Editar</a>
                                        <a class="btn btn-danger" href="Controlador?menu=NuevaVenta&accion=Delete&id=${list.getItem()}" style="margin-left: 10px">Delete</a>
                                    </td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer d-flex">
                        <div class="col-sm-6">
                            <a href="Controlador?menu=NuevaVenta&accion=GenerarVenta" class="btn btn-success" >Generar Venta</a>
                            <a href="Controlador?menu=NuevaVenta&accion=Cancelar" class="btn btn-danger" style="margin-left: 10px">Cancelar</a>
                            
                        </div>
                        <div class="d-flex col-sm-4 ml-auto">
                            <label>Total: </label>
                            <input type="text" name="txtTotal" value="$/. ${totalpagar}0" class="form-control">                            
                        </div>
                    </div>
                </div>                
            </div>            
        </div>
        <div  class="accion" id="mensajeExito" style="display:none; color: green; margin-left: 20px;" >
            La venta se ha enviado con éxito.
        </div>
        <div   id="mensajeError" style="display:none; color: red; margin-left: 20px;" >
            ¡Error! No se pudo enviar la venta.
        </div>
       
        <script>
            if(${mensajeError}== true){
                document.getElementById('mensajeError').style.display = 'block';
            }
            
           
        </script>
        
        <script>
             if(${mensajeExito}== true){
                document.getElementById('mensajeExito').style.display = 'block';
            }
        </script>
        
        <script>
                  
           
            if (${ventaExito}) {
                print();  // Llama a la función print() solo si la venta fue exitosa
                setTimeout(function() {
                    window.location.href = 'Controlador?menu=NuevaVenta&accion=ReiniciarLista';
                }, 1000);
            }
            
        </script>
        
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>    
    </body>
</html>
