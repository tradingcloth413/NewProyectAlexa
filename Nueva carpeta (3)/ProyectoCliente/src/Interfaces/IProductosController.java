/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


public interface IProductosController extends Remote {
    IProductos newInstance() throws RemoteException;
    
    int add(IProductos  productos) throws RemoteException;
    int update(IProductos  productos) throws RemoteException;
    int delete(IProductos  productos) throws RemoteException;
    int delete (int IdProductos )throws RemoteException;
    List<IProductos > list() throws RemoteException;
    IProductos findOne(int idProductos) throws RemoteException;
     List <IProductos > find(IProductos  productos) throws RemoteException;
    
    
    int ADD_EXITO          = 1;
    int ADD_ID_DUPLICADO   = 2;
    int ADD_SIN_EXITO      = 3;
    
    int UPDATE_EXITO       = 1;
    int UPDATE_INEXISTENTE = 2;
    int UPDATE_ID_NULO     = 3;
    int UPDATE_SIN_EXITO   = 4;
    
    int DELETE_EXITO         = 1;
    int DELETE_ID_INEXISTENTE =2; 
    int DELETE_ID_NULO       =3;
    int DELETE_SIN_EXITO     =4;
}
