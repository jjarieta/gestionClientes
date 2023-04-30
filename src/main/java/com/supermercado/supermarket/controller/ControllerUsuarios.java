/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.supermercado.supermarket.controller;

import com.supermercado.supermarket.model.ClsUsuarios;
import com.supermercado.supermarket.model.ClsUsuariosDAO;
import com.supermercado.supermarket.view.frmUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author JJARRIETA
 */
public class ControllerUsuarios implements ActionListener { 

    private ClsUsuarios ObjUsuarios;
    private ClsUsuariosDAO ObjUsariosDAO;
    private frmUsuarios ObjFrmUsuarios;
    
   public ControllerUsuarios(ClsUsuarios ObjUsuarios,ClsUsuariosDAO ObjUsariosDAO,frmUsuarios ObjFrmUsuarios){
       this.ObjUsuarios=ObjUsuarios;
       this.ObjUsariosDAO=ObjUsariosDAO;
       this.ObjFrmUsuarios=ObjFrmUsuarios;
       this.ObjFrmUsuarios.btnGuardar.addActionListener(this);
       this.ObjFrmUsuarios.btnBuscar .addActionListener(this);
       this.ObjFrmUsuarios.btnActualizar.addActionListener(this);
       this.ObjFrmUsuarios.btnEliminar.addActionListener(this);
       
       this.ObjFrmUsuarios.btnActualizar.setEnabled(false);
       this.ObjFrmUsuarios.btnEliminar.setEnabled(false);
      
       
   }
   
