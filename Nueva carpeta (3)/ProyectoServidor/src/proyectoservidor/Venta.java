/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoservidor;

import Interfaces.IVenta;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class Venta extends UnicastRemoteObject implements IVenta {

    private int id;
    private int idcliente;
    private int idproductos;
    private String fecha;
    private String producto;
    private String total;
    private String cantidad;
    
    
    public  Venta () throws RemoteException{
        
    }

    public Venta (int id, int idcliente,int idproductos,String fecha, String producto, String total, String cantidad) throws RemoteException {
        this.id = id;
        this.idcliente = idcliente;
        this.idproductos= idproductos;
        this.fecha = fecha;
        this.producto = producto;
        this.total =total;
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
    public int getIdProductos() throws RemoteException {
    return idproductos;  
    }
    
    @Override
    public void setIdProductos(int idproductos) throws RemoteException {
        this.idproductos= idproductos;
    }
    
    @Override
    public int getIdCliente() throws RemoteException {
    return idcliente;    
    }

    @Override
    public void setIdCliente(int idcliente) throws RemoteException {
    this.idcliente = idcliente;   
    }
    
    @Override
    public String getFecha() throws RemoteException {
      return fecha;
    
    }

    @Override
    public void setFecha(String fecha) throws RemoteException { 
    this.fecha= fecha;
    }

    @Override
    public String getProducto() throws RemoteException {
    return producto;   
    
    }

    @Override
    public void setProducto(String producto) throws RemoteException {
    this.producto=producto;   
    
    }

    @Override
    public String getTotal() throws RemoteException {
        
    return total;
    }

    @Override
    public void setTotal(String total) throws RemoteException {
    this.total=total;   
    
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
        
    return String.format("Id: %d, IdCliente: %d, IdProductos: %d ,Fecha: %s, Producto: %s,Total: %s,Cantidad: %s", 
                id, idcliente, idproductos ,fecha,total,cantidad);
    
    }

    public static IVenta fromMap(Map<String, Object> map) throws RemoteException{
       
        
        IVenta venta = new Venta();
        
        if(map.containsKey("IdVenta")){
            venta.setId((Integer) map.get("IVenta"));
        }
            
        if(map.containsKey("IdCliente")){
          venta.setIdCliente((Integer) map.get("IdCliente"));
        }
        
          if(map.containsKey("IdProductos")){
          venta.setIdCliente((Integer) map.get("IdProductos"));
        }
            
        if(map.containsKey("Fecha") && map.get("Fecha") != null){
           venta.setFecha((String) map.get("Fecha"));
        }
        
        if(map.containsKey("Producto")){
            venta.setProducto((String) map.get("Producto"));
        }
         if(map.containsKey("Total")){
            venta.setTotal((String) map.get("Total"));
        }
        
        if(map.containsKey("Cantidad")){
            venta.setCantidad((String) map.get("Cantidad"));
        }
            
            return venta;
    }
    
    public static Map<String, Object> toMap(IVenta venta) throws RemoteException{
        
        Map<String, Object> datos = new HashMap<>();
        
        if (venta.getId() != 0){
            datos.put("IdVenta", venta.getId());
        }
        if(venta.getIdCliente() != 0){
            datos.put("IdCliente", venta.getIdCliente());
        }
        
        if(venta.getIdProductos() != 0){
            datos.put("IdProductos", venta.getIdProductos());
        }
        if(venta.getFecha() != null){
            datos.put("Fecha", venta.getFecha());
        }
        if(venta.getProducto() != null){
            datos.put("Precio", venta.getProducto());
        }
        if(venta.getTotal() != null){
            datos.put("Total", venta.getTotal());
        }
        if(venta.getCantidad() != null){
            datos.put("Cantidad", venta.getCantidad());
        }
        
        return datos;
    }

    
}