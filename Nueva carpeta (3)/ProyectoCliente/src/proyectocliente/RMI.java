
package proyectocliente;
import Interfaces.IClienteController;
import Interfaces.IProductosController;
import Interfaces.IVentaController;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectocliente.RMI;


public class RMI {
    
    private static   IProductosController productosController;
    
    public static IProductosController getIProductosController(){
    
        try {
            if(productosController == null){
             productosController =
                    (IProductosController) Naming.lookup("rmi://localhost/ProductosController");
            }
            
        } catch (NotBoundException ex) {
            Logger.getLogger(RMI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(RMI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(RMI.class.getName()).log(Level.SEVERE, null, ex);
        }
          return productosController;
    } 
    
    
     private static   IVentaController ventaController;
    
    public static IVentaController getIVentaController(){
    
        try {
            if(ventaController == null){
             ventaController =
                    (IVentaController) Naming.lookup("rmi://localhost/VentaController");
            }
          return ventaController;
     
        } catch (NotBoundException ex) {
            Logger.getLogger(RMI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(RMI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(RMI.class.getName()).log(Level.SEVERE, null, ex);
        }
    return ventaController;
          
    } 
    
    
}
