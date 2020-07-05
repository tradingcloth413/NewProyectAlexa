/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoservidor;

import Interfaces.ICliente;
import Interfaces.IClienteController;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class ClienteController extends UnicastRemoteObject implements IClienteController{

     private DBManager dbManager;
    private final String TABLE = "Cliente";
    
    public ClienteController() throws RemoteException {
        dbManager = new DBManager();
    }
      
    @Override
    public ICliente newInstance() throws RemoteException {
        return new Cliente();
   }

    @Override
    public int add(ICliente cliente) throws RemoteException {
         ICliente clienteEncontrado = findOne(cliente.getId());  
        boolean existe = clienteEncontrado.getId() != 0; 
        
        if (existe) {
            return ADD_ID_DUPLICADO;    
        }
        Map<String, Object> datos  =  Cliente.toMap(cliente);   
        int respuesta = dbManager.insertar(TABLE, datos);
          
        return (respuesta > 0) ? ADD_EXITO: ADD_SIN_EXITO;
   
    }

    @Override
    public int update(ICliente cliente) throws RemoteException {
     if (cliente.getId() == 0) {
            return UPDATE_ID_NULO;
        }
        
      
        ICliente clienteEncontrado = findOne(cliente.getId());
        
        if(clienteEncontrado.getId() == 0){
            return UPDATE_INEXISTENTE;
        }
        
        Map<String, Object> datos = Cliente.toMap(cliente);
        Map<String, Object> where = new HashMap<>();
        where.put("IdCliente", cliente.getId());
        int respuesta = dbManager.actualizar(TABLE, datos, where);
        
        if(respuesta > 0){
            return UPDATE_EXITO;
        }else{
            return UPDATE_SIN_EXITO;
        }
        
        
    }

    @Override
    public int delete(ICliente cliente) throws RemoteException {
          ICliente clienteTemp = findOne (cliente.getId());
        if (clienteTemp.getId()== 0){
        return DELETE_ID_INEXISTENTE; // No existe persona
        }
        
        Map<String, Object> where = new HashMap<>();
        where.put("IdCliente",cliente.getId());
        
        int respuesta = dbManager.eliminar(TABLE, where);
     
        if (respuesta == 0 ){
        return DELETE_SIN_EXITO;
        }else{
        return DELETE_EXITO;
        
        }          
    }

    @Override
    public int delete(int IdCliente) throws RemoteException {
          ICliente cliente= new Cliente();
       cliente.setId(IdCliente);
       return delete(cliente);
    }

    @Override
    public List<ICliente> list() throws RemoteException {
     List<ICliente> listaICliente = new ArrayList<>();
        List<Map<String, Object>> registros = dbManager.listar(TABLE);
        for(Map<String, Object> registro : registros){
            ICliente cliente = Cliente.fromMap(registro);
            listaICliente.add(cliente);
        }
        return listaICliente;  
    }

    @Override
    public ICliente findOne(int idCliente) throws RemoteException {
      Map<String, Object> where = new HashMap<>();
       where.put("IdCliente", idCliente);
       Map<String, Object> registro = dbManager.buscarUno(TABLE, where);
    
    return Cliente.fromMap(registro);    
    
    }

    @Override
    public List<ICliente> find(ICliente cliente) throws RemoteException {
    
        List<ICliente> listaICliente = new ArrayList<>();
        
    Map<String, Object> where = Cliente.toMap( cliente );
    List<Map<String, Object> > registros = dbManager.listar(TABLE, where);
        
        for(Map<String, Object> registro : registros){
            ICliente clienteTemp = Cliente.fromMap(registro);
            listaICliente.add(clienteTemp);
        }
        
        return listaICliente;
    
    
    }

   
    
}
