
package Paneles;


import Interfaces.IProductos;
import java.rmi.RemoteException;

public class DialogModificarProductos extends javax.swing.JDialog {

   
    public DialogModificarProductos(java.awt.Frame parent, boolean modal,IProductos productos) throws RemoteException {
        super(parent, modal);
        initComponents();
        getContentPane().add(new PanelModificarProductos(this, productos));
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(350, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
