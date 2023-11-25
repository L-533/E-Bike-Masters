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
public class ClienteDAO {
    Conexion cn = Conexion.getInstance();  // Obtener la instancia Singleton
    Connection con = cn.getConexion();  // Obtener la conexión desde la instancia Singleton
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    
    
    //Operaciones CRUD
    
    public List listar(){
        String sql="select * from cliente";
        List<Cliente>lista= new ArrayList<>();
        try{           
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Cliente cl = new Cliente();
                cl.setId(rs.getInt(1));
                cl.setCedula(rs.getString(2));
                cl.setNom(rs.getString(3));
                cl.setDireccion(rs.getString(4));
                cl.setTel(rs.getString(5));

                lista.add(cl);
            }
        } catch(Exception e){
            
        }
        return lista;
        
    }
    
    public int agregar(Cliente cl){
        String sql="INSERT INTO cliente (Cedula, Nombres, Direccion, Telefono) VALUES (?, ?, ?, ?)";
        
        try{            
            if (con != null) {
            System.out.println("Conexión establecida correctamente");
            System.out.println("registrando usuario:" + cl.getCedula()+ cl.getNom() + cl.getDireccion()+cl.getTel());
            con.setAutoCommit(false); // Habilitar el modo de autocommit
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getCedula());
            ps.setString(2, cl.getNom());
            ps.setString(3, cl.getDireccion());
            ps.setString(4, cl.getTel());
            
            ps.executeUpdate();
            con.commit(); // Realizar el commit de la transacción
                        
            } else {
                System.out.println("Error: No se pudo establecer la conexión");
            } 
        } catch(Exception e){            
            
        }
        return r;
       
    }
    
    public Cliente listarId(int id){
        Cliente cl= new Cliente();
        String sql="SELECT * FROM cliente WHERE IdCliente = ?";
        
        try{
            System.out.println("ListarId ejecutandose con id="+id);
            con.setAutoCommit(false); // Habilitar el modo de autocommit
            ps = con.prepareStatement(sql);
            ps.setInt(1, id); // Establecer el valor del parámetro
            rs = ps.executeQuery();
            con.commit(); // Realizar el commit de la transacción

            while (rs.next()){               
                cl.setCedula(rs.getString(2));
                cl.setNom(rs.getString(3));
                cl.setDireccion(rs.getString(4));
                cl.setTel(rs.getString(5));                
                
            }
        } catch(Exception e){
            
        }
        
        return cl;
    }
    public int actualizar(Cliente cl){
        String sql="update cliente set Cedula=?, Nombres=?, Direccion=?, Telefono=? where IdCliente=?";
        
        try{
            con.setAutoCommit(false); // Habilitar el modo de autocommit            
            ps=con.prepareStatement(sql);
            ps.setString(1, cl.getCedula());
            ps.setString(2, cl.getNom());
            ps.setString(3, cl.getDireccion());
            ps.setString(4, cl.getTel());
            ps.setInt(5, cl.getId());
            ps.executeUpdate();
            con.commit(); // Realizar el commit de la transacción
            
        } catch(Exception e){
            
            
        }
        return r;
        
    }
    public void delete(int id){
        String sql="delete from cliente where IdCliente="+id;
        try{
            con.setAutoCommit(false); // Habilitar el modo de autocommit            
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            con.commit(); // Realizar el commit de la transacción
        } catch(Exception e){
            
        }
    }
}
