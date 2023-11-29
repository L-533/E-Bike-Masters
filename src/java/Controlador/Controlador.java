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
    int cantidad;
    double subtotal;
    double totalPagar;
    
    String numeroSerie;
    VentaDAO vdao = new VentaDAO();
    
    java.util.Date ahora = new java.util.Date(); 
    SimpleDateFormat formateador = new SimpleDateFormat("yyyy/MM/dd");
    
    int ide;  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
                    ide=Integer.parseInt(request.getParameter("id"));
                    Empleado e = edao.listarId(ide);
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
                    
                    em.setId(ide);
                    edao.actualizar(em);
                    
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ide=Integer.parseInt(request.getParameter("id"));
                    edao.delete(ide);
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
                    ide=Integer.parseInt(request.getParameter("id"));
                    Cliente c = cldao.listarId(ide);
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
                    
                    cl.setId(ide);
                    cldao.actualizar(cl);
                    
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ide=Integer.parseInt(request.getParameter("id"));
                    cldao.delete(ide);
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
                    ide=Integer.parseInt(request.getParameter("id"));
                    Producto p = prdao.listarId(ide);
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
                    
                    pr.setId(ide);
                    prdao.actualizar(pr);
                    
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ide=Integer.parseInt(request.getParameter("id"));
                    prdao.delete(ide);
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
                    String cedula=request.getParameter("CodigoCliente");
                    System.out.println("Buscar cliente con cedula: "+cedula);    
                    cl.setCedula(cedula);
                    cl = cldao.buscar(cedula);
                    System.out.println("Buscar cliente con nombre: "+cl); 
                    request.setAttribute("clienteV", cl);
                    request.setAttribute("nSerie", numeroSerie);
                    break;              
                case "BuscarProducto":
                    int id=Integer.parseInt(request.getParameter("CodigoProducto"));
                    
                    pr = prdao.listarId(id);
                    request.setAttribute("nSerie", numeroSerie);
                    request.setAttribute("clienteV", cl);                    
                    request.setAttribute("producto", pr);
                    request.setAttribute("lista", lista);
                    request.setAttribute("totalpagar", totalPagar);
                    break;  
                case "Agregar":
                    request.setAttribute("nSerie", numeroSerie);
                    request.setAttribute("clienteV", cl); 
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
                    
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("lista", lista);
                    break;
                case "GenerarVenta":
                    //Guardar Venta
                    Empleado empleado = (Empleado) request.getSession().getAttribute("empleado");
                    v.setIdCliente(cl.getId());
                    v.setIdEmpleado(empleado.getId());
                    v.setNumSerie(numeroSerie);
                    v.setFecha(formateador.format(ahora));
                    v.setMonto(totalPagar);
                    v.setEstado("1");
                    vdao.GuardarVenta(v);
                    
                    //Guardar Detalle Ventas
                    int idv= Integer.parseInt(vdao.IdVentas());
                    for(int i=0;i<lista.size();i++){
                        v = new Venta();
                        v.setId(idv);
                        v.setIdProducto(lista.get(i).getIdProducto());
                        v.setCantidad(lista.get(i).getCantidad());
                        v.setPrecio(lista.get(i).getPrecio());
                        vdao.GuardarDetalleVentas(v);
                    }
                    
                    lista.clear(); // Reiniciar la lista después de generar la venta
                    totalPagar = 0.0; 
                    item=0;
                    break;
                default:
                    numeroSerie = vdao.GenererarSerie();
                    System.out.println("numero de serie igual a: "+numeroSerie);
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
                    
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                    
            }            
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
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