   public void IniciarFrm(){
	ObjFrmUsuarios.setTitle("Gestión de Usuarios"); // establecer titulo del formulario
	ObjFrmUsuarios.setLocationRelativeTo(null); // posicion del formulario centrado
		
	}
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //BOTO GUARDAR -  JJAN
       if(e.getSource() == ObjFrmUsuarios.btnGuardar){
            ObjUsuarios.setStrTipoNip((String) ObjFrmUsuarios.CbxTipoNip.getSelectedItem());
            
            //Validacion de campos al guardar un cliente            
            if (!ObjFrmUsuarios.txtNip.getText().isEmpty()){
                ObjUsuarios.setDoubNip(Double.parseDouble(ObjFrmUsuarios.txtNip.getText()));
            }else{
                JOptionPane.showMessageDialog(null, "El campo NIP es obligatorio");
                ObjFrmUsuarios.txtNip.requestFocus();
                return;
            }
            
            if (!ObjFrmUsuarios.txtNombres.getText().isEmpty()){
               ObjUsuarios.setStrNombres(ObjFrmUsuarios.txtNombres.getText());
            }else{
                JOptionPane.showMessageDialog(null, "El campo NOMBRES es obligatorio");
                ObjFrmUsuarios.txtNombres.requestFocus();
                return;
            }
            
            if (!ObjFrmUsuarios.txtApellidos.getText().isEmpty()){
              ObjUsuarios.setStrApellidos(ObjFrmUsuarios.txtApellidos .getText());
            }else{
                JOptionPane.showMessageDialog(null, "El campo APELLIDOS es obligatorio");
                ObjFrmUsuarios.txtApellidos.requestFocus();
                return;
            }
            
             if (!ObjFrmUsuarios.txtDireccion.getText().isEmpty()){
              ObjUsuarios.setStrDireccion(ObjFrmUsuarios.txtDireccion.getText());
            }else{
                JOptionPane.showMessageDialog(null, "El campo DIRECCIÓN es obligatorio");
                ObjFrmUsuarios.txtDireccion.requestFocus();
                return;
            }
            
             if (!ObjFrmUsuarios.txtTelefono.getText().isEmpty()){
              ObjUsuarios.setStrTelefono(ObjFrmUsuarios.txtTelefono.getText());
            }else{
                JOptionPane.showMessageDialog(null, "El campo TELÉFONO es obligatorio");
                ObjFrmUsuarios.txtTelefono.requestFocus();
                return;
            }
            
           
            ObjUsuarios.setStrGenero((String) ObjFrmUsuarios.cbxGenero.getSelectedItem());
            
            if(ObjUsariosDAO.AgregarUsuario(ObjUsuarios)){
                JOptionPane.showMessageDialog(null, "Cliente Registrado Correctamente");
                LimpiarCampos();

		} else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");	
                LimpiarCampos();
		}
            this.ObjFrmUsuarios.btnActualizar.setEnabled(false);
            this.ObjFrmUsuarios.btnEliminar.setEnabled(false);
       }
       
        if(e.getSource() == ObjFrmUsuarios.btnActualizar){
          ObjUsuarios.setStrTipoNip((String) ObjFrmUsuarios.CbxTipoNip.getSelectedItem());
            ObjUsuarios.setDoubNip(Double.parseDouble(ObjFrmUsuarios.txtNip.getText()));
            ObjUsuarios.setStrNombres(ObjFrmUsuarios.txtNombres.getText());
            ObjUsuarios.setStrApellidos(ObjFrmUsuarios.txtApellidos .getText());
            ObjUsuarios.setStrDireccion(ObjFrmUsuarios.txtDireccion.getText());
            ObjUsuarios.setStrTelefono(ObjFrmUsuarios.txtTelefono.getText());
            ObjUsuarios.setStrGenero((String) ObjFrmUsuarios.cbxGenero.getSelectedItem());
            
            if(ObjUsariosDAO.ActualizarUsuario(ObjUsuarios)){
                
                JOptionPane.showMessageDialog(null, "Cliente Modificado Correctamente");
                LimpiarCampos();
                
		} else {
                JOptionPane.showMessageDialog(null, "Error al Modificar el cliente: "+ ObjUsuarios.getDoubNip());	
                LimpiarCampos();
		}
            this.ObjFrmUsuarios.btnActualizar.setEnabled(false);
            this.ObjFrmUsuarios.btnEliminar.setEnabled(false);
            
        }
        
        //BOTON BUSCAR  - JJAN
         if(e.getSource() == ObjFrmUsuarios.btnBuscar){
             if (ObjFrmUsuarios.txtNip.getText().trim().isEmpty()){
             JOptionPane.showMessageDialog(null, "El Campo NIP es obligatorio para la búsqueda");
             ObjFrmUsuarios.txtNip.requestFocus();
             }else{
             ObjUsuarios.setDoubNip(Double.parseDouble(ObjFrmUsuarios.txtNip.getText()));
                if (ObjUsariosDAO.BuscarUsuario(ObjUsuarios)){
                    
                    //Valores para la vista
                    ObjFrmUsuarios.CbxTipoNip.setSelectedItem(ObjUsuarios.getStrTipoNip());
                    ObjFrmUsuarios.txtNombres.setText(ObjUsuarios.getStrNombres() );
                    ObjFrmUsuarios.txtApellidos.setText(ObjUsuarios.getStrApellidos());
                    ObjFrmUsuarios.txtDireccion.setText(ObjUsuarios.getStrDireccion());
                    ObjFrmUsuarios.txtTelefono.setText(ObjUsuarios.getStrTelefono());
                    ObjFrmUsuarios.cbxGenero.setSelectedItem(ObjUsuarios.getStrGenero());
                    
                    //habilitar botones para Actualizar o Eliminar
                    ObjFrmUsuarios.btnActualizar.setEnabled(true);
                    ObjFrmUsuarios.btnEliminar.setEnabled(true);
                    JOptionPane.showMessageDialog(null, "El cliente con NIP : "+ ObjUsuarios.getDoubNip()+ " se encuentra registrado en la BD");
                }else{
                JOptionPane.showMessageDialog(null, "El cliente con NIP : "+ ObjUsuarios.getDoubNip()+ " NO se encuentra registrado en la BD");
                LimpiarCampos();
                }
             }
             
        }
         
          if(e.getSource() == ObjFrmUsuarios.btnEliminar){
              if (ObjFrmUsuarios.txtNip.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "El Campo NIP es obligatorio para Eliminar");
                ObjFrmUsuarios.txtNip.requestFocus();
             }else{
                  ObjUsuarios.setDoubNip(Double.parseDouble(ObjFrmUsuarios.txtNip.getText().trim()));
                  if(ObjUsariosDAO.EliminarUsuario(ObjUsuarios)){
                      JOptionPane.showMessageDialog(null, "Registro Eliminado");
                      LimpiarCampos();
                  }else{
                       JOptionPane.showMessageDialog(null, "Error al Eliminar");
                  }
                  this.ObjFrmUsuarios.btnActualizar.setEnabled(false);
            this.ObjFrmUsuarios.btnEliminar.setEnabled(false);
              }
          }
        
    }
    
    
    //Limpiar Campos del Formularios
    public void LimpiarCampos(){
    
        ObjFrmUsuarios.CbxTipoNip.setSelectedIndex(0);
        ObjFrmUsuarios.txtNip.setText("");
        ObjFrmUsuarios.txtNombres.setText("");
        ObjFrmUsuarios.txtApellidos.setText("");
        ObjFrmUsuarios.txtDireccion.setText("");
        ObjFrmUsuarios.txtTelefono.setText("");
        ObjFrmUsuarios.cbxGenero.setSelectedIndex(0);
        ObjFrmUsuarios.txtNip.requestFocus();
        
    }
    
    
    
    
    
}
