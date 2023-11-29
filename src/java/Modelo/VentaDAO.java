/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author llina
 */
public class VentaDAO {
    Conexion cn = Conexion.getInstance();  // Obtener la instancia Singleton
    Connection con = cn.getConexion();  // Obtener la conexión desde la instancia Singleton
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    
    public String GenererarSerie(){
        String numeroSerie="";
        String sql = "select max(NumeroSerie) from ventas";
        
        try{
            con.setAutoCommit(false); // Habilitar el modo de autocommit 
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            con.commit(); // Realizar el commit de la transacción
            while(rs.next()){
                numeroSerie = rs.getString(1);
            }
        }catch(Exception e){
            
        }        
        return numeroSerie;
    }
    
    public String IdVentas(){
        String idVentas="";
        String sql = "select max(IdVentas) from ventas";
        
        try{
            con.setAutoCommit(false); // Habilitar el modo de autocommit 
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            con.commit(); // Realizar el commit de la transacción
            while(rs.next()){
                idVentas = rs.getString(1);
            }
        }catch(Exception e){
            
        }    
        
        return idVentas;
    }
    public int GuardarVenta(Venta v){
        String sql="INSERT INTO ventas (IdCliente, IdEmpleado, NumeroSerie, FechaVentas, Monto, Estado) VALUES (?, ?, ?, ?, ?, ?)";
        
        try{            
            if (con != null) {
            System.out.println("Conexión establecida correctamente");
           
            con.setAutoCommit(false); // Habilitar el modo de autocommit
            ps = con.prepareStatement(sql);
            ps.setInt(1, v.getIdCliente());
            ps.setInt(2, v.getIdEmpleado());
            ps.setString(3, v.getNumSerie());
            ps.setString(4, v.getFecha());
            ps.setDouble(5, v.getMonto());
            ps.setString(6, v.getEstado());
            
            ps.executeUpdate();
            con.commit(); // Realizar el commit de la transacción
                        
            } else {
                System.out.println("Error: No se pudo establecer la conexión");
            } 
        } catch(Exception e){            
            
        }
        return r;
       
    }
    
    public int GuardarDetalleVentas(Venta v){
        String sql="INSERT INTO detalle_ventas (IdVentas, IdProducto, Cantidad, PrecioVenta) VALUES (?, ?, ?, ?)";
        
        try{            
            if (con != null) {
            System.out.println("Conexión establecida correctamente");           
            con.setAutoCommit(false); // Habilitar el modo de autocommit
            ps = con.prepareStatement(sql);
            ps.setInt(1, v.getId());
            ps.setInt(2, v.getIdProducto());
            ps.setInt(3, v.getCantidad());
            ps.setDouble(4, v.getPrecio());
            
            ps.executeUpdate();
            con.commit(); // Realizar el commit de la transacción
                        
            } else {
                System.out.println("Error: No se pudo establecer la conexión");
            } 
        } catch(Exception e){            
            
        }
        return r;
       
    }
}
