package com.supermercado.supermarket;

import com.supermercado.supermarket.controller.ControllerUsuarios;
import com.supermercado.supermarket.model.ClsUsuarios;
import com.supermercado.supermarket.model.ClsUsuariosDAO;
import com.supermercado.supermarket.view.frmUsuarios;

    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author JJARRIETA
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ClsUsuarios ModeloUsuario = new ClsUsuarios();
        ClsUsuariosDAO ModeloUsuarioDao = new ClsUsuariosDAO();
        frmUsuarios FrmUser = new frmUsuarios();

        ControllerUsuarios ctrl = new ControllerUsuarios(ModeloUsuario,ModeloUsuarioDao,FrmUser);

        ctrl.IniciarFrm();
       
        FrmUser.setVisible(true);
    }
    
}
