/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoservidor;

import Interfaces.ICliente;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class Cliente extends UnicastRemoteObject implements ICliente {

    private int id;
    private String nombre;
    private String email;
    private String telefono;
    
    public  Cliente () throws RemoteException{
        
    }

    public Cliente (int id, String nombre, String email, String telefono) throws RemoteException {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public int getId() throws RemoteException{
        return id;
    }

    public void setId(int id) throws RemoteException{
        this.id = id;
    }

    public String getNombre() throws RemoteException{
        return nombre;
    }

    public void setNombre(String nombre) throws RemoteException{
        this.nombre = nombre;
    }

    public String getEmail() throws RemoteException{
        return email;
    }

    public void setEmail(String email) throws RemoteException{
                this.email = email;
    }   

    public String getTelefono() throws RemoteException{
        return telefono;
    }

    public void setTelefono(String telefono) throws RemoteException{
        this.telefono = telefono;
    }
    
    public String getString(){
        return String.format("Id: %d, Nombre: %s, Email: %s, Teléfono: %s", 
                id, nombre, email, telefono);
    }
    
    public static ICliente fromMap(Map<String, Object> map) throws RemoteException{
       
        
        ICliente cliente = new Cliente();
        
        if(map.containsKey("IdCliente")){
            cliente.setId((Integer) map.get("IdCliente"));
        }
            
        if(map.containsKey("Nombre")){
          cliente.setNombre((String) map.get("Nombre"));
        }
            
        if(map.containsKey("Telefono") && map.get("Telefono") != null){
           cliente.setTelefono((String) map.get("Telefono"));
        }
            
        if(map.containsKey("Email")){
            cliente.setEmail((String) map.get("Email"));
        }
            
            return cliente;
    }
    
    public static Map<String, Object> toMap(ICliente cliente) throws RemoteException{
        
        Map<String, Object> datos = new HashMap<>();
        
        if (cliente.getId() != 0){
            datos.put("IdCliente", cliente.getId());
        }
        if(cliente.getNombre() != null){
            datos.put("Nombre", cliente.getNombre());
        }
        if(cliente.getTelefono() != null){
            datos.put("Telefono", cliente.getTelefono());
        }
        if(cliente.getEmail() != null){
            datos.put("Email", cliente.getEmail());
        }
        
        return datos;
    }
    


}
