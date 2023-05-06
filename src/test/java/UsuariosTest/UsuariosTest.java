/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UsuariosTest;

import com.supermercado.supermarket.model.ClsUsuarios;
import com.supermercado.supermarket.model.ClsUsuariosDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author JJARRIETA
 */
public class UsuariosTest {
    
    @Test
    public void AgregarUsuarioTest(){
        Double nip =12341414.0;
        ClsUsuarios objUsuario = new ClsUsuarios();
        ClsUsuariosDAO objUsuarioDAO = new ClsUsuariosDAO();
        objUsuario.setStrTipoNip("CC");
        objUsuario.setDoubNip(nip);
        objUsuario.setStrNombres("JOSE");
        objUsuario.setStrApellidos("ARRIETA");
        objUsuario.setStrDireccion("CL 12 12 12");
        objUsuario.setStrTelefono("0001222332");
        objUsuario.setStrGenero("MASCULINO");
        boolean _Respuesta =objUsuarioDAO.AgregarUsuario(objUsuario);
        System.out.print(_Respuesta);
        Assertions.assertTrue(_Respuesta,"ERROR AL GUARDAR EL USUARIO");
        
    }
    
    @Test
    public void BuscarUsuarioTest(){
        Double Nip =123457.0;
        ClsUsuarios objUsuario = new ClsUsuarios();
        ClsUsuariosDAO objUsuarioDAO = new ClsUsuariosDAO();
        objUsuario.setDoubNip(Nip);
        boolean _Respuesta = objUsuarioDAO.BuscarUsuario(objUsuario);
        Assertions.assertTrue(_Respuesta,"EL NIP: "+ objUsuario.getDoubNip()+" NO SE ENCUENTRA EN LA BD ");
        
    }
    
     @Test
    public void ActualizarUsuarioTest(){
       Double nip =123457.0;
        ClsUsuarios objUsuario = new ClsUsuarios();
        ClsUsuariosDAO objUsuarioDAO = new ClsUsuariosDAO();
        objUsuario.setStrTipoNip("CC");
        objUsuario.setDoubNip(nip);
        objUsuario.setStrNombres("JOSE JORGE");
        objUsuario.setStrApellidos("ARRIETA");
        objUsuario.setStrDireccion("CL 12 12 12");
        objUsuario.setStrTelefono("3505556177");
        objUsuario.setStrGenero("MASCULINO");
        boolean _Respuesta =objUsuarioDAO.ActualizarUsuario(objUsuario);
        System.out.print(_Respuesta);      
        Assertions.assertTrue(_Respuesta,"EL NIP: "+ objUsuario.getDoubNip()+" NO SE PUDO ACTUALIZAR");
        
    }
    
     @Test
    public void EliminarUsuarioTest(){
      
        ClsUsuarios objUsuario = new ClsUsuarios();
        ClsUsuariosDAO objUsuarioDAO = new ClsUsuariosDAO();
      // objUsuario.setDoubNip(123444999.0);
        boolean _Respuesta =objUsuarioDAO.EliminarUsuario(objUsuario);
        System.out.print(_Respuesta);      
        Assertions.assertTrue(_Respuesta,"EL NIP: "+ objUsuario.getDoubNip()+" NO SE PUDO ELIMINAR O NO EXISTE");
        
    }
}
