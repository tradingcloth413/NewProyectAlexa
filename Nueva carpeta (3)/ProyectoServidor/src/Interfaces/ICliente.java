/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICliente extends Remote{
 
   int getId() throws RemoteException;
   void setId(int id)throws RemoteException;
   
   String getNombre() throws RemoteException;
   void setNombre(String nombre) throws RemoteException;
   
   String getEmail() throws RemoteException;
   void setEmail(String email) throws RemoteException;
   
   String getTelefono() throws RemoteException;
   void setTelefono(String telefono) throws RemoteException;
   
   String getString() throws RemoteException;
    
    
}
