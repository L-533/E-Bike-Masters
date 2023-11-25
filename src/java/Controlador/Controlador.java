/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import java.io.IOException;
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
    
    
    int ide;  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
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
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }
        if(menu.equals("NuevaVenta")){
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
