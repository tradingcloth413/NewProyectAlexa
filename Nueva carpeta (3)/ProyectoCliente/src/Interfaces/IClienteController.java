/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IClienteController extends Remote {
    
    ICliente newInstance() throws RemoteException;
    
    int add(ICliente  cliente) throws RemoteException;
    int update(ICliente  cliente) throws RemoteException;
    int delete(ICliente  cliente) throws RemoteException;
    int delete (int IdCliente )throws RemoteException;
    List<ICliente > list() throws RemoteException;
    ICliente findOne(int idCliente) throws RemoteException;
     List <ICliente > find(ICliente  cliente) throws RemoteException;
    
    
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
