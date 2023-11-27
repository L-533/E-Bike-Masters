/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author llina
 */
public class ProductoDAO {
    Conexion cn = Conexion.getInstance();  // Obtener la instancia Singleton
    Connection con = cn.getConexion();  // Obtener la conexión desde la instancia Singleton
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    
    
    //Operaciones CRUD
    
    public List listar(){
        String sql="select * from producto";
        List<Producto>lista= new ArrayList<>();
        try{
            con.setAutoCommit(false); // Habilitar el modo de autocommit
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            con.commit(); // Realizar el commit de la transacción
            while(rs.next()){
                Producto pr = new Producto();
                pr.setId(rs.getInt(1));
                pr.setNom(rs.getString(2));
                pr.setPrecio(rs.getDouble(3));
                pr.setStock(rs.getInt(4));
                pr.setEstado(rs.getString(5));

                lista.add(pr);
            }
        } catch(Exception e){
            
        }
        return lista;
        
    }
    
    public int agregar(Producto pr){
        String sql="INSERT INTO producto (Nombre, Precio, Stock, Estado) VALUES (?, ?, ?, ?)";
        
        try{            
            if (con != null) {
            System.out.println("Conexión establecida correctamente");
            System.out.println("registrando usuario:" + pr.getNom() + pr.getPrecio()+pr.getStock()+ pr.getEstado());
            con.setAutoCommit(false); // Habilitar el modo de autocommit
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getNom());
            ps.setDouble(2, pr.getPrecio());
            ps.setInt(3, pr.getStock());
            ps.setString(4, pr.getEstado());
            
            ps.executeUpdate();
            con.commit(); // Realizar el commit de la transacción
                        
            } else {
                System.out.println("Error: No se pudo establecer la conexión");
            } 
        } catch(Exception e){            
            
        }
        return r;
       
    }
    
    public Producto listarId(int id){
        Producto pr= new Producto();
        String sql="SELECT * FROM producto WHERE IdProducto = ?";
        
        try{
            System.out.println("ListarId ejecutandose con id="+id);
            con.setAutoCommit(false); // Habilitar el modo de autocommit
            ps = con.prepareStatement(sql);
            ps.setInt(1, id); // Establecer el valor del parámetro
            rs = ps.executeQuery();
            con.commit(); // Realizar el commit de la transacción

            while (rs.next()){   
                pr.setId(rs.getInt(1));
                pr.setNom(rs.getString(2));
                pr.setPrecio(rs.getDouble(3));
                pr.setStock(rs.getInt(4));
                pr.setEstado(rs.getString(5));                
                
            }
        } catch(Exception e){
            
        }
        
        return pr;
    }
    public int actualizar(Producto pr){
        String sql="update producto set Nombre=?, Precio=?, Stock=?, Estado=? where IdProducto=?";
        
        try{
            con.setAutoCommit(false); // Habilitar el modo de autocommit            
            ps=con.prepareStatement(sql);
            ps.setString(1, pr.getNom());
            ps.setDouble(2, pr.getPrecio());
            ps.setInt(3, pr.getStock());
            ps.setString(4, pr.getEstado());
            ps.setInt(5, pr.getId());
            ps.executeUpdate();
            con.commit(); // Realizar el commit de la transacción
            
        } catch(Exception e){
            
            
        }
        return r;
        
    }
    public void delete(int id){
        String sql="delete from producto where IdProducto="+id;
        try{
            con.setAutoCommit(false); // Habilitar el modo de autocommit            
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            con.commit(); // Realizar el commit de la transacción
        } catch(Exception e){
            
        }
    }
}
