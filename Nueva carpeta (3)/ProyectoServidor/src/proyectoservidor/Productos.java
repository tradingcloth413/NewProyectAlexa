/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoservidor;

import Interfaces.IProductos;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;


public class Productos extends UnicastRemoteObject implements IProductos {

    private int id;
    private String nombre;
    private String detalles;
    private String precio;
    private String cantidad;
    
    
    public  Productos () throws RemoteException{
        
    }

    public Productos (int id, String nombre, String detalles, String precio, String cantidad) throws RemoteException {
        this.id = id;
        this.nombre = nombre;
        this.detalles = detalles;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    @Override
    public int getId() throws RemoteException {
    return id;   
    
    
    }

    @Override
    public void setId(int id) throws RemoteException {
    this.id=id;    
    
    }

    @Override
    public String getNombre() throws RemoteException {
    return nombre;  
    
    }

    @Override
    public void setNombre(String nombre) throws RemoteException {
    this.nombre=nombre;    
    
    }

    @Override
    public String getDetalles() throws RemoteException {
    return detalles;    
    
    }

    @Override
    public void setDetalles(String detalles) throws RemoteException {
       
    this.detalles=detalles;
        
    }

    @Override
    public String getPrecio() throws RemoteException {
    return precio;    
    
    }

    @Override
    public void setPrecio(String precio) throws RemoteException {
    this.precio = precio;    
    
    }

    @Override
    public String getCantidad() throws RemoteException {
    return cantidad;    
    
    }

    @Override
    public void setCantidad(String cantidad) throws RemoteException {
    this.cantidad=cantidad;   
    
    }

    @Override
    public String getString() throws RemoteException {
       
    return String.format("Id: %d, Nombre: %s, Detalles: %s, Precio: %s, Cantidad: %s", 
                id, nombre, detalles, precio,cantidad);
    
    }
    public static IProductos fromMap(Map<String, Object> map) throws RemoteException{
       
        
        IProductos productos = new Productos();
        
        if(map.containsKey("IdProductos")){
            productos.setId((Integer) map.get("IdProductos"));
        }
            
        if(map.containsKey("Nombre")){
          productos.setNombre((String) map.get("Nombre"));
        }
        
       /* if(map.containsKey("Detalles")){
          productos.setNombre((String) map.get("Detalles"));
        }*/
            
       if(map.containsKey("Detalles")){
           productos.setDetalles((String) map.get("Detalles"));
        }
            
        if(map.containsKey("Precio")){
            productos.setPrecio((String) map.get("Precio"));
        }
        
        if(map.containsKey("Cantidad")){
            productos.setCantidad((String) map.get("Cantidad"));
        }
            
            return productos;
    }
    
    public static Map<String, Object> toMap(IProductos productos) throws RemoteException{
        
        Map<String, Object> datos = new HashMap<>();
        
        if (productos.getId() != 0){
            datos.put("IdProductos", productos.getId());
        }
        if(productos.getNombre() != null){
            datos.put("Nombre", productos.getNombre());
        }
        if(productos.getDetalles() != null){
            datos.put("Detalles", productos.getDetalles());
        }
        if(productos.getPrecio() != null){
            datos.put("Precio", productos.getPrecio());
        }
        if(productos.getCantidad() != null){
            datos.put("Cantidad", productos.getCantidad());
        }
        
        return datos;
    }
    
    
    
    
    
    
    
    
}
