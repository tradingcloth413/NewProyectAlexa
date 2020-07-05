
package Paneles;


import Interfaces.IProductos;
import Interfaces.IProductos;
import Interfaces.IProductosController;
import Interfaces.IProductosController;
import Interfaces.IVenta;
import java.awt.Dialog;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyectocliente.RMI;


public class PanelVerVenta extends javax.swing.JPanel {
private static  String ID          = "ID";
private static  String IDPRODUCTOS = "IdProductos";
private static  String  FECHA      = "Fecha";
private static  String  PRODUCTO   = "Producto";
private static  String  TOTAL      = "Total";
private static  String  CANTIDAD   = "Cantidad";   
   


    
    public PanelVerVenta() {
        initComponents();
         refrescarTabla();
    
    }

 public void refrescarTabla  (){
 
     try {
            
            Vector <Vector> datos = new Vector<>();
            
            String texto = buscarTextField.getText();
            List<IVenta> listVenta;
            if (texto.length() == 0){
            listVenta = RMI.getIVentaController().list();
            }else{
                    IVenta venta = RMI.getIVentaController().newInstance();
                   String columna = columnasComboBox.getSelectedItem().toString();
              
           if (columna.compareTo(ID) == 0){
          try{    
               venta.setId(Integer.parseInt(texto));
               }catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            this,"Se requiere un valor númerico",
                            "Número requerido",
                            JOptionPane.ERROR_MESSAGE
                    );
                    return;
               }}
            
          
                  if (columna.compareTo(IDPRODUCTOS) == 0){
                  try{    
               venta.setIdProductos (Integer.parseInt(texto));
               }catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            this,"Se requiere un valor númerico",
                            "Número requerido",
                            JOptionPane.ERROR_MESSAGE
                    );
                    return;
               }   
                  }
           
           else if (columna.compareTo(FECHA)==0){
                   venta.setFecha(texto);
                   }else if (columna.compareTo(PRODUCTO)==0) {
                    venta.setProducto(texto);
                   }else if (columna.compareTo(TOTAL) == 0){
                    venta.setTotal(texto);
                   }else if (columna.compareTo(CANTIDAD) == 0){
                    venta.setCantidad(texto);
                   }
                    listVenta = RMI.getIVentaController().find(venta);
            }
            for(IVenta venta : listVenta){
                Vector registro = new Vector();
                registro.add(venta.getId());
                registro.add(venta.getFecha());
                registro.add(venta.getProducto());
                registro.add(venta.getTotal());
                registro.add(venta.getCantidad());
                
                datos.add(registro);
        
        }      
            Vector < String > columnas = new Vector<>(); 
            columnas.add("ID");
            columnas.add("Idproductos");
            columnas.add("Nombre");
            columnas.add("Detalles");
            columnas.add("Precio");
            columnas.add("Cantidad");
            
            personasTable.setModel ( new javax.swing.table.DefaultTableModel( datos, columnas));
        } catch (RemoteException ex) {
            Logger.getLogger(PanelVerVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     
 
 }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        personasTable = new javax.swing.JTable();
        columnasComboBox = new javax.swing.JComboBox<>();
        buscarTextField = new javax.swing.JTextField();
        BuscarButton = new javax.swing.JButton();
        ModificarButton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        EliminarButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        personasTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(personasTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 450, 160));

        columnasComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "IdProductos", "Nombre" }));
        add(columnasComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 20, 70, 30));

        buscarTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarTextFieldActionPerformed(evt);
            }
        });
        add(buscarTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 260, 30));

        BuscarButton.setText("Buscar");
        BuscarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarButtonActionPerformed(evt);
            }
        });
        add(BuscarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 80, 30));

        ModificarButton.setText("Modificar");
        ModificarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarButtonActionPerformed(evt);
            }
        });
        add(ModificarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, -1, -1));

        jButton3.setText("Agregar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        EliminarButton.setText("Eliminar");
        EliminarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarButtonActionPerformed(evt);
            }
        });
        add(EliminarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void buscarTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarTextFieldActionPerformed
        
    }//GEN-LAST:event_buscarTextFieldActionPerformed

    private void ModificarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarButtonActionPerformed
        try {
        int filaSeleccionada = personasTable.getSelectedRow();
        if (filaSeleccionada == -1){
            return;
        }
        int idProductos =  (Integer) personasTable.getValueAt(filaSeleccionada, 0);
        IProductos productos = RMI.getIProductosController().findOne(idProductos);
       if(productos.getId() == 0){
           JOptionPane.showMessageDialog(this,
                  "Producto no encontrado.\n"
                    +"Es probable que el producto haya sido eliminada previamente",
                  "producto no encontrado",
                  JOptionPane.ERROR_MESSAGE);
           refrescarTabla();
           return;
       }
        DialogModificarProductos dialogModificarProductos = new DialogModificarProductos(null, true, productos);
        dialogModificarProductos.setLocationRelativeTo(this);
        dialogModificarProductos.setVisible(true);        
        refrescarTabla();
    } catch (RemoteException ex) {
        Logger.getLogger(PanelVerVenta.class.getName()).log(Level.SEVERE, null, ex);
}     
    }//GEN-LAST:event_ModificarButtonActionPerformed

    private void EliminarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarButtonActionPerformed
   try {
        int filaSeleccionada = personasTable.getSelectedRow();
        if (filaSeleccionada == -1){
            return;
        }   
       int confirmacion = JOptionPane.showConfirmDialog(this,
                "Usted esta a punto de eliminar un producto \n"+
                "¿Esta seguro de eliminar el producto? "
                ,"Eliminar producto",
                JOptionPane.YES_NO_OPTION);
       if (confirmacion != JOptionPane.YES_OPTION){
       return;
       }
        
        int idProductos = (int) personasTable.getValueAt(filaSeleccionada ,0); 
      int respuesta =  RMI.getIProductosController().delete(idProductos);
      
      if(respuesta == IProductosController.DELETE_EXITO){
          JOptionPane.showMessageDialog(
                  this,
                  "Producto elimnado con éxito",
                  "Operacion exitosa",
                  JOptionPane.INFORMATION_MESSAGE);
          refrescarTabla();
      }else if ( respuesta == IProductosController.DELETE_ID_INEXISTENTE){
          JOptionPane.showMessageDialog(this,
                  "Producto no encontrado.\n"
                       +"Es posible que el producto haya sido eliminada previamente",
                  "Producto no encontrada",
                  JOptionPane.ERROR_MESSAGE);
      
      }else{
            JOptionPane.showMessageDialog(this,
                  "Producto incompleto.\n no fue " ,
                  "Producto no incompleto.",
                  JOptionPane.ERROR_MESSAGE);
      }
    } catch (RemoteException ex) {
        Logger.getLogger(PanelVerVenta.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_EliminarButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        
              
        DialogAgregarProductos dialogAgregarProductos = new DialogAgregarProductos(null, true);
       dialogAgregarProductos.setLocationRelativeTo(this);
        dialogAgregarProductos.setVisible(true);
        refrescarTabla();
        
        
        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void BuscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarButtonActionPerformed
   
          refrescarTabla();
        
        
        
    }//GEN-LAST:event_BuscarButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuscarButton;
    private javax.swing.JButton EliminarButton;
    private javax.swing.JButton ModificarButton;
    private javax.swing.JTextField buscarTextField;
    private javax.swing.JComboBox<String> columnasComboBox;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable personasTable;
    // End of variables declaration//GEN-END:variables
}
