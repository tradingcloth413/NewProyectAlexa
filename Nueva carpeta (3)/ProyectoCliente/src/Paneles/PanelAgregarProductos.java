/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import Interfaces.IProductos;
import Interfaces.IProductosController;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import proyectocliente.RMI;

/**
 *
 * @author tress
 */
public class PanelAgregarProductos extends javax.swing.JPanel {

     private JDialog dialogParent;
   
    public PanelAgregarProductos(JDialog dialogParent) {
        initComponents();
         this.dialogParent = dialogParent;
         
         
    
    
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombreLabel = new javax.swing.JLabel();
        telefonoLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        aceptarButton = new javax.swing.JButton();
        nombreTextField = new javax.swing.JTextField();
        detallesTextField = new javax.swing.JTextField();
        precioTextField = new javax.swing.JTextField();
        cantidadTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        nombreLabel.setText("Nombre:");

        telefonoLabel.setText("Detalles");

        emailLabel.setText("Precio");

        aceptarButton.setText("Aceptar");
        aceptarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Cantidad");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(301, Short.MAX_VALUE)
                .addComponent(aceptarButton)
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(telefonoLabel)
                                .addComponent(emailLabel))
                            .addGap(32, 32, 32))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(nombreLabel)
                            .addGap(33, 33, 33)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nombreTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(precioTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(detallesTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(cantidadTextField))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreLabel)
                    .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefonoLabel)
                    .addComponent(detallesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel)
                    .addComponent(precioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantidadTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(21, 21, 21)
                .addComponent(aceptarButton)
                .addGap(31, 31, 31))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarButtonActionPerformed
        
        try {
            
            String nombre = nombreTextField.getText();
            String detalles = detallesTextField.getText();
            
            String cantidad = cantidadTextField.getText();
            
       
            
            String Sprecio= precioTextField.getText();
             double precio = Double.parseDouble(Sprecio);
           
            IProductos productos =  RMI.getIProductosController().newInstance();
            
            if(nombre.length()== 0){
            JOptionPane.showMessageDialog(
                    this, 
                    "Ingrese nombre",
                    "Validacion",
                    JOptionPane.ERROR_MESSAGE);
            nombreTextField.requestFocus();
            return ;
            }else{
            
            productos.setNombre(nombre);
            
            }
            if (detalles.length() == 0){
                 JOptionPane.showMessageDialog(
                    this, 
                    "Ingrese nombre",
                    "Validacion",
                    JOptionPane.ERROR_MESSAGE);
            detallesTextField.requestFocus();
            return ;
            }else{    
                    productos.setDetalles(detalles);
            }
            
            if (precio <= 0) {
             JOptionPane.showMessageDialog(
                    this, 
                    "Ingrese el precio",
                    "Validacion",
                    JOptionPane.ERROR_MESSAGE);
            precioTextField.requestFocus();
            return ;
            
            }else {
            productos.setPrecio(""+precio);
            
            }
            
             if (cantidad.length()== 0){
             JOptionPane.showMessageDialog(
                    this, 
                    "Ingrese la cantidad",
                    "Validacion",
                    JOptionPane.ERROR_MESSAGE);
            precioTextField.requestFocus();
            return ;
            
            }else {
            productos.setCantidad(cantidad);
            
            }
            
            int respuesta = RMI.getIProductosController().add(productos);
            
            if (respuesta == IProductosController.ADD_EXITO){
                JOptionPane.showMessageDialog(
                            this,
                            "producto agregado con EXITO",
                            "Opercación exitosa",
                            JOptionPane.INFORMATION_MESSAGE);
                
                
                dialogParent.dispose();
            
            
            
            }else if (respuesta == IProductosController.ADD_SIN_EXITO){
            JOptionPane.showMessageDialog(
                            this,
                            "No fue posible la operación",
                            "Operación incompleta",
                            JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(PanelAgregarProductos.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
        
        
    }//GEN-LAST:event_aceptarButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarButton;
    private javax.swing.JTextField cantidadTextField;
    private javax.swing.JTextField detallesTextField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField nombreTextField;
    private javax.swing.JTextField precioTextField;
    private javax.swing.JLabel telefonoLabel;
    // End of variables declaration//GEN-END:variables
}
