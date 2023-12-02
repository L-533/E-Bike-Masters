/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import config.GenerarSerie;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author llina
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
    Empleado em = new Empleado();
    EmpleadoDAO edao = new EmpleadoDAO();
    
    Cliente cl = new Cliente();
    ClienteDAO cldao = new ClienteDAO();
    
    Producto pr = new Producto();
    ProductoDAO prdao = new ProductoDAO();
    
    Venta v =  new Venta();
    List<Venta> lista = new ArrayList();
    int item;
    int cod;
    String descripcion;
    double precio;
    int cantidad=1;
    double subtotal;
    double totalPagar;
    
    
    String numeroSerie;
    VentaDAO vdao = new VentaDAO();
    
    java.util.Date ahora = new java.util.Date(); 
    SimpleDateFormat formateador = new SimpleDateFormat("yyyy/MM/dd");
//    Identificadores
    int idEmpleado;  
    int idCliente;
    int idProducto;
    int idVenta;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("cantidad", cantidad);
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (accion == null) {
            accion = "ValorPredeterminado"; 
        }
        System.out.println("Valor de accion: " + accion);
        if(menu.equals("Principal")){
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
            
        }
        
        if(menu.equals("Empleado")){
            switch(accion){
                case "Listar":
                    List lista = edao.listar();
                    request.setAttribute("empleados",lista);
                    break;
                case "Agregar":
                    String dni=request.getParameter("txtDni");
                    String nom=request.getParameter("txtNombres");
                    String tel=request.getParameter("txtTel");
                    String estado=request.getParameter("txtEstado");
                    String user=request.getParameter("txtUser");
                    
                    em.setDni(dni);
                    em.setNom(nom);
                    em.setTel(tel);
                    em.setEstado(estado);
                    em.setUser(user);                    
                    
                    edao.agregar(em);
                    
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Editar":                    
                    idEmpleado=Integer.parseInt(request.getParameter("id"));
                    Empleado e = edao.listarId(idEmpleado);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);

                    break;
                case "Actualizar":
                    String dni_new=request.getParameter("txtDni");
                    String nom_new=request.getParameter("txtNombres");
                    String tel_new=request.getParameter("txtTel");
                    String estado_new=request.getParameter("txtEstado");
                    String user_new=request.getParameter("txtUser");
                    
                    em.setDni(dni_new);
                    em.setNom(nom_new);
                    em.setTel(tel_new);
                    em.setEstado(estado_new);
                    em.setUser(user_new);                    
                    
                    em.setId(idEmpleado);
                    edao.actualizar(em);
                    
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    idEmpleado=0;
                    break;
                case "Delete":
                    idEmpleado=Integer.parseInt(request.getParameter("id"));
                    edao.delete(idEmpleado);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                    
                default:
                throw new AssertionError();
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }
        if(menu.equals("Cliente")){
            switch(accion){
                case "Listar":
                    List lista = cldao.listar();
                    request.setAttribute("clientes",lista);
                    break;
                case "Agregar":
                    String cedula=request.getParameter("txtCedula");
                    String nom=request.getParameter("txtNombres");
                    String direccion=request.getParameter("txtDireccion");
                    String tel=request.getParameter("txtTel");
                                       
                    cl.setCedula(cedula);
                    cl.setNom(nom);
                    cl.setDireccion(direccion);
                    cl.setTel(tel);                                      
                    
                    cldao.agregar(cl);
                    
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Editar":                    
                    idCliente=Integer.parseInt(request.getParameter("id"));
                    Cliente c = cldao.listarId(idCliente);
                    request.setAttribute("cliente", c);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);

                    break;
                case "Actualizar":
                    String cedula_new=request.getParameter("txtCedula");
                    String nom_new=request.getParameter("txtNombres");
                    String direccion_new=request.getParameter("txtDireccion");
                    String tel_new=request.getParameter("txtTel");
                    
                    
                    cl.setCedula(cedula_new);
                    cl.setNom(nom_new);
                    cl.setDireccion(direccion_new);
                    cl.setTel(tel_new);                     
                    
                    cl.setId(idCliente);
                    cldao.actualizar(cl);
                    
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    idCliente=0;
                    break;
                case "Delete":
                    idCliente=Integer.parseInt(request.getParameter("id"));
                    cldao.delete(idCliente);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                    
                default:
                throw new AssertionError();
            }
            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }
        if(menu.equals("Producto")){            
            switch(accion){
                case "Listar":
                    List lista = prdao.listar();
                    System.out.println(lista);
                    request.setAttribute("productos",lista);
                    break;
                case "Agregar":
                    String nom=request.getParameter("txtNombre");
                    double precio=Double.parseDouble(request.getParameter("txtPrecio"));
                    int stock = Integer.parseInt(request.getParameter("txtStock"));
                    String estado=request.getParameter("txtEstado");
                                       
                    pr.setNom(nom);
                    pr.setPrecio(precio);
                    pr.setStock(stock);
                    pr.setEstado(estado);                                      
                    
                    prdao.agregar(pr);
                    
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Editar":                    
                    idProducto=Integer.parseInt(request.getParameter("id"));
                    Producto p = prdao.listarId(idProducto);
                    request.setAttribute("producto", p);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);

                    break;
                case "Actualizar":
                    String nom_new=request.getParameter("txtNombre");
                    double precio_new=Double.parseDouble(request.getParameter("txtPrecio"));
                    int stock_new=Integer.parseInt(request.getParameter("txtStock"));
                    String estado_new=request.getParameter("txtEstado");
                    
                    
                    pr.setNom(nom_new);
                    pr.setPrecio(precio_new);
                    pr.setStock(stock_new);
                    pr.setEstado(estado_new);                     
                    
                    pr.setId(idProducto);
                    prdao.actualizar(pr);
                    
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    idProducto=0;
                    break;
                case "Delete":
                    idProducto=Integer.parseInt(request.getParameter("id"));
                    prdao.delete(idProducto);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                    
                default:
                throw new AssertionError();
            }            
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }
        if(menu.equals("NuevaVenta")){
            switch(accion){
                case "BuscarCliente":
                    String cedula = request.getParameter("CodigoCliente");
                    System.out.println("Buscar cliente con cedula: " + cedula);
                    cl.setCedula(cedula);
                    cl = cldao.buscar(cedula);
                    
                    
                    if (cl != null) {
                        System.out.println("Cliente encontrado: ");
                        request.setAttribute("clienteV", cl);
                        request.setAttribute("nSerie", numeroSerie);
                        request.setAttribute("lista", lista);
                        request.setAttribute("totalpagar", totalPagar);
                        if(pr.getStock() != 0){
                            request.setAttribute("producto", pr); 
                        }
                        
                    } else {
                        // Cliente no encontrado, muestra la notificación en el lado del cliente
                        String mensaje = "Cliente no encontrado con la cédula: " + cedula;
                        request.setAttribute("mensajeError", mensaje);
                    }
                    break;              
                case "BuscarProducto":
                    String codigoProductoStr = request.getParameter("CodigoProducto");
                    int id = (codigoProductoStr != null && !codigoProductoStr.isEmpty()) ? Integer.parseInt(codigoProductoStr) : 0;

                    
                    pr = prdao.listarId(id);
                    request.setAttribute("nSerie", numeroSerie);
                    request.setAttribute("clienteV", cl); 
                    if(pr.getStock() != 0){
                       request.setAttribute("producto", pr); 
                    }
                    
                    request.setAttribute("lista", lista);
                    request.setAttribute("totalpagar", totalPagar);
                    break;  
                case "Agregar":
                    request.setAttribute("nSerie", numeroSerie);
                    request.setAttribute("clienteV", cl); 
                    
                    if(pr.getId()!=0){
                        totalPagar=0.0;
                        item = item+1;
                        cod= pr.getId();
                        descripcion= request.getParameter("NombreProducto"); 
                        precio = Double.parseDouble(request.getParameter("precio"));
                        cantidad = Integer.parseInt(request.getParameter("cantidad"));
                        subtotal = precio*cantidad;
                        v= new Venta();
                        v.setItem(item);
                        v.setIdProducto(cod);
                        v.setDescripcionP(descripcion);
                        v.setPrecio(precio);
                        v.setCantidad(cantidad);
                        v.setSubtotal(subtotal);

                        lista.add(v);
                        for(int i=0; i<lista.size();i++){
                            totalPagar= totalPagar + lista.get(i).getSubtotal();
                        }
                        
                        pr= new Producto();
                    }
                    
                    cantidad=1;
                    request.setAttribute("cantidad", cantidad);
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("lista", lista);
                    break;
                case "GenerarVenta":
                    
                    boolean mensajeError;
                    boolean ventaExito;
                    // Obtener el empleado activo
                    Empleado empleadoActivo = (Empleado) request.getSession().getAttribute("empleadoActivo");

                    // Validar que los valores clave no estén vacíos
                    if (cl.getId() != 0 && empleadoActivo != null && numeroSerie != null && !numeroSerie.isEmpty() && formateador != null && ahora != null && lista.size() != 0) {
                        ventaExito=true;
                        request.setAttribute("ventaExito", ventaExito);   
                        
                        // Crear la venta solo si los valores clave no están vacíos
                        Venta v = new Venta();
                        v.setIdCliente(cl.getId());
                        v.setIdEmpleado(empleadoActivo.getId());
                        v.setNumSerie(numeroSerie);
                        v.setFecha(formateador.format(ahora));
                        v.setMonto(totalPagar);
                        v.setEstado("1");
                        vdao.GuardarVenta(v);

                        // Guardar Detalle Ventas
                        int idv = Integer.parseInt(vdao.IdVentas());
                        for (int i = 0; i < lista.size(); i++) {
                            v = new Venta();
                            v.setId(idv);
                            v.setIdProducto(lista.get(i).getIdProducto());
                            v.setCantidad(lista.get(i).getCantidad());
                            v.setPrecio(lista.get(i).getPrecio());
                            vdao.GuardarDetalleVentas(v);
                        }
                        
                        //Actualizar Stock
                        for (int i = 0; i < lista.size(); i++) {
                            Producto p = new Producto();
                            
                            int cantidad= lista.get(i).getCantidad();
                            int idProducto = lista.get(i).getIdProducto();                           
                            p = prdao.listarId(idProducto);
                            int stockActual= p.getStock() - cantidad;
                            System.out.println("El sock anterior del producto: "+idProducto+" es "+p.getStock());
                            System.out.println("El sock actual del producto: "+idProducto+" es "+stockActual);
                            prdao.actualizarStock(idProducto, stockActual);
                        }
                        
                        pr= new Producto();
                        cl = new Cliente();   
                                             
                        
                        
                        //Actualizar numero de venta
                        request.setAttribute("nSerie", numeroSerie);
                        numeroSerie = vdao.GenererarSerie();                                               
                        int incrementar= Integer.parseInt(numeroSerie);
                        GenerarSerie gs = new GenerarSerie();
                        numeroSerie = gs.NumeroSerie(incrementar);
                        
                        request.setAttribute("lista", lista);
                        request.setAttribute("totalpagar", totalPagar);
                        
                    } else {
                        // Manejar el caso donde algún valor está vacío
                        lista.clear(); // Reiniciar la lista 
                        pr= new Producto();
                        cl = new Cliente();    
                        
                        System.out.println("Error: Alguno de los valores clave está vacío.");
                        mensajeError=true;
                        request.setAttribute("mensajeError", mensajeError);
                        request.setAttribute("nSerie", numeroSerie);
                    }
                                        
//                    lista.clear(); // Reiniciar la lista 
                    break;
                case "ReiniciarLista":
                    boolean mensajeExito;
                    mensajeExito=true;
                    request.setAttribute("mensajeExito", mensajeExito);
                    System.out.println("Ejecutando Reiniciar Lista");
                    
                    totalPagar = 0.0;
                    item = 0;
                    lista.clear(); // Reiniciar la lista 
                    request.setAttribute("nSerie", numeroSerie);
                    break;
                    
                case "Editar":                    
                                                    
                    idVenta=Integer.parseInt(request.getParameter("id"));
                    Venta itemBuscado = null;

                    for (Venta venta : lista) {
                        if (venta.getItem()== idVenta) {
                            itemBuscado = venta;
                            break;
                        }
                    }
                    pr = prdao.listarId(itemBuscado.getIdProducto()); 
                    cantidad= itemBuscado.getCantidad() ;
                    request.setAttribute("cantidad", cantidad);
                    
                    System.out.println("precio de item: "+itemBuscado.getPrecio());
                    pr.setPrecio(itemBuscado.getPrecio());                    
                    
                    request.setAttribute("nSerie", numeroSerie);
                    request.setAttribute("clienteV", cl);                    
                    request.setAttribute("producto", pr);
                    request.setAttribute("lista", lista);
                    request.setAttribute("totalpagar", totalPagar);
                    break;                                       
                case "Actualizar":
                    request.setAttribute("nSerie", numeroSerie);
                    request.setAttribute("clienteV", cl);                     
                     
                    
                    if(pr.getId()!=0){
                        totalPagar=0.0;
                        cod= pr.getId();
                        descripcion= request.getParameter("NombreProducto"); 
                        precio = Double.parseDouble(request.getParameter("precio"));
                        cantidad = Integer.parseInt(request.getParameter("cantidad"));
                        subtotal = precio*cantidad;                                 

                        for (Venta venta : lista) {
                            if (venta.getItem()== idVenta) {
                                venta.setIdProducto(cod);
                                venta.setDescripcionP(descripcion);
                                venta.setPrecio(precio);
                                venta.setCantidad(cantidad);
                                venta.setSubtotal(subtotal);
                                break;
                            }
                        }
                        for(int i=0; i<lista.size();i++){
                            totalPagar= totalPagar + lista.get(i).getSubtotal();
                        }
                        
                        pr= new Producto();
                    }
                    
                    cantidad=1;
                    request.setAttribute("cantidad", cantidad);
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("lista", lista);
                    idVenta=0;
                    
                    break;
                    
                case "Delete":
                    request.setAttribute("nSerie", numeroSerie);
                    request.setAttribute("clienteV", cl);                     
                    totalPagar=0.0;                    
                    idVenta=Integer.parseInt(request.getParameter("id"));                          
                                                            
                    // Buscar y eliminar el elemento con el idVenta
                    Iterator<Venta> iterator = lista.iterator();
                    while (iterator.hasNext()) {
                        Venta venta = iterator.next();
                        if (venta.getItem() == idVenta) {
                            iterator.remove(); // Elimina el elemento actual de la lista
                            break;
                        }
                    }
                    
                    
                    // Actualizar el campo item de todos los elementos en la lista
                    for (int i = 0; i < lista.size(); i++) {
                        Venta venta = lista.get(i);
                        venta.setItem(i + 1); // Puedes ajustar esto según tus necesidades
                    }
                    
                    item = lista.size();
                    for(int i=0; i<lista.size();i++){
                        totalPagar= totalPagar + lista.get(i).getSubtotal();
                    }
                    
                    cantidad=1;
                    request.setAttribute("cantidad", cantidad);
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("lista", lista);
                    idVenta=0;
                    
                    break;
                case "Cancelar":
                    cl = new Cliente();   
                    pr = new Producto();
                    lista.clear(); // Reiniciar la lista 
                    request.setAttribute("nSerie", numeroSerie);
                    break;
                default:
                    
                    numeroSerie = vdao.GenererarSerie();
                    System.out.println("ultimo numero de serie igual a: "+numeroSerie);
                    if(numeroSerie==null){
                        numeroSerie="00000001";
                        request.setAttribute("nSerie", numeroSerie);
                    }
                    
                    else{
                        int incrementar= Integer.parseInt(numeroSerie);
                        GenerarSerie gs = new GenerarSerie();
                        numeroSerie = gs.NumeroSerie(incrementar);
                        request.setAttribute("nSerie", numeroSerie);
                    }
                    
                   
                    
            }            
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }
        if(menu.equals("Logout")){
            cl = new Cliente();   
            pr = new Producto();
            lista.clear(); // Reiniciar la lista después de generar la venta
            totalPagar = 0.0;
            item = 0;
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
