package proyectoservidor;

import Interfaces.IProductosController;
import Interfaces.IVentaController;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ProyectoServidor {

    
    public static void main(String[] args) {
        
          try {    
            LocateRegistry.createRegistry(1099);
            IProductosController productosController = new ProductosController();
            Naming.rebind("rmi://localhost/ProductosController",  productosController);
             IVentaController ventaController = new VentaController();
            Naming.rebind("rmi://localhost/VentaController",  productosController);
            System.out.println("Escuchando...");
        } catch (RemoteException ex) {
            Logger.getLogger(ProyectoServidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ProyectoServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
           
            
         
    }
    
}
