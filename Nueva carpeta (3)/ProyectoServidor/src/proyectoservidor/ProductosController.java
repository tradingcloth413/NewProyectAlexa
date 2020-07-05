
package proyectoservidor;


import Interfaces.IProductos;
import Interfaces.IProductosController;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ProductosController extends UnicastRemoteObject implements IProductosController{
    
     private DBManager dbManager;
    private final String TABLE = "Productos";
    
    public ProductosController() throws RemoteException {
        dbManager = new DBManager();
    }

    @Override
    public IProductos newInstance() throws RemoteException {
   return new Productos(); 
    }

    @Override
    public int add(IProductos productos) throws RemoteException {
    IProductos productoEncontrado = findOne(productos.getId());  
        boolean existe = productoEncontrado.getId() != 0; 
        
        if (existe) {
            return ADD_ID_DUPLICADO;    
        }
        Map<String, Object> datos  =  Productos.toMap(productos);   
        int respuesta = dbManager.insertar(TABLE, datos);
          
        return (respuesta > 0) ? ADD_EXITO: ADD_SIN_EXITO;
       
    
    }

    @Override
    public int update(IProductos productos) throws RemoteException {
         if (productos.getId() == 0) {
            return UPDATE_ID_NULO;
        }
        
      
        IProductos productoEncontrado = findOne(productos.getId());
        
        if(productoEncontrado.getId() == 0){
            return UPDATE_INEXISTENTE;
        }
        
        Map<String, Object> datos = Productos.toMap(productos);
        Map<String, Object> where = new HashMap<>();
        where.put("IdProductos", productos.getId());
        int respuesta = dbManager.actualizar(TABLE, datos, where);
        
        if(respuesta > 0){
            return UPDATE_EXITO;
        }else{
            return UPDATE_SIN_EXITO;
        }
    
    }

    @Override
    public int delete(IProductos productos) throws RemoteException {
      IProductos productosTemp = findOne (productos.getId());
        if (productosTemp.getId()== 0){
        return DELETE_ID_INEXISTENTE; // No existe persona
        }
        
        Map<String, Object> where = new HashMap<>();
        where.put("IdProductos",productos.getId());
        
        int respuesta = dbManager.eliminar(TABLE, where);
     
        if (respuesta == 0 ){
        return DELETE_SIN_EXITO;
        }else{
        return DELETE_EXITO;
        
        }       
    
    }

    @Override
    public int delete(int IdProductos) throws RemoteException {
       
       IProductos productos= new Productos();
       productos.setId(IdProductos);
       return delete(productos);
        
    }

    @Override
    public List<IProductos> list() throws RemoteException {
      List<IProductos> listaIProductos = new ArrayList<>();
        List<Map<String, Object>> registros = dbManager.listar(TABLE);
        for(Map<String, Object> registro : registros){
            IProductos productos = Productos.fromMap(registro);
            listaIProductos.add(productos);
        }
        return listaIProductos;  
    
    }

    @Override
    public IProductos findOne(int idProductos) throws RemoteException {
    
       Map<String, Object> where = new HashMap<>();
       where.put("IdProductos", idProductos);
       Map<String, Object> registro = dbManager.buscarUno(TABLE, where);
    
    return Productos.fromMap(registro);     
        
    }

    @Override
    public List<IProductos> find(IProductos productos) throws RemoteException {
    
                List<IProductos> listaIProductos = new ArrayList<>();
        
    Map<String, Object> where = Productos.toMap(productos);
    List<Map<String, Object> > registros = dbManager.listar(TABLE, where);
        
        for(Map<String, Object> registro : registros){
            IProductos productosTemp = Productos.fromMap(registro);
            listaIProductos.add(productosTemp);
        }
        
        return listaIProductos;
    
    }
  
    
    
    
    
}
