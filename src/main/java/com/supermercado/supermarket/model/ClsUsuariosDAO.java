/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.supermercado.supermarket.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JJARRIETA
 */
public class ClsUsuariosDAO extends ClsConexion {
    
    public boolean AgregarUsuario(ClsUsuarios usuario){
        
        PreparedStatement ps = null;
        Connection con = getConexion();        
        String sql = "INSERT INTO tblclientes (TipoNip,Nip,Nombres,Apellidos,Direccion,Telefono,Genero) VALUES (?,?,?,?,?,?,?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getStrTipoNip());
            ps.setDouble(2, usuario.getDoubNip()) ;
            ps.setString(3, usuario.getStrNombres() );
            ps.setString(4, usuario.getStrApellidos());
            ps.setString(5, usuario.getStrDireccion());
            ps.setString(6, usuario.getStrTelefono());
            ps.setString(7, usuario.getStrGenero());            
            ps.execute();            
            return true;           
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
                System.out.println("Cerrar conexion registrar");
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }  
    
    public boolean BuscarUsuario(ClsUsuarios usuario){        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();        
        String sql = "SELECT * FROM tblclientes WHERE Nip=?";
        
        try{
            ps = con.prepareStatement(sql);  
            ps.setDouble(1, usuario.getDoubNip());
            rs = ps.executeQuery();            
            if(rs.next()){       
                
                usuario.setStrTipoNip(rs.getString("TipoNip"));
                usuario.setDoubNip(Double.parseDouble(rs.getString("Nip")));
                usuario.setStrNombres(rs.getString("Nombres"));
                usuario.setStrApellidos(rs.getString("Apellidos"));
                usuario.setStrDireccion(rs.getString("Direccion"));
                usuario.setStrTelefono(rs.getString("Telefono"));
                usuario.setStrGenero(rs.getString("Genero"));
                 return true;
            }

            return false;
            
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
                System.out.println("Cerrar conexion buscar");
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }  
    
    public boolean ActualizarUsuario(ClsUsuarios usuario){
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "UPDATE tblclientes SET TipoNip=?,Nombres=?,Apellidos=?,Direccion=?,Telefono=?,Genero=? WHERE Nip=?";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getStrTipoNip());
            ps.setString(2, usuario.getStrNombres() );
            ps.setString(3, usuario.getStrApellidos());
            ps.setString(4, usuario.getStrDireccion());
            ps.setString(5, usuario.getStrTelefono());
            ps.setString(6, usuario.getStrGenero());
            ps.setDouble(7, usuario.getDoubNip()) ;
            ps.execute();
            
            return true;
            
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
                System.out.println("Cerrar conexion modificar");
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }  
    
    public boolean EliminarUsuario(ClsUsuarios usuario){
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "DELETE FROM tblclientes WHERE Nip=?";
        
        try{
            
            ps = con.prepareStatement(sql);  
            ps.setDouble(1, usuario.getDoubNip());
            ps.execute();
            
            return true;
            
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
                System.out.println("Cerrar conexion eliminar");
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    
    

}
