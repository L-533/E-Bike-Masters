/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
//        switch (accion) {
//            case "Principal":
//                System.out.println("esto es Principal...");
//                request.getRequestDispatcher("Principal.jsp").forward(request, response);
//                break;
//            case "Producto":
//                System.out.println("esto es Principal...");
//                request.getRequestDispatcher("Producto.jsp").forward(request, response);
//                break;
//            case "Cliente":
//                System.out.println("esto es Principal...");
//                request.getRequestDispatcher("Clientes.jsp").forward(request, response);
//                break;
//            case "Empleado":
//                System.out.println("esto es Principal...");
//                request.getRequestDispatcher("Empleado.jsp").forward(request, response);
//                break;
//            case "NuevaVenta":
//                System.out.println("esto es Principal...");
//                request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
//                break;
//            default:
//                throw new AssertionError();
//        }
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
