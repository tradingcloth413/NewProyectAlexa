/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoservidor;

import Interfaces.IVenta;
import Interfaces.IVentaController;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tress
 */
public class VentaController extends UnicastRemoteObject implements IVentaController {
    
     private DBManager dbManager;
    private final String TABLE = "Venta";
    
    public VentaController() throws RemoteException {
        dbManager = new DBManager();
    }

    @Override
    public IVenta newInstance() throws RemoteException {
    return new Venta();   
    
    }

    @Override
    public int add(IVenta venta) throws RemoteException {
    IVenta ventaEncontrado = findOne(venta.getId());  
        boolean existe = ventaEncontrado.getId() != 0; 
        
        if (existe) {
            return ADD_ID_DUPLICADO;    
        }
        Map<String, Object> datos  =  Venta.toMap(venta);   
        int respuesta = dbManager.insertar(TABLE, datos);
          
        return (respuesta > 0) ? ADD_EXITO: ADD_SIN_EXITO;   
    
    }

    @Override
    public int update(IVenta venta) throws RemoteException {
         if (venta.getId() == 0) {
            return UPDATE_ID_NULO;
         }
         
         IVenta ventaEncontrado = findOne(venta.getId());
        
        if(ventaEncontrado.getId() == 0){
            return UPDATE_INEXISTENTE;
        }
        
        Map<String, Object> datos = Venta.toMap(venta);
        Map<String, Object> where = new HashMap<>();
        where.put("IdVenta", venta.getId());
        int respuesta = dbManager.actualizar(TABLE, datos, where);
        
        if(respuesta > 0){
            return UPDATE_EXITO;
        }else{
            return UPDATE_SIN_EXITO;
        }
         
         
    }

    @Override
    public int delete(IVenta venta) throws RemoteException {
        IVenta ventaTemp = findOne (venta.getId());
        if (ventaTemp.getId()== 0){
        return DELETE_ID_INEXISTENTE;
        }
        
        
        Map<String, Object> where = new HashMap<>();
        where.put("IdVenta",venta.getId());
        
        int respuesta = dbManager.eliminar(TABLE, where);
     
        if (respuesta == 0 ){
        return DELETE_SIN_EXITO;
        }else{
        return DELETE_EXITO;
        
        }       
    }

    @Override
    public int delete(int IdVenta) throws RemoteException {
      
     IVenta venta= new Venta();
       venta.setId(IdVenta);
       return delete(venta);
    
    }

    @Override
    public List<IVenta> list() throws RemoteException {
       List<IVenta> listaIVenta = new ArrayList<>();
        List<Map<String, Object>> registros = dbManager.listar(TABLE);
        for(Map<String, Object> registro : registros){
            IVenta venta = Venta.fromMap(registro);
            listaIVenta.add(venta);
        }
        return listaIVenta;  
    
    }

    @Override
    public IVenta findOne(int idVenta) throws RemoteException {
    Map<String, Object> where = new HashMap<>();
       where.put("IdVenta", idVenta);
       Map<String, Object> registro = dbManager.buscarUno(TABLE, where);
    
    return Venta.fromMap(registro);     
    
    
    }

    @Override
    public List<IVenta> find(IVenta venta) throws RemoteException {
              List<IVenta> listaIVenta = new ArrayList<>();
        
    Map<String, Object> where = Venta.toMap( venta );
    List<Map<String, Object> > registros = dbManager.listar(TABLE, where);
        
        for(Map<String, Object> registro : registros){
            IVenta ventaTemp = Venta.fromMap(registro);
            listaIVenta.add(ventaTemp);
        }
        
        return listaIVenta;
     
    
    
    }
    
}
