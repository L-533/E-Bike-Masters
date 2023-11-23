/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

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
                    
                    break;
                case "Delete":
                    
                    break;
                    
                default:
                throw new AssertionError();
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }
        if(menu.equals("Cliente")){
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
