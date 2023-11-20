/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        System.out.println("Valor de accion: " + accion);
        switch (accion) {
            case "Principal":
                System.out.println("esto es Principal...");
                request.getRequestDispatcher("Principal.jsp").forward(request, response);
                break;
            case "Producto":
                System.out.println("esto es Principal...");
                request.getRequestDispatcher("Producto.jsp").forward(request, response);
                break;
            case "Cliente":
                System.out.println("esto es Principal...");
                request.getRequestDispatcher("Clientes.jsp").forward(request, response);
                break;
            case "Empleado":
                System.out.println("esto es Principal...");
                request.getRequestDispatcher("Empleado.jsp").forward(request, response);
                break;
            case "NuevaVenta":
                System.out.println("esto es Principal...");
                request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                break;
            default:
                throw new AssertionError();
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
