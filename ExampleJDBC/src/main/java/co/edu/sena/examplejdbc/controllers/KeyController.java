/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.controllers;

import co.edu.sena.examplejdbc.bd.DBKey;
import co.edu.sena.examplejdbc.model.Key;
import java.util.List;

/**
 * Fchea:25/03/2025
 * @author Daniel Albeiro Ortiz Manzanares
 * Objetivo: Implementar la interface para controlar el metodo Key
 */
public class KeyController implements IKeyController{
    
    private DBKey dbk = new DBKey();

    @Override
    public void insert(Key key) throws Exception {
        if(key == null)
        {
            throw new Exception("La llave es nula");
        }
        
        if(key.getId() == 0)
        {
            throw new Exception("El ID es obligatorio");
        }
        
        if("".equals(key.getName()))
        {
            throw new Exception("El nombre es obligatorio");
        }
        
        if("".equals(key.getRoom()))
        {
            throw new Exception("La habitacion es obligaoria");
        }
        
        if(key.getCount() < 1)
        {
            throw new Exception("La cantidad de llaves es incorrecta");
        }
        
        //insertar
        dbk.insert(key);
    }

    @Override
    public void update(Key key) throws Exception {
        if(key == null)
        {
            throw new Exception("La llave es nula");
        }
        
        if(key.getId() == 0)
        {
            throw new Exception("El ID es obligatorio");
        }
        
        if("".equals(key.getName()))
        {
            throw new Exception("El nombre es obligatorio");
        }
        
        if("".equals(key.getRoom()))
        {
            throw new Exception("La habitacion es obligaoria");
        }
        
        if(key.getCount() < 1)
        {
            throw new Exception("La cantidad de llaves es incorrecta");
        }
        
        //consultar si la llave esta en la bd
        Key keyExists = dbk.findById(key.getId());
        if(keyExists == null)
        {
            throw new Exception("La llave no existe");
        }
        
        //actualizar
        dbk.update(key);
    }

    @Override
    public void delete(int id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El ID es obligatorio");
        }
        
         //consultar si la llave esta en la bd
        Key keyExists = dbk.findById(id);
        if(keyExists == null)
        {
            throw new Exception("La llave no existe");
        }
        
        //eliminar
        dbk.delete(id);
    }

    @Override
    public List<Key> findAll() throws Exception {
        return dbk.findAll();
    }

    @Override
    public Key findById(int id) throws Exception {
        if(id == 0)
        {
            throw new Exception("La ID es obligatoria");
        }
        return dbk.findById(id);
    }
}
