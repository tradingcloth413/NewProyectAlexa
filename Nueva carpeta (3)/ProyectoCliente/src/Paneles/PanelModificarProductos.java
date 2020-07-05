
package Paneles;


import Interfaces.IProductos;
import Interfaces.IProductosController;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import proyectocliente.RMI;




public class PanelModificarProductos extends javax.swing.JPanel {

  private IProductos productos;
    private JDialog dialogParent;
    
 
    public PanelModificarProductos (JDialog dialogParent, IProductos productos) throws RemoteException {
        
        initComponents();
        
       this.dialogParent = dialogParent;
        this.productos = productos;
        nombreTextField.setText   (productos.getNombre());
        detallesTextField.setText (productos.getDetalles());
        
        //ENTERO covertida a String
        precioTextField.setText   (String.valueOf(productos.getPrecio()));
        cantidadTextField.setText (String.valueOf(productos.getCantidad()));
    }

   
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombreLabel = new javax.swing.JLabel();
        detallesLabel = new javax.swing.JLabel();
        precioLabel = new javax.swing.JLabel();
        nombreTextField = new javax.swing.JTextField();
        detallesTextField = new javax.swing.JTextField();
        precioTextField = new javax.swing.JTextField();
        aceptarButton = new javax.swing.JButton();
        cantidadLabel = new javax.swing.JLabel();
        cantidadTextField = new javax.swing.JTextField();

        nombreLabel.setText("Nombre:");

        detallesLabel.setText("Detalles");

        precioLabel.setText("Precio");

        aceptarButton.setText("Aceptar");
        aceptarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarButtonActionPerformed(evt);
            }
        });

        cantidadLabel.setText("Cantidad");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(aceptarButton)
                .addGap(36, 36, 36))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreLabel)
                    .addComponent(precioLabel)
                    .addComponent(detallesLabel)
                    .addComponent(cantidadLabel))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cantidadTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(detallesTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                        .addComponent(nombreTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                        .addComponent(precioTextField)))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreLabel)
                    .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(detallesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(detallesLabel))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(precioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(precioLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cantidadTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cantidadLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(aceptarButton)
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarButtonActionPerformed

try {
            String nombre = nombreTextField.getText();
            String detalles = detallesTextField.getText();
            
            
            /////////////////////////////////////////////////////
          
           String cantidad = cantidadTextField.getText();
            String Sprecio= precioTextField.getText();
             double precio = Double.parseDouble(Sprecio);

            if(nombre.length()== 0){
            JOptionPane.showMessageDialog(
                    this, 
                    "Ingrese el nombre",
                    "Validacion",
                    JOptionPane.ERROR_MESSAGE);
            nombreTextField.requestFocus();
            return ;
            }else{
            
            productos.setNombre(nombre);
            
            }
            if (detalles.length() == 0){
                   
                    productos.setDetalles(detalles);
            }else {
            
            productos.setDetalles(null);
            }
            
            if (precio <= 0){
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
            
            if (cantidad.length() == 0){
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
            
            int respuesta = RMI.getIProductosController().update(productos);
            
            if (respuesta == IProductosController.UPDATE_EXITO){
                JOptionPane.showMessageDialog(
                            this,
                            "Producto agregado con EXITO",
                            "Opercaion exitosa",
                            JOptionPane.INFORMATION_MESSAGE);
                dialogParent.dispose(); 
            }else if (respuesta == IProductosController.UPDATE_SIN_EXITO){
            JOptionPane.showMessageDialog(
                            this,
                            "No fue posible la operacion",
                            "Opercaion incompleta",
                            JOptionPane.INFORMATION_MESSAGE);
            }else if (respuesta == IProductosController.UPDATE_INEXISTENTE){
             JOptionPane.showMessageDialog(
                            this,
                            "No fue posible la operacion.\n"
                            +"Persona no encontrada\n",
                            "Operación incompleta",
                            JOptionPane.INFORMATION_MESSAGE);
              dialogParent.dispose(); 
                
            }
        } catch (RemoteException ex) {
            Logger.getLogger(PanelModificarProductos.class.getName()).log(Level.SEVERE, null, ex);
        } 



        
    }//GEN-LAST:event_aceptarButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarButton;
    private javax.swing.JLabel cantidadLabel;
    private javax.swing.JTextField cantidadTextField;
    private javax.swing.JLabel detallesLabel;
    private javax.swing.JTextField detallesTextField;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField nombreTextField;
    private javax.swing.JLabel precioLabel;
    private javax.swing.JTextField precioTextField;
    // End of variables declaration//GEN-END:variables
}
