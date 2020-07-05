
package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface IProductos extends Remote {

int getId() throws RemoteException;
   void setId(int id)throws RemoteException;
   
   String getNombre() throws RemoteException;
   void setNombre(String nombre) throws RemoteException;
   
   String getDetalles() throws RemoteException;
   void setDetalles(String detalles) throws RemoteException;
   
   String getPrecio() throws RemoteException;
   void setPrecio(String precio) throws RemoteException;
   
   String getCantidad() throws RemoteException;
   void setCantidad(String cantidad) throws RemoteException;
      
   String getString() throws RemoteException;

    
   


    
}
