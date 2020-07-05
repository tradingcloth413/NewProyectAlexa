package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IVenta extends Remote {
    
    
    int getId() throws RemoteException;
   void setId(int id)throws RemoteException;
   
   int getIdCliente() throws RemoteException;
   void setIdCliente(int idcliente)throws RemoteException;
   
   int getIdProductos() throws RemoteException;
   void setIdProductos(int idcliente)throws RemoteException;
   
   String getFecha() throws RemoteException;
   void setFecha(String fecha) throws RemoteException;
   
  
   String getProducto() throws RemoteException;
   void setProducto(String producto) throws RemoteException;
   
   String getTotal() throws RemoteException;
   void setTotal (String total) throws RemoteException;

   
   String getCantidad() throws RemoteException;
   void setCantidad (String cantidad) throws RemoteException;
   
   
   String getString() throws RemoteException;
    
}
