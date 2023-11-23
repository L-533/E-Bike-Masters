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
public class EmpleadoDAO {
    Conexion cn = Conexion.getInstance();  // Obtener la instancia Singleton
    Connection con = cn.getConexion();  // Obtener la conexión desde la instancia Singleton
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Empleado validar(String user, String dni){
        Empleado em=new Empleado();
        String sql= "SELECT * FROM empleado WHERE User = ? AND Dni = ?";        
        System.out.println("Conexión a la base de datos establecida: " + (con != null));

        try{
            
            ps=con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, dni);
            rs=ps.executeQuery();
            while (rs.next()){
                em.setId(rs.getInt("IdEmpleado"));
                em.setUser(rs.getString("User"));
                em.setDni(rs.getString("Dni"));
                em.setNom(rs.getString("Nombres"));
            }
        }catch (Exception e){
            
        }
        return em;
    }
    
    //Operaciones CRUD
    
    public List listar(){
        String sql="select * from empleado";
        List<Empleado>lista= new ArrayList<>();
        try{           
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Empleado em = new Empleado();
                em.setId(rs.getInt(1));
                em.setDni(rs.getString(2));
                em.setNom(rs.getString(3));
                em.setTel(rs.getString(4));
                em.setEstado(rs.getString(5));
                em.setUser(rs.getString(6));
                lista.add(em);
            }
        } catch(Exception e){
            
        }
        return lista;
        
    }
    
    public int agregar(Empleado em){
        String sql="INSERT INTO empleado (Dni, Nombres, Telefono, Estado, User) VALUES (?, ?, ?, ?, ?)";
        
        try{            
            if (con != null) {
            System.out.println("Conexión establecida correctamente");
            System.out.println("registrando usuario:" + em.getDni()+ em.getNom() + em.getTel()+ em.getEstado()+em.getUser());
            con.setAutoCommit(false); // Habilitar el modo de autocommit
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUser());
            ps.executeUpdate();
            con.commit(); // Realizar el commit de la transacción
                        
            } else {
                System.out.println("Error: No se pudo establecer la conexión");
            } 
        } catch(Exception e){            
            
        }
        return r;
       
    }
    
    public Empleado listarId(int id){
        Empleado em= new Empleado();
        String sql="select * from empleado where IdEmpleado"+id;
        
        try{            
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){               
                em.setDni(rs.getString(2));
                em.setNom(rs.getString(3));
                em.setTel(rs.getString(4));
                em.setEstado(rs.getString(5));
                em.setUser(rs.getString(6));
            }
        } catch(Exception e){
            
        }
        
        return em;
    }
    public int actualizar(Empleado em){
        String sql="update empleado set Dni=?, Nombres=?, Telefono=?, Estado=?, User=? where IdEmpleado=?";
        
        try{            
            ps=con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUser());
            ps.setInt(6, em.getId());
            ps.executeUpdate();
            
        } catch(Exception e){
            
            
        }
        return r;
        
    }
    public void delete(int id){
        String sql="delete from empleado where IdEmpleado="+id;
        try{            
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch(Exception e){
            
        }
    }
   
}
